package com.chidiudo.blog.augustblog.service.Impl;


import com.chidiudo.blog.augustblog.entity.Post;
import com.chidiudo.blog.augustblog.exception.ResourceNotFoundException;
import com.chidiudo.blog.augustblog.repository.PostRepository;
import com.chidiudo.blog.augustblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author chidiudo
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;


  /*  @Override
    public Optional<Post> checkForPost(Long postId) {
        return postRepository.findById(postId);
    }

   */

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
        Optional<Post> checkForPost = postRepository.findById(postId);

        //Using if statement to check if to throw exception
        if (checkForPost.isPresent()) {
            return checkForPost.get();
        } else {
            throw new ResourceNotFoundException("Post", "postId", postId);
        }
    }

    @Override
    public void deletePost(Long postId) {
        Post checkForPost = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

            postRepository.deleteById(postId);
    }

    @Override
    public Post updatePost(Post updatedPost, Long id) {

        Post post = postRepository.findById(id).orElseThrow(//using lambda to throw exception
                () -> new ResourceNotFoundException("Post", "id", id));

            post.setTitle(updatedPost.getTitle());
            post.setDescription(updatedPost.getDescription());
            post.setContent(updatedPost.getContent());
            postRepository.save(post);

            return post;

    }


}









