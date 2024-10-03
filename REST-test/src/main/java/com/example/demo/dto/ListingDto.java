package com.example.demo.dto;

public class ListingDto {
    private Long id;
    private Long owner_id;
    private String title;
    private String description;
    private float price;
    private byte[] media;

    public ListingDto(Long id, Long owner_id, String title, String description, float price, byte[] media) {
        this.id = id;
        this.owner_id = owner_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.media = media;
    }

    public byte[] getMedia() {
        return media;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
