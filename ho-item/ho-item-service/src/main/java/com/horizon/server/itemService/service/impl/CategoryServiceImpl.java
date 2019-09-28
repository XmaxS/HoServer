package com.horizon.server.itemService.service.impl;

import com.horizon.server.common.enums.ExceptionEnums;
import com.horizon.server.common.exception.HoException;
import com.horizon.server.itemInterface.pojo.Category;
import com.horizon.server.itemService.mapper.CategoryMapper;
import com.horizon.server.itemService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryByPid(Long pid) {

        Category category = new Category();
        category.setParentId(pid);
        List<Category> categoryList = categoryMapper.select(category);
        if (CollectionUtils.isEmpty(categoryList)){
            throw new HoException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }
        return categoryList;
    }

    @Override
    public List<Category> queryCategoryByCids(List<Long> cids) {

        return categoryMapper.selectByIdList(cids);
    }
}
