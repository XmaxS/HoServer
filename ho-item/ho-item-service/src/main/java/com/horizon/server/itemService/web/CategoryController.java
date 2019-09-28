package com.horizon.server.itemService.web;

import com.horizon.server.itemInterface.pojo.Category;
import com.horizon.server.itemService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点Id查询分类
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam("pid") Long pid){
        return ResponseEntity.ok(categoryService.queryCategoryByPid(pid));
    }

    /**
     * 根据分类的Ids查询分类
     * @param ids
     * @return
     */
    @GetMapping("list/cids")
    public ResponseEntity<List<Category>> queryCategoryByCids(@RequestParam("cids") List<Long> cids){
        return ResponseEntity.ok(categoryService.queryCategoryByCids(cids));
    }
}
