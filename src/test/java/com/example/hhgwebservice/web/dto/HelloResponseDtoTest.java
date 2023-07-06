package com.example.hhgwebservice.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name); //assertj라는 테스트 검증 라이브러리의 검증 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
        //Junit에서도 assertThat이라는 검증 메소드가 있지만 assertj가 자동완성, 추가적인 라이브러리가 필요하지 않다는 측면에서 좋다.
    }
}
