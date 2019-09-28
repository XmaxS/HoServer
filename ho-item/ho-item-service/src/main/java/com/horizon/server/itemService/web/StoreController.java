package com.horizon.server.itemService.web;

import com.horizon.server.itemInterface.pojo.Store;
import com.horizon.server.itemInterface.vo.StoreVo;
import com.horizon.server.itemService.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 新增店铺
     * @param store
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> insertStore(Store store , @RequestParam("cids") List<Long> cids){
        storeService.insertStore(store,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新店铺
     * @param storeVo
     */
    @PutMapping
    public ResponseEntity<Void> updateStore(StoreVo storeVo){
        storeService.updateStore(storeVo);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除店铺
     * @param sid
     */
    @DeleteMapping("sid/{sid}")
    public ResponseEntity<Void> deleteStore(@PathVariable("sid") Long sid){
        storeService.deleteStore(sid);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据分类Id查询店铺
     * @param cid
     * @return
     */
    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Store>> queryStoreByCid(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(storeService.queryStoreByCid(cid));
    }

    /**
     * 根据店铺Id查询店铺
     * @param sid
     * @return
     */
    @GetMapping("{sid}")
    public ResponseEntity<Store> queryStoreBySid(@PathVariable("sid") Long sid){
        return ResponseEntity.ok(storeService.queryStoreBySid(sid));
    }

    /**
     * 根据店铺ids查询店铺
     * @param sids
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Store>> queryStoreBySids(@RequestParam("sids") List<Long> sids){
        return ResponseEntity.ok(storeService.queryStoreBySids(sids));
    }

}
