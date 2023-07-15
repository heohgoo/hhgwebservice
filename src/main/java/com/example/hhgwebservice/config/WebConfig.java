package com.example.hhgwebservice.config;

import com.example.hhgwebservice.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
//설정 파일 만들기 위한 어노테이션
//WebMvcConfigurer -> 자동 구성된 Spring MVC 구성을 큰 변경없이 추가적인 조작 가능하게 -> 개발자가 spring mvc 제어
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    //스프링에 등록
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
