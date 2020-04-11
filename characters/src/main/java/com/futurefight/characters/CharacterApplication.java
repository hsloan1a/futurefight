package com.futurefight.characters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CharacterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CharacterApplication.class, args);
    }

}
