package com.jf.ids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.jf.common.utils.config.JfCommonUtilsConfig;

@SpringBootApplication
@Import({ JfCommonUtilsConfig.class })
@EnableDiscoveryClient
public class DistributeIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributeIdApplication.class, args);

	}
}
