package com.luorui.drug_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luorui.drug_system.mapper")
public class DrugSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugSystemApplication.class, args);
    }
}
