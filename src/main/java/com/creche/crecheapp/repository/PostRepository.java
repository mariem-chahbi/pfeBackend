package com.creche.crecheapp.repository;

import com.creche.crecheapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(Integer id);
    void deletePostById(Integer id);

}
