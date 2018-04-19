package com.example.blog.services;

import com.example.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(long id) {
        return posts.get((int)id - 1);
    }

    public void createPosts() {
        this.save(new Post("Title1", "Body body body"));
        this.save(new Post("Title2", "Body body body"));
        this.save(new Post("Title3", "Body body body"));
        this.save(new Post("Title4", "Body body body"));
    }

    public void save(Post posts){
        posts.setId(this.posts.size()+1);
        this.posts.add(posts);
    }

}