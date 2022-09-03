package com.chidiudo.blog.augustblog.service;

import com.chidiudo.blog.augustblog.dto.PostDto;
import com.chidiudo.blog.augustblog.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);
}
