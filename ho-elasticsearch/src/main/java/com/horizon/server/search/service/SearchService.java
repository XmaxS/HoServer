package com.horizon.server.search.service;

import com.horizon.server.itemInterface.pojo.Store;
import com.horizon.server.search.pojo.IndexStore;
import com.horizon.server.search.client.StoreClient;
import com.horizon.server.search.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class SearchService {

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private StoreRepository storeRepository;

    /**
     * 插入或更新索引
     * @param sid
     */
    @Transactional
    public void insertOrUpdate(Long sid){

        Store store = storeClient.queryStoreBySid(sid);
        if (store == null){
            log.error("索引对应的店铺不存在,storeId:{}",sid);
            throw new RuntimeException();
        }

        IndexStore indexStore = new IndexStore();

        indexStore.setId(store.getId());
        indexStore.setName(store.getName());
        indexStore.setImage(store.getImage());
        indexStore.setCreateTime(store.getCreateTime());
        indexStore.setLetter(store.getLetter());
        indexStore.setLongitude(store.getLongitude());
        indexStore.setLatitude(store.getLatitude());

        storeRepository.save(indexStore);

    }

    /**
     * 删除索引
     * @param sid
     */
    public void delete(Long sid){
        storeRepository.deleteById(sid);
    }

}
