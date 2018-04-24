package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.services.PostService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postSvc;
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostService postSvc, PostRepository postDao, UserRepository userDao) {
        this.postSvc = postSvc;
        this.postDao = postDao;
        this.userDao = userDao;

    }
    @GetMapping("/")
    public String homePage(Model mod) {
        mod.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hi, Janie :)";
    }

    @GetMapping("/posts")
    public String index(Model mod) {
        mod.addAttribute("posts", postDao.findAll());
        return "/posts/index";
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newPost.setUser(user);
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
        post.setUser(userDao.findById(1));
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postDao.delete(post);
        return "redirect:/posts";

    }

}
