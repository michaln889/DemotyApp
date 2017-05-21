package com.mn.data;

import com.mn.model.Gif;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GifRepository
{
    List<Gif> findAll();
    Gif findByName(String name);
    List<Gif> findFavorites();
    List<Gif> findByCategoryId(int id);
    Gif findById(int id);
    void makeFavoriteOrUnfavorite(Gif gif);
}
