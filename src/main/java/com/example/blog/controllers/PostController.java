package com.example.blog.controllers;

import com.example.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts/index")
    public String index(Model mod) {
        List<Post> posts = Post.all();
        mod.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/show")
    public String individualPost(Model mod) {
        Post post = Post.myPost();
        String title = post.getTitle();
        String body = post.getBody();
        mod.addAttribute("title", title);
        mod.addAttribute("body", body);
        return "posts/show";
    }

    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable int id) {
        return "posts index page " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "INSERT - view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost() {
        return "create a new post";
    }

}
