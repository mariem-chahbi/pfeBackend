package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Post;
import com.creche.crecheapp.repository.PostRepository;
import com.creche.crecheapp.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class PostServiceImpl implements PostService{

    private PostRepository repository;
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }


    @Override
    public Post createPost(Post post) {


        return repository.save(post);
    }

    @Override
    public List<Post> findAllPosts() {
        return repository.findAll();
    }
    @Override
    public Post updatePost(Post post) {
        return repository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        repository.deletePostById(id);
    }

    @Override
    public Post findPostById(Long id) {
        return repository.findPostById(id);
    }






}
