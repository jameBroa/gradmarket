package com.example.demo.model;

import jakarta.persistence.*;

import java.io.File;

@Entity
public class Listing {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private Long owner_id;
    private String title;
    private String description;
    private float price;

    @Lob
    @Column(name="media", columnDefinition = "LONGBLOB")
    private byte[] media;

    public Listing() {

    }

    public Listing(Long owner_id, String title, String description, float price, byte[] media) {
        this.owner_id = owner_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.media = media;
    }




    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte[] getMedia() {
        return media;
    }

    public void setMedia(byte[] media) {
        this.media = media;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
