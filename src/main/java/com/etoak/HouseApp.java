package com.etoak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2020/4/20.
 */
@SpringBootApplication
@MapperScan(basePackages="com.etoak.mapper")
public class HouseApp {
    public static void main(String[] args) {
        SpringApplication.run(HouseApp.class,args);
    }
}
