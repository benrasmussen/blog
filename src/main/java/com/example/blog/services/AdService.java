package com.example.blog.services;

import com.example.blog.models.Ad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdService {

    private List<Ad> ads;

    public AdService() {
        this.ads = new ArrayList<>();
        createAds();
    }

    public List<Ad> getAllAds() {
        return ads;
    }

    public Ad getAd(long id) {
        return ads.get(((int) id) - 1);
    }

    public void createAds() {
        this.save(new Ad("Test Title 1", "This is a test post description 1."));
        this.save(new Ad("Test Title 2", "This is a test post description 2."));
        this.save(new Ad("Test Title 3", "This is a test post description 3."));
        this.save(new Ad("Test Title 4", "This is a test post description 4."));
    }

    public void save(Ad ad){
        ad.setId(this.ads.size()+1);
        this.ads.add(ad);
    }

}