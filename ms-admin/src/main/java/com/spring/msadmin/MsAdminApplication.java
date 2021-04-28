package com.spring.msadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.msadmin.mapper")
public class MsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAdminApplication.class, args);
    }

}
