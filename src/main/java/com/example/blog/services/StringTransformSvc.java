package com.example.blog.services;

import org.springframework.stereotype.Service;

@Service
public class StringTransformSvc {
    public String getFirstLetter(String word) {
        return word.substring(0,1);
    }
}
