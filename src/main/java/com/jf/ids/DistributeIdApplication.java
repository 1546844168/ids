package com.jf.ids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DistributeIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeIdApplication.class, args);

    }
}
