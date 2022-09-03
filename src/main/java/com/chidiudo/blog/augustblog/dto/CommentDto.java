package com.chidiudo.blog.augustblog.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class CommentDto {


    private Long id;

    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @Email
    @NotEmpty(message = "Email should not be null or empty")
    private String email;

    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    @NotEmpty(message = "Body should not be null oe empty")
    private String body;
}
