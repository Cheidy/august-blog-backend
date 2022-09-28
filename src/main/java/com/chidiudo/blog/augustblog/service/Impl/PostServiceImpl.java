package com.chidiudo.blog.augustblog.service.Impl;


import com.chidiudo.blog.augustblog.entity.Post;
import com.chidiudo.blog.augustblog.exception.ResourceNotFoundException;
import com.chidiudo.blog.augustblog.repository.PostRepository;
import com.chidiudo.blog.augustblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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
    public List<Post> getAllPosts(int page) {

        return postRepository.findAll(PageRequest.of(page, 3, Sort.by("title").ascending())).getContent();
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

            post.setTopic(updatedPost.getTopic());
            post.setTitle(updatedPost.getTitle());
            post.setDescription(updatedPost.getDescription());
            post.setContent(updatedPost.getContent());
            postRepository.save(post);

            return post;

    }

    @Override
    public List<Post> searchPosts(String query) {

        return postRepository.searchForPosts(query);
    }


}









