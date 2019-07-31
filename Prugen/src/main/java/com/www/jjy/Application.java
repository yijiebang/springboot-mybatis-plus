package com.www.jjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching//开启缓存
@MapperScan("com.www.jjy.mapper")  //配置mapper扫描
@SpringBootApplication
public class  Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
