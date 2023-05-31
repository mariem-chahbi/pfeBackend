package com.creche.crecheapp.service;

import com.creche.crecheapp.model.Post;

import java.util.List;

public interface PostService {
    public Post createPost(Post post);


    public List<Post> findAllPosts();


    public Post updatePost(Post post);




    public void deletePostById(Integer id);

    Post findPostById(Integer id);
}
