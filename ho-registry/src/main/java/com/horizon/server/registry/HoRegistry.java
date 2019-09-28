package com.horizon.server.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HoRegistry {
    public static void main(String[] args) {
        SpringApplication.run(HoRegistry.class,args);
    }
}
