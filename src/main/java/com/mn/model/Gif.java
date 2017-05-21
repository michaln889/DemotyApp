package com.mn.model;

import java.time.LocalDate;

public class Gif
{
    private int id;
    private String name;
    private String username;
    private LocalDate dateUploaded;
    private boolean favorite;
    private int categoryId;
    private String description;
    private byte[] bytes;


    public Gif() {
    }

    public Gif(int id, String name, String username, LocalDate dateUploaded, boolean favorite, int categoryId) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.dateUploaded = dateUploaded;
        this.favorite = favorite;
        this.categoryId = categoryId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
