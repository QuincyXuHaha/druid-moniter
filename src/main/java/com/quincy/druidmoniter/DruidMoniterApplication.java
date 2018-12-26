package com.quincy.druidmoniter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DruidMoniterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruidMoniterApplication.class, args);
    }

}

