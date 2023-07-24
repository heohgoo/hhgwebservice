package com.example.hhgwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//AWS EC2에서 Linux기반 AMI로 배포 완료
//MariaDB로 AWS RDS 연동 완료
//테스트 환경 구성
//AWS RDS에 mysql.sql, posts, users 테이블 생성
//구글 웹 콘솔과 네이버 개발자 센터에 EC2 도메인을 등록하여 작동하도록 함


//@EnableJpaAuditing => 테스트 에러로 분리
// JPA Auditing 가능하게끔
@SpringBootApplication
public class HhgwebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhgwebserviceApplication.class, args);
    }

}
