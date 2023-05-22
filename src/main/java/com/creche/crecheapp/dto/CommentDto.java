package com.creche.crecheapp.dto;

import com.creche.crecheapp.model.Comment;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class CommentDto {

    private Long id;
    private String content;
    private Date created_at;
    private  String createdBy;

    public static CommentDto fromEntity(CommentDto commentDto) {
        if (commentDto == null) {
            return null;
        }
        return CommentDto.builder()
                .id(commentDto.getId())
                .content(commentDto.getContent())
                .created_at(commentDto.getCreated_at())
                .createdBy(commentDto.getCreatedBy())
                .build();

    }

    public static Comment toEntity(CommentDto commentDto) {
        if (commentDto == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setContent(commentDto.getContent());
        comment.setCreatedAt(commentDto.getCreated_at());
        comment.setCreatedBy(commentDto.getCreatedBy());
        return comment;

    }
}
