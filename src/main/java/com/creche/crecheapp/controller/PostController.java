package com.creche.crecheapp.controller;

import com.creche.crecheapp.exception.ResourceNotFoundException;
import com.creche.crecheapp.model.Post;
import com.creche.crecheapp.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/all")
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @PostMapping("/add")
    public Post createPost(@Valid @RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/update/{postId}")
    public Post updatePost(@PathVariable Integer postId, @Valid @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @GetMapping("/getImagePost/{id}")
    public List<String> getImagesByPostId(@PathVariable Integer id) {
        Post post = postRepository.findPostById(id);
        String[] ids = post.fileUrl.split(",");
        List<String> idsInt = new ArrayList<>();
        for (String s : ids) {
            idsInt.add(s);
        }
        return idsInt;
    }
}
