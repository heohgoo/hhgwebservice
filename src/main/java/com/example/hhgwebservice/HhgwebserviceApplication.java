package com.example.hhgwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 가능하게끔
@SpringBootApplication
public class HhgwebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhgwebserviceApplication.class, args);
    }

}
