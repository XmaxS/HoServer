package com.horizon.server.itemInterface.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreVo {
    private Long id;
    private String name;
    private String image;
    private Character letter;
    private Double longitude;
    private Double latitude;
    private List<Long> cids;
    private Date createTime;
}
