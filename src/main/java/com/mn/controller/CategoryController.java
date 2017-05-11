package com.mn.controller;

import com.mn.model.Category;
import com.mn.service.CategoryService;
import com.mn.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GifService gifService;

    @RequestMapping("/categories")
    public String getCategories(ModelMap modelMap)
    {
        List<Category> categories = categoryService.findAll();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap)
    {
        modelMap.put("gifs", gifService.findByCategoryId(id));
        modelMap.put("category", categoryService.findById(id));
        return "category";
    }

}
