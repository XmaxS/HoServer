package com.horizon.server.itemService.web;

import com.horizon.server.itemInterface.pojo.Store;
import com.horizon.server.itemInterface.vo.StoreVo;
import com.horizon.server.itemService.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/insert")
    public ResponseEntity<Integer> insertStore(@RequestBody Store store , @RequestParam("cids") List<Long> cids){
        return ResponseEntity.ok(storeService.insertStore(store,cids));
    }

    /**
     * 更新店铺
     * @param storeVo
     */
    @PutMapping("/update")
    public ResponseEntity<Integer> updateStore(@RequestBody StoreVo storeVo){
        return ResponseEntity.ok(storeService.updateStore(storeVo));
    }

    /**
     * 删除店铺
     * @param sid
     */
    @DeleteMapping("/delete/sid/{sid}")
    public ResponseEntity<Integer> deleteStore(@PathVariable("sid") Long sid){
        return ResponseEntity.ok(storeService.deleteStore(sid));
    }

    /**
     * 根据分类Id查询店铺
     * @param cid
     * @return
     */
    @GetMapping("/query/cid/{cid}")
    public ResponseEntity<List<Store>> queryStoreByCid(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(storeService.queryStoreByCid(cid));
    }

    /**
     * 根据店铺Id查询店铺
     * @param sid
     * @return
     */
    @GetMapping("/query/{sid}")
    public ResponseEntity<Store> queryStoreBySid(@PathVariable("sid") Long sid){
        return ResponseEntity.ok(storeService.queryStoreBySid(sid));
    }

    /**
     * 根据店铺ids查询店铺
     * @param sids
     * @return
     */
    @GetMapping("/query/list")
    public ResponseEntity<List<Store>> queryStoreBySids(@RequestParam("sids") List<Long> sids){
        return ResponseEntity.ok(storeService.queryStoreBySids(sids));
    }

}
