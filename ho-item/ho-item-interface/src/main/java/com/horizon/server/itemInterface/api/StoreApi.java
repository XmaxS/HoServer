package com.horizon.server.itemInterface.api;

import com.horizon.server.itemInterface.pojo.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StoreApi {

    @GetMapping("store/{sid}")
    Store queryStoreBySid(@PathVariable("sid") Long sid);

    @GetMapping("store/list")
    List<Store> queryStoresBySids(@RequestParam("sids") List<Long> sids);
}
