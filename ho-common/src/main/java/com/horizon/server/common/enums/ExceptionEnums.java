package com.horizon.server.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {

    Store_CREATE_FAILED(500, "新增店铺失败"),
    UPDATE_STORE_FAILED(500, "店铺更新失败"),
    DELETE_STORE_EXCEPTION(500, "删除店铺失败"),
    STORE_NOT_FOUND(404, "店铺查询失败"),
    ;
    private int code;
    private String msg;
}
