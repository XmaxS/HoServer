package com.horizon.server.itemService.service.impl;

import com.horizon.server.common.enums.ExceptionEnums;
import com.horizon.server.common.exception.HoException;
import com.horizon.server.itemInterface.pojo.Store;
import com.horizon.server.itemInterface.vo.StoreVo;
import com.horizon.server.itemService.mapper.StoreMapper;
import com.horizon.server.itemService.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.util.List;

@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Transactional
    @Override
    public Integer insertStore(Store store, List<Long> cids) {
        store.setId(null);
        int resultCount = storeMapper.insert(store);
        if (resultCount == 0){
            throw new HoException(ExceptionEnums.Store_CREATE_FAILED);
        }
//        更新店铺分类表
        for (Long cid : cids){
            resultCount = storeMapper.insertCategoryStore(cid,store.getId());
            if (resultCount == 0){
                throw new HoException(ExceptionEnums.Store_CREATE_FAILED);
            }
        }

        sendMessage(store.getId(),"insert");

        return resultCount;
    }

    @Transactional
    @Override
    public Integer updateStore(StoreVo storeVo) {

        Store store = new Store();
        store.setId(storeVo.getId());
        store.setName(storeVo.getName());
        store.setImage(storeVo.getImage());
        store.setLetter(storeVo.getLetter());
        store.setLongitude(storeVo.getLongitude());
        store.setLatitude(storeVo.getLatitude());
        store.setCreateTime(storeVo.getCreateTime());

//        更新
        int resultCount = storeMapper.updateByPrimaryKey(store);
        if (resultCount == 0){
            throw new HoException(ExceptionEnums.UPDATE_STORE_FAILED);
        }
        List<Long> cids = storeVo.getCids();

//        更新品牌分类表
        storeMapper.deleteCategoryStoreBySid(storeVo.getId());
        for (Long cid : cids){
            resultCount = storeMapper.insertCategoryStore(cid,storeVo.getId());
            if (resultCount == 0){
                throw new HoException(ExceptionEnums.UPDATE_STORE_FAILED);
            }
        }

        sendMessage(store.getId(),"update");

        return resultCount;

    }

    @Transactional
    @Override
    public Integer deleteStore(Long sid) {

        int resultCount = storeMapper.deleteByPrimaryKey(sid);
        if (resultCount == 0){
            throw new HoException(ExceptionEnums.DELETE_STORE_EXCEPTION);
        }

//        删除中间表
        resultCount = storeMapper.deleteCategoryStoreBySid(sid);
        if (resultCount == 0){
            throw new HoException(ExceptionEnums.DELETE_STORE_EXCEPTION);
        }

        sendMessage(sid,"delete");

        return resultCount;

    }

    @Override
    public List<Store> queryStoreByCid(Long cid) {

        List<Store> storeList = storeMapper.queryStoreByCid(cid);
        if (CollectionUtils.isEmpty(storeList)){
            throw new HoException(ExceptionEnums.STORE_NOT_FOUND);
        }
        return storeList;
    }

    @Override
    public Store queryStoreBySid(Long sid) {

        Store store1 = new Store();
        store1.setId(sid);
        Store store = storeMapper.selectByPrimaryKey(store1);
        if (store == null){
            throw new HoException(ExceptionEnums.STORE_NOT_FOUND);
        }
        return store;
    }

    @Override
    public List<Store> queryStoreBySids(List<Long> sids) {

        List<Store> storeList = storeMapper.selectByIdList(sids);
        if (CollectionUtils.isEmpty(storeList)){
            throw new HoException(ExceptionEnums.STORE_NOT_FOUND);
        }
        return storeList;
    }

    /**
     * 封装发送到消息队列的方法
     * @param id
     * @param type
     */
    private void sendMessage(Long id, String type){
        try {
            amqpTemplate.convertAndSend("item" + type, id);
        }catch (Exception e){
            log.error("{}店铺消息发送异常，店铺ID：{}",type,id,e);
        }
    }

}
