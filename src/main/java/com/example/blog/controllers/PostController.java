package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
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
        return "INSERT - 4view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost() {
        return "create a new post";
    }

}
