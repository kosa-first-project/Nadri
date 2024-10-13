package com.example.kosa_first_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class KosaFirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KosaFirstProjectApplication.class, args);
    }

}
