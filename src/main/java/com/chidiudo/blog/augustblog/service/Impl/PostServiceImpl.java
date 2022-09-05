package com.chidiudo.blog.augustblog.service.Impl;

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

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Optional<Post> checkForPost(Long postId) {
        return postRepository.findById(postId);
    }

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

        return checkForPost(postId).isPresent() ? checkForPost(postId).get() : null;
    }

    @Override
    public boolean deletePost(Long postId) {
        //Optional<Post> savedPost = postRepository.findById(postId);

        if (checkForPost(postId).isPresent()) {
            postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePost(Long postId, Post post) {
        //Optional<Post> savedPost = postRepository.findById(postId);
        //Post updatedPost = savedPost.get();
        //System.out.println(savedPost);

        return false;
    }


}









