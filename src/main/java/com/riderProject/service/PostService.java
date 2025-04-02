package com.riderProject.service;

import com.riderProject.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.riderProject.repository.PostRepository;

import java.util.List;



@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    //CRUD
    // 글 리스트, 글 검색, 글 작성, 글 수정, 글 삭제

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow();
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post newpost){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(newpost.getTitle());
        post.setContent(newpost.getContent());
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
