package com.chidiudo.blog.augustblog.controller;

import com.chidiudo.blog.augustblog.dto.PostDto;
import com.chidiudo.blog.augustblog.entity.Post;
import com.chidiudo.blog.augustblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author chidiudo
 */

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/newpost")
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);

    }

    @GetMapping("/listallposts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);

    }

    @GetMapping("/getpostbyid/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long postId){

        return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.OK);
    }

    @DeleteMapping("/deletepost/{id}")
    public ResponseEntity deletePost(@PathVariable(value = "id") Long postId) {

        postService.deletePost(postId);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping("/updatepost/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(name = "id") Long id,
                                           @RequestBody PostDto postDto) {
        Post updatedPost = modelMapper.map(postDto, Post.class);

        return new ResponseEntity<>(postService.updatePost(updatedPost, id), HttpStatus.OK);
    }

}
