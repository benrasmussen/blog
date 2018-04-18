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
        posts.add(new Post("Title1", "Body body body"));
        posts.add(new Post("Title2", "Body body body"));
        posts.add(new Post("Title3", "Body body body"));
        posts.add(new Post("Title4", "Body body body"));
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

}