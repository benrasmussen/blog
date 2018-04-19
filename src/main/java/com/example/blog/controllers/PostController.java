package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repository.PostRepository;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private final PostService postSvc;
    private final PostRepository postDao;

    public PostController(PostService postSvc, PostRepository postDao) {
        this.postSvc = postSvc;
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model mod) {
        mod.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model mod) {
        mod.addAttribute("post", postDao.findById(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model mod) {
        mod.addAttribute("newPost", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post newPost) {
        postDao.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String edit(@PathVariable long id, Model mod){
        mod.addAttribute("post", postDao.findById(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String handleEdit(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postDao.delete(post);
        return "redirect:/posts";

    }

}
