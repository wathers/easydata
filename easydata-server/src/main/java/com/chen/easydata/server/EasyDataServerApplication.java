package com.chen.easydata.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EasyDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyDataServerApplication.class, args);
    }
}
