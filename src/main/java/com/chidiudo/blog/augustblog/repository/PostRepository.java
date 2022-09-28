package com.chidiudo.blog.augustblog.repository;

import com.chidiudo.blog.augustblog.entity.Post;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author chidiudo
 */

public interface PostRepository extends JpaRepository<Post, Long>  {

    @Query(value = "SELECT * FROM posts p WHERE p.title LIKE %?1%", nativeQuery = true)
    List<Post> searchForPosts(String query);
}
