package com.mn.service;

import com.mn.data.CategoryRepository;
import com.mn.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id)
    {
        return categoryRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Category category) {
        categoryRepository.saveOrUpload(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }
}
