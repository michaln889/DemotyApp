package com.mn.controller;

import com.mn.model.Gif;
import com.mn.service.GifService;
import com.mn.service.UserService;
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
    private GifService gifService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    //@ResponseBody
    public String listOfGifs(ModelMap modelMap)
    {
        List<Gif> gifs = gifService.findAll();
        modelMap.put("gifs", gifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap)
    {
        Gif gif = gifService.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String getFavorites(ModelMap modelMap)
    {
        List<Gif> gifs = gifService.findFavorites();
        modelMap.put("gifs", gifs);
        return "favorites";
    }

}
