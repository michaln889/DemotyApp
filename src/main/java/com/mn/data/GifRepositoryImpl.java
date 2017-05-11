package com.mn.data;

import com.mn.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepositoryImpl implements GifRepository
{
    private List<Gif> allGifs = Arrays.asList(
            new Gif("gif1", "aaa", LocalDate.now(), false, 1),
            new Gif("gif2", "bbb", LocalDate.now(), true, 2),
            new Gif("gif3", "ccc", LocalDate.now(), true, 3),
            new Gif("gif4", "ddd", LocalDate.now(), false, 1),
            new Gif("gif5", "eee", LocalDate.now(), true, 2),
            new Gif("2841-1792494-StickSkok", "fff", LocalDate.now(), false, 2)
    );

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Gif> findAll()
    {
        return allGifs;
    }

    @Override
    public Gif findByName(String name)
    {
        for(Gif el : allGifs)
        {
            if(el.getName().equals(name))
            {
                return el;
            }
        }
        return null;
    }

    @Override
    public List<Gif> findFavorites()
    {
        List<Gif> gifs = new ArrayList<>();
        for(Gif el : allGifs)
        {
            if(el.isFavorite())
            {
                gifs.add(el);
            }
        }
        return gifs;
    }

    @Override
    public List<Gif> findByCategoryId(int id)
    {
        List<Gif> gifs = new ArrayList<>();
        for(Gif el : allGifs)
        {
            if(el.getCategoryId() == id)
            {
                gifs.add(el);
            }
        }
        return gifs;
    }
}
