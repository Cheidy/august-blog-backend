package com.chidiudo.blog.augustblog.service;


import com.chidiudo.blog.augustblog.entity.Post;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author chidiudo
 */

public interface PostService {

    //Optional<Post> checkForPost(Long postId);

    Post createPost(Post post);

    List<Post> getAllPosts();

    Optional<Post> getPostById(Long postId);

    boolean deletePost(Long postId);

    boolean updatePost(Post updatedPost, Long id);

}
