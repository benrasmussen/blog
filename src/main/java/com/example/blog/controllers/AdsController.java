package com.example.blog.controllers;

import com.example.blog.models.Ad;
import com.example.blog.repository.AdRepository;
import com.example.blog.services.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdsController {

    private final AdService adSvc;
    private final AdRepository adDao;

    public AdsController(AdService adSvc, AdRepository adDao) {
        this.adSvc = adSvc;
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("ad", adSvc.getAd(id));
        return "/ads/show";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model viewModel) {
        viewModel.addAttribute("newAd", new Ad());
        return "/ads/create";
    }

    @PostMapping("/ads/create")
    public String insert(@ModelAttribute Ad newAd) {
        adSvc.save(newAd);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}/edit")
    public String edit(@PathVariable long id, Model mod){
        mod.addAttribute("ad", adSvc.getAd(id));
        return "/ads/edit";
    }

    @PostMapping("/ads/edit")
    public String handleEdit(@ModelAttribute Ad ad){
        System.out.println("ad = " + ad.getId());
        System.out.println("ad = " + ad.getDescription());
        System.out.println("ad = " + ad.getTitle());
        return "redirect:/ads";
    }

}