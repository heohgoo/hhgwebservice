package com.example.hhgwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>//Entity클래스, PK타입
{

}
