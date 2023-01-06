package com.integrador.backend.services;

import com.integrador.backend.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.integrador.backend.config.WebConfig;



public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> searchAllCategory();
    Optional<Category> searchCategoryById(Long id);
    Category updateCategory(Category category);
    void deleteCategory(Long id);
}
