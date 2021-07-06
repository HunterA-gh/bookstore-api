package com.hunter.bookstore.controller;

import com.hunter.bookstore.model.Book;
import com.hunter.bookstore.model.Category;
import com.hunter.bookstore.service.BookService;
import com.hunter.bookstore.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @PostMapping("/homepage")
    public void createCategory(@RequestBody Category category){
        categoryService.createOrUpdateCategory(category);
    }

    @GetMapping("/homepage")
    public Iterable<Category> getAllCategories(){
        logger.info("Got all categories");
        return categoryService.getAllCategories();
    }

    @PutMapping("/homepage/{id}")
    public void updateCategory(@RequestBody Category category){
        logger.info("Updated categories");
        categoryService.createOrUpdateCategory(category);
    }

    @PostMapping("homepage/{id}")
    public void addBook(@PathVariable Long id, @RequestBody Book book){
        logger.info("Added book");
        Category category = categoryService.getCategoryById(id);
        book.setCategory(category);
        bookService.createOrUpdateBook(book);
    }


    @GetMapping("/homepage/{id}")
    public Category getCategoryById(@PathVariable Long id){
        logger.info("Got category by ID");
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/homepage/{id}")
    public void deleteCategory(@PathVariable Long id){
        logger.info("Deleted category");
        categoryService.deleteCategory(id);
    }


}
