package com.mn.controller;

import com.mn.data.CategoryRepository;
import com.mn.data.GifRepository;
import com.mn.model.Category;
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
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap)
    {
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap)
    {
        modelMap.put("gifs", gifRepository.findByCategoryId(id));
        modelMap.put("category", categoryRepository.findById(id));
        return "category";
    }

}
