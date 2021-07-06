package com.hunter.bookstore.controller;

import com.hunter.bookstore.model.Book;
import com.hunter.bookstore.model.Category;
import com.hunter.bookstore.service.BookService;
import com.hunter.bookstore.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("details/{id}")
    public Book getBookById(@PathVariable Long id){
        logger.info("Got book details");
        return bookService.getBookById(id);
    }

    @PutMapping("details/{id}")
    public void updateBook(@RequestBody Book book){
        List<Category> categories = new ArrayList<>();
        categoryService.getAllCategories().forEach(categories::add);
        for(int i = 0; i < categories.size(); i++){
            for(int j = 0; j < categories.get(i).getBooks().size(); j++){
                if(book.getId().equals(categories.get(i).getBooks().get(j).getId())){
                    book.setCategory(categories.get(i));
                    break;
                }
            }
        }
        logger.info("Updated book");
        bookService.createOrUpdateBook(book);
    }

    @DeleteMapping("details/{id}")
    public void deleteBook(@PathVariable Long id){
        logger.info("Deleted book");
        bookService.deleteBook(id);
    }
}
