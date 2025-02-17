package com.horizon.server.itemService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.horizon.server.itemService.mapper")
public class HoItemService {
    public static void main(String[] args) {
        SpringApplication.run(HoItemService.class);
    }
}
