package com.example.hhgwebservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
//어노테이션이 생성되는 위치 지정, 메소드의 파라미터로 선언된 객체에서만 사용하게끔
@Retention(RetentionPolicy.RUNTIME)
//이 파일을 어노테이션 클래스로 지정
public @interface LoginUser {
}
