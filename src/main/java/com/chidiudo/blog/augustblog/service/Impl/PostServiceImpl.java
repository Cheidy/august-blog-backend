package com.chidiudo.blog.augustblog.service.Impl;


import com.chidiudo.blog.augustblog.entity.Post;
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

        return checkForPost.orElse(null);
    }

    @Override
    public boolean deletePost(Long postId) {
        Optional<Post> checkForPost = postRepository.findById(postId);

        if (checkForPost.isPresent()) {
            postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePost(Post updatedPost, Long id) {

        Post post = postRepository.findById(id).orElse(null);

        if (post != null) {
            post.setTitle(updatedPost.getTitle());
            post.setDescription(updatedPost.getDescription());
            post.setContent(updatedPost.getContent());
            return true;

        } return false;
    }


}









