package com.chidiudo.blog.augustblog.service;


import com.chidiudo.blog.augustblog.entity.Post;

import java.util.List;


public interface PostService {

    Post createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    boolean deletePost(Long postId);
}
