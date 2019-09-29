package com.horizon.server.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "store", type = "docs" ,shards = 1, replicas = 1)
public class IndexStore {

    @Id
    private Long id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Text, index = false)
    private String image;

    private Character letter;
    private Double longitude;
    private Double latitude;
    private Date createTime;

}
