package com.mn.controller;

import com.mn.model.Gif;
import com.mn.service.CategoryService;
import com.mn.service.GifService;
import com.mn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class GifController
{
    @Autowired
    private GifService gifService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    //@ResponseBody
    public String listOfGifs(ModelMap modelMap)
    {
        List<Gif> gifs = gifService.findAll();
        modelMap.put("gifs", gifs);
        return "home";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findByName(@RequestParam(value = "name") String name, Model model)
    {
        Gif gif = gifService.findByName(name);
        model.addAttribute("gif", gif);
        return "gif/finded";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetailsName(@PathVariable String name, Model model)
    {
        Gif gif = gifService.findByName(name);
        model.addAttribute("gif", gif);
        return "gif/gif-details";
    }

//    @RequestMapping(value = "/gifs/{gifId}", method = RequestMethod.GET)
//    public String gifDetailsId(@PathVariable int gifId, Model model)
//    {
//        Gif gif = gifService.findById(gifId);
//        model.addAttribute("gif", gif);
//        return "gif/gif-details";
//    }

    @RequestMapping("/favorites")
    public String getFavorites(ModelMap modelMap)
    {
        List<Gif> gifs = gifService.findFavorites();
        modelMap.put("gifs", gifs);
        return "gif/favorites";
    }

    @RequestMapping(value = "/gif/{id}", method = RequestMethod.POST)
    public String makeFavorite(@PathVariable int id, Model model)
    {
        Gif gif = gifService.findById(id);
        model.addAttribute("gif", gif);
        gifService.makeFavoriteOrUnfavorite(gif);

        return "gif/gif-details";
    }

    @RequestMapping(value = "/upload")
    public String formNewGif(Model model)
    {
        model.addAttribute("gif", new Gif());
        model.addAttribute("categories", categoryService.findAll());

        return "gif/form";
    }

}
