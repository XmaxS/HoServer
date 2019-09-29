package com.horizon.server.itemService.service;

import com.horizon.server.itemInterface.pojo.Store;
import com.horizon.server.itemInterface.vo.StoreVo;

import java.util.List;

public interface StoreService {

    Integer insertStore(Store store , List<Long> cids);

    Integer updateStore(StoreVo storeVo);

    Integer deleteStore(Long sid);

    List<Store> queryStoreByCid(Long cid);

    Store queryStoreBySid(Long sid);

    List<Store> queryStoreBySids(List<Long> sids);
}
