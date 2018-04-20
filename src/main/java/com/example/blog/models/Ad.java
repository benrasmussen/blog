package com.example.blog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "ads")
public class Ad {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    //create the relationship to the users table
    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<AdImage> images;

    @OneToOne
    private AdDetails adDetails;

    public Ad() {
    }

    public Ad(String title, String description, long id, User user, AdDetails add, List<AdImage> images) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.user = user;
        this.images = images;
        this.adDetails = add;
    }

    public Ad(String title, String description, User user, AdDetails add, List<AdImage> images) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.images = images;
        this.adDetails = add;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AdImage> getImages() {
        return images;
    }

    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public AdDetails getAdDetails() {
        return adDetails;
    }

    public void setAdDetails(AdDetails adDetails) {
        this.adDetails = adDetails;
    }
}