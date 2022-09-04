package com.chidiudo.blog.augustblog.repository;

import com.chidiudo.blog.augustblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>  {

}
