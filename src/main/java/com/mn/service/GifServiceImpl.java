package com.mn.service;

import com.mn.data.GifRepository;
import com.mn.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifServiceImpl implements GifService
{
    @Autowired
    private GifRepository gifRepository;

    @Override
    public List<Gif> findAll() {
        return gifRepository.findAll();
    }

    @Override
    public Gif findByName(String name) {
        return gifRepository.findByName(name);
    }

    @Override
    public List<Gif> findFavorites() {
        return gifRepository.findFavorites();
    }

    @Override
    public List<Gif> findByCategoryId(int id) {
        return gifRepository.findByCategoryId(id);
    }
}
