package com.chidiudo.blog.augustblog.service;


import com.chidiudo.blog.augustblog.dto.PostDto;
import com.chidiudo.blog.augustblog.entity.Post;

import java.util.List;

/**
 *
 * @author chidiudo
 */

public interface PostService {

    //Optional<Post> checkForPost(Long postId);

    Post createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    boolean deletePost(Long postId);

    boolean updatePost(Post updatedPost, Long id);

}
