package com.mn.controller;

import com.mn.Color;
import com.mn.model.Category;
import com.mn.service.CategoryService;
import com.mn.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "category/categories";
    }

    @RequestMapping("/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap)
    {
        modelMap.put("gifs", gifService.findByCategoryId(id));
        modelMap.put("category", categoryService.findById(id));
        return "category/category";
    }

    @RequestMapping("/categories/add")
    public String formNewCategory(Model model)
    {
        model.addAttribute("formCategory", "New category");
        model.addAttribute("category", new Category());
        model.addAttribute("colors", Color.values());

        return "category/form";
    }

    @RequestMapping(value = "/category/delete/{id}")
    public String delete(@PathVariable int id, Model model)
    {
        categoryService.delete(id);
        List<Category> categories = categoryService.findAll();
        if(categories != null)
        {
            model.addAttribute("categories", categories);
            return "redirect:/categories";
        }
        else
        {
            return "";
        }
    }

    //add / edit category - form
    @RequestMapping(value = "/category/form/{id}", method = RequestMethod.GET)
    public String formCategory(@PathVariable int id, Model model)
    {
        Category category = categoryService.findById(id);
        if(category != null)
        {
            model.addAttribute("category", category);
            model.addAttribute("formCategory", "Edit category");
        }
        else
        {
            model.addAttribute("category",new Category());
            model.addAttribute("formCategory", "New category");
        }
        return "category/form";
    }

    //add / edit category
    @RequestMapping(value = "/category/save", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute Category category)
    {
        categoryService.saveOrUpdate(category);
        return "redirect:/categories";
    }

}
