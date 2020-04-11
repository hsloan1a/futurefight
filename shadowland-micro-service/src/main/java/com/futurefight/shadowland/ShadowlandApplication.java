package com.futurefight.shadowland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShadowlandApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShadowlandApplication.class, args);
    }

}