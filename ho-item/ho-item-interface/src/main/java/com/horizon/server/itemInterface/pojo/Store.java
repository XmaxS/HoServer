package com.horizon.server.itemInterface.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_store")
public class Store {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String image;
    private Character letter;
    private Double longitude;
    private Double latitude;
}
