package com.creche.crecheapp.service;

import com.creche.crecheapp.model.Comment;

import java.util.List;


public interface CommentService {
    public Comment createComment(Comment comment);


    public List<Comment> findAllComments();


    public Comment updateComment(Comment comment);




    public void deleteCommentById(Long id);

    Comment findCommentById(Long id);
}
