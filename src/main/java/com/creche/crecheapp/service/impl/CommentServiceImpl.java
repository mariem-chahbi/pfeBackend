package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Comment;
import com.creche.crecheapp.repository.CommentRepository;
import com.creche.crecheapp.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {



    private CommentRepository repository;
    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Comment createComment(Comment comment) {


        return repository.save(comment);
    }

    @Override
    public List<Comment> findAllComments() {
        return repository.findAll();
    }
    @Override
    public Comment updateComment(Comment comment) {
        return repository.save(comment);
    }



    @Override
    public void deleteCommentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Comment findCommentById(Long id) {
        return repository.findCommentById(id);
    }


}
