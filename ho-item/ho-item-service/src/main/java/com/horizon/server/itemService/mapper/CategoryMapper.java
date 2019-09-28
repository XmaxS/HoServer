package com.horizon.server.itemService.mapper;

import com.horizon.server.common.mapper.BaseMapper;
import com.horizon.server.itemInterface.pojo.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper extends BaseMapper<Category,Long> {
}
