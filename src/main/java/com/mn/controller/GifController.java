package com.mn.controller;

import com.mn.data.GifRepository;
import com.mn.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class GifController
{
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    //@ResponseBody
    public String listOfGifs(ModelMap modelMap)
    {
        List<Gif> gifs = gifRepository.findAll();
        modelMap.put("gifs", gifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap)
    {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String getFavorites(ModelMap modelMap)
    {
        List<Gif> gifs = gifRepository.getFavorites();
        modelMap.put("gifs", gifs);
        return "favorites";
    }

}
