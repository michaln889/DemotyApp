package com.mn.service;


import com.mn.model.Gif;

import java.util.List;

public interface GifService
{
    List<Gif> findAll();
    Gif findByName(String name);
    List<Gif> findFavorites();
    List<Gif> findByCategoryId(int id);
    Gif findById(int id);
    void makeFavoriteOrUnfavorite(Gif gif);
}
