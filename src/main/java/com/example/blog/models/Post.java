package com.example.blog.models;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private String title;
    private String body;
    private long id;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public static Post myPost() {
        String title = "Post numero uno!";
        String body = "This is my very first post! Isn't it grand!";
        return new Post(title, body);
    }

    public static Post myPost2() {
        String title = "Another amazing post";
        String body = "Man this is just fantastic";
        return new Post(title, body);
    }

    public static List<Post> all() {
        List<Post> posts = new ArrayList<>();
        posts.add(myPost());
        posts.add(myPost2());
        return posts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}


