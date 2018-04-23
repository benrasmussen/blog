package com.example.blog.services;

import com.example.blog.models.Ad;
import com.example.blog.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdService{

//    private List<Ad> ads;
    @Autowired
    private final AdRepository adDao;

    public AdService(AdRepository adDao) {
        this.adDao = adDao;
    }

    public Ad save(Ad ad){
//        ad.setId(this.ads.size()+1);
//        this.ads.add(ad);
       return adDao.save(ad);
    }

}