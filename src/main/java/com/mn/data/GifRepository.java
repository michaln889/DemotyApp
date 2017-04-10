package com.mn.data;

import com.mn.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository
{
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("gif1", "andrzej", LocalDate.now(), false, 1),
            new Gif("gif2", "monika", LocalDate.now(), true, 2),
            new Gif("gif3", "michal", LocalDate.now(), true, 3),
            new Gif("gif4", "dasasc", LocalDate.now(), false, 1),
            new Gif("gif5", "dominik", LocalDate.now(), true, 2),
            new Gif("2841-1792494-StickSkok", "ja", LocalDate.now(), false, 2)
    );

    public Gif findByName(String name)
    {
        for(Gif el : ALL_GIFS)
        {
            if(el.getName().equals(name))
            {
                return el;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs()
    {
        return ALL_GIFS;
    }

    public List<Gif> getFavorites()
    {
        List<Gif> gifs = new ArrayList<>();
        for(Gif el : ALL_GIFS)
        {
            if(el.isFavorite())
            {
                gifs.add(el);
            }
        }
        return gifs;
    }
}
