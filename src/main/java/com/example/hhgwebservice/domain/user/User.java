package com.example.hhgwebservice.domain.user;

import com.example.hhgwebservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.hhgwebservice.domain.user.Role;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
//BaseTimeEntity => Entity의 상위 클래스에서 createdDate, updateDate 관리
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //auto-increment
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    //JPA로 데이터베이스로 저장할 때 Enum 값을 어떤 형태로 할지, 디폴트는 int형
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
