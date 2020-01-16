package com.horizon.server.itemInterface.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_pic")
public class Picpro {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String point;

    private String kind;

}
