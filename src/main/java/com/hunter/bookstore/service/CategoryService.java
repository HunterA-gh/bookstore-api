package com.hunter.bookstore.service;

import com.hunter.bookstore.model.Category;
import com.hunter.bookstore.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createOrUpdateCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Iterable<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
