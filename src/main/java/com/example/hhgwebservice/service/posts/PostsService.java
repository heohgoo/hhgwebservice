package com.example.hhgwebservice.service.posts;

import com.example.hhgwebservice.domain.posts.PostsRepository;
import com.example.hhgwebservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional //트랜잭션 - 모든 작업들이 성공해야만 최종적으로 데이터베이스에 반영되도록 한다.
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
