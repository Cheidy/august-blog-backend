package com.chidiudo.blog.augustblog.dto;

import lombok.Data;

import java.util.Set;

/**
 *
 * @author chidiudo
 */

@Data
public class PostDto {


    private Long id;

    private String title;

    private String description;

    private String content;

    private Set<CommentDto> comments;


}
