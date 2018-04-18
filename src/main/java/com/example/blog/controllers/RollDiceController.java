package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showGame() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String play(@PathVariable int guess, Model model) {
        int rnd = (int )(Math.random() * 6 + 1);
        boolean res = (guess == rnd);
        model.addAttribute("result", res);
        model.addAttribute("number", rnd);
        return "dice-outcome";
    }

}