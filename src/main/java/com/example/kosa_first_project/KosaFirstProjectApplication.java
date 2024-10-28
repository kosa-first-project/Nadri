package com.example.kosa_first_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.kosa_first_project", "mybatis"}) // mybatis 디렉터리도 추가
@MapperScan(basePackages = "mybatis.dao")
@MapperScan(basePackages = "com.example.kosa_first_project.repository.board.mybatis")
public class KosaFirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KosaFirstProjectApplication.class, args);
    }

}
