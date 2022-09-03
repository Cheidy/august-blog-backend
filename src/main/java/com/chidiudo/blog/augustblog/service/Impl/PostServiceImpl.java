package com.chidiudo.blog.augustblog.service.Impl;

import com.chidiudo.blog.augustblog.dto.PostDto;
import com.chidiudo.blog.augustblog.entity.Post;
import com.chidiudo.blog.augustblog.repository.PostRepository;
import com.chidiudo.blog.augustblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;



    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long postId) {
        Optional<Post> savedPost = postRepository.findById(postId);

        return savedPost.isPresent() ? savedPost.get() : null;
    }

    @Override
    public boolean deletePost(Long postId) {
        Optional<Post> savedPost = postRepository.findById(postId);

        if (savedPost.isPresent()) {
            postRepository.deleteById(postId);
            return true;
        }
        return false;
    }


}









