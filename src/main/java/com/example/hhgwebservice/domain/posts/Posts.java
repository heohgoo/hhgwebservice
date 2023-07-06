package com.example.hhgwebservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //Setter 사용x => 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수 없다.
@NoArgsConstructor //기본 생성자 자동 추가 => public Posts(){}와 같은 효과
@Entity //테이블과 링크될 클래스임을 암시
public class Posts {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙, auto_increment
    private Long id;

    @Column(length = 500, nullable = false) //테이블 칼럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //Builder 패턴 클래스 생성, 생성자와 달리 어느 필드에 어던 값을 채워야 할 지 인지 가능
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
