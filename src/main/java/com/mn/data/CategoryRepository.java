package com.mn.data;

import com.mn.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CategoryRepository {

    List<Category> findAll();
    Category findById(int id);
}
