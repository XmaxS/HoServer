package com.horizon.server.common.mapper;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

@RegisterMapper
public interface BaseMapper<T,PK> extends Mapper<T>, IdListMapper<T,PK>, InsertListMapper<T> {
}
