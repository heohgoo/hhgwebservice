package com.example.hhgwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//AWS EC2에서 Linux기반 AMI로 배포 예정
//MariaDB로 AWS RDS 연동 예정



//@EnableJpaAuditing => 테스트 에러로 분리
// JPA Auditing 가능하게끔
@SpringBootApplication
public class HhgwebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhgwebserviceApplication.class, args);
    }

}
