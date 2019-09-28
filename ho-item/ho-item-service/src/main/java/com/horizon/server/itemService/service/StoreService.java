package com.horizon.server.itemService.service;

import com.horizon.server.itemInterface.pojo.Store;
import com.horizon.server.itemInterface.vo.StoreVo;

import java.util.List;

public interface StoreService {

    void insertStore(Store store , List<Long> cids);

    void updateStore(StoreVo storeVo);

    void deleteStore(Long sid);

    List<Store> queryStoreByCid(Long cid);

    Store queryStoreBySid(Long sid);

    List<Store> queryStoreBySids(List<Long> sids);
}
