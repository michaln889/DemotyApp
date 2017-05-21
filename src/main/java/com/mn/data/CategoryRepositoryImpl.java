package com.mn.data;

import com.mn.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository
{
    private static List<Category> allCategories = new ArrayList<Category>() {
        {
            add(new Category(1, "IT"));
            add(new Category(2, "Cats"));
            add(new Category(3, "Funny"));
        }
    };

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

    @Override
    public void saveOrUpload(Category category)
    {
        boolean isUpdate = false;
        int getPos = 0;

        for(Category el : allCategories)
        {
            if(el.getId() == category.getId())
            {
                isUpdate = true;
                break;
            }
            getPos++;
        }

        if(isUpdate)
        {
            allCategories.get(getPos).setName(category.getName());
        }
        else
        {
            int id = allCategories.size() + 1;
            category.setId(id);
            allCategories.add(category);
        }
    }

    @Override
    public void delete(int id) {

        int pos=0;
        for(Category el : allCategories)
        {
            if(el.getId() == id)
            {
                allCategories.remove(pos);
                break;
            }
            pos++;
        }
    }


}
