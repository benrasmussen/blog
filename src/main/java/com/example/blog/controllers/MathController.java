package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{numberA}/and/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int numberA, @PathVariable int numberB) {
        return (numberA + numberB) + "!";
    }

    @RequestMapping(path = "/subtract/{numberA}/from/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int numberA, @PathVariable int numberB) {
        return (numberA - numberB) + "!";
    }

    @RequestMapping(path = "/multiply/{numberA}/and/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int numberA, @PathVariable int numberB) {
        return (numberA * numberB) + "!";
    }

    @RequestMapping(path = "/divide/{numberA}/by/{numberB}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int numberA, @PathVariable int numberB) {
        return (numberA / numberB) + "!";
    }
}
