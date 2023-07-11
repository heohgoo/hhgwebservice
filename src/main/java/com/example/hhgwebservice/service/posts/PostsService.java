package com.example.hhgwebservice.service.posts;

import com.example.hhgwebservice.domain.posts.Posts;
import com.example.hhgwebservice.domain.posts.PostsRepository;
import com.example.hhgwebservice.web.dto.PostsListResponseDto;
import com.example.hhgwebservice.web.dto.PostsResponseDto;
import com.example.hhgwebservice.web.dto.PostsSaveRequestDto;
import com.example.hhgwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //final, not null
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional //트랜잭션 - 모든 작업들이 성공해야만 최종적으로 데이터베이스에 반영되도록 한다.
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        //repository로 쿼리를 날리지 않는다. => JPA의 영속성 컨텍스트(엔티티를 영구 저장하는 환경)
        //entity 객체의 값만 변경하면 별도로 update 쿼리를 날릴 피료가 없게 된다.(더티 체킹)
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
