package com.venchi.dark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liwc
 * @date 2021/06/30
 */
@SpringBootApplication
@MapperScan("com.venchi.dark.mapper")
public class DarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DarkApplication.class, args);
    }

}
