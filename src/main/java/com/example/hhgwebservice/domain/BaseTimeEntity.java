package com.example.hhgwebservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity를 상속하면 필드들도 칼럼으로 인식하게끔
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing기능 포함
public class BaseTimeEntity {
    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경하면 시간이 자동저장
    private LocalDateTime modifiedDate;
}
