package com.example.blog.controllers;

import com.example.blog.models.Ad;
import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    PostService postSvc;
    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String index(Model mod) {
        mod.addAttribute("posts", postSvc.getAllPosts());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model mod) {
        mod.addAttribute("post", postSvc.getPost(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model mod) {
        mod.addAttribute("newPost", new Post("", ""));
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post newPost) {
        postSvc.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model mod){
        mod.addAttribute("post", postSvc.getPost(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String handleEdit(@ModelAttribute Post post){
        System.out.println("posts = " + post.getId());
        System.out.println("posts = " + post.getBody());
        System.out.println("posts = " + post.getTitle());
        return "redirect:/posts";
    }

}
