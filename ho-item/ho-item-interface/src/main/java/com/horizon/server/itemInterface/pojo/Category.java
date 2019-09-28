package com.horizon.server.itemInterface.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

//类别类
@Data
@Table(name = "tb_category")
public class Category {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Long parentId; //父节点ID
    private Boolean isParent; //该节点是否为父节点
    private Integer sort; //排序，第几级，顶级为1
}
