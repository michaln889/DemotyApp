package com.mn.data;

import com.mn.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository
{
    private List<Category> allCategories = Arrays.asList(
            new Category(1, "IT"),
            new Category(2, "Cats"),
            new Category(3, "Funny")
    );

    @Override
    public List<Category> findAll()
    {
        return allCategories;
    }

    @Override
    public Category findById(int id)
    {
        for(Category el : allCategories)
        {
            if(el.getId() == id)
            {
                return el;
            }
        }
        return null;
    }
}
