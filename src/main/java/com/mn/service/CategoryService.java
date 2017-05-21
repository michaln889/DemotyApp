package com.mn.service;

import com.mn.model.Category;

import java.util.List;


public interface CategoryService
{
    List<Category> findAll();
    Category findById(int id);
    void saveOrUpdate(Category category);
    void delete(int id);
}
