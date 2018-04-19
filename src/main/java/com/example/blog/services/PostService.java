package com.example.blog.services;

import com.example.blog.models.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {
//    private List<Post> posts;

    @Autowired
    private final PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    public Post save(Post post){
        return postDao.save(post);

        }
    }
