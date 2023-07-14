package com.example.hhgwebservice.config.auth;

import com.example.hhgwebservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
//Spring Security 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                //url별 권한 관리를 설정
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                //permitAll-전체 열람 권한, antMatchers-권한 관리 대상 지정 옵션
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                //위와 같은 주소는 USER 권한을 가진 사람만 API 사용 가능
                .anyRequest().authenticated()
                //나머지 주소는 인가된 사용자만 열람할 수 있게끔 한다.
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                //로그인 성공 이후 사용자의 정보를 가져옴
                .userService(customOAuth2UserService);
    }
}
