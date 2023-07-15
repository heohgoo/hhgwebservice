package com.example.hhgwebservice.config.auth.dto;

import com.example.hhgwebservice.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//인증된 사용자 정보만을 필요로 한다.
//직렬화 기능을 가진 Dto를 통해 성능 이슈, 부수 효과 발생을 줄인다.(User 클래스에 직렬화를 구현하지 않음을 통해)
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
