package com.example.hhgwebservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //스프링 부트 테스트와 JUnit 연결자 역할
@WebMvcTest(controllers = HelloController.class) //Spring MVC 테스트 어노테이션, 그 중 Controller만을 허용
public class HelloControllerTest {
    @Autowired private MockMvc mvc; // 웹 API 테스트용, 여러 HTTP 메소드 등에 대해 API 테스트 가능

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //HTTP Get 요청
                .andExpect(status().isOk()) //HTTP Header Status => 200인지
                .andExpect(content().string(hello)); //응답 본문의 내용 검증, Hello를 리턴하는가
    }

    @Test
    public void hellodto_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))) //toString과 유사, NPE를 발생시키지 않고 "null" 생성하는 게 차이점
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //json 응답값을 필드별로 검증할 수 있는 메소드, $ 기준 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
