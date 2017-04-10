package com.mn.model;

import java.time.LocalDate;

public class Gif
{
    private String name;
    private String username;
    private LocalDate dateUploaded;
    private boolean favorite;
    private int categoryId;


    public Gif() {
    }

    public Gif(String name, String username, LocalDate dateUploaded, boolean favorite, int categoryId) {
        this.name = name;
        this.username = username;
        this.dateUploaded = dateUploaded;
        this.favorite = favorite;
        this.categoryId = categoryId;

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
}
