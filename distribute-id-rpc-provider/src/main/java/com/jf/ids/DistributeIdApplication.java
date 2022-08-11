package com.jf.ids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.jf")
public class DistributeIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeIdApplication.class, args);

    }
}
