package com.horizon.server.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class HoGateway {
    public static void main(String[] args) {
        SpringApplication.run(HoGateway.class);
    }
}
