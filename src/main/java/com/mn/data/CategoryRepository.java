package com.mn.data;

import com.mn.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "landscapes"),
            new Category(2, "sport"),
            new Category(3, "funny")
    );

    public List<Category> getAllCategories()
    {
        return ALL_CATEGORIES;
    }

    public Category findById(int id)
    {
        for(Category el : ALL_CATEGORIES)
        {
            if(el.getId() == id)
            {
                return el;
            }
        }
        return null;
    }
}
