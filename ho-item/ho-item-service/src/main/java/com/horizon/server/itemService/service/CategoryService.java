package com.horizon.server.itemService.service;

import com.horizon.server.itemInterface.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> queryCategoryByPid(Long pid);

    List<Category> queryCategoryByCids(List<Long> cids);

}
