package com.creche.crecheapp.dto;

import com.creche.crecheapp.model.Post;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class PostDto {
    private Integer id;
    private String title;
    private String content;
    private Date created_at;


    public static PostDto fromEntity(Post post) {
        if (post == null) {
            return null;
        }
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created_at(post.getCreatedAt())
                .build();
    }

    public static Post toEntity(PostDto postDto) {
        if (postDto == null) {
            return null;
        }
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCreatedAt(postDto.getCreated_at());
        return post;
    }
}
