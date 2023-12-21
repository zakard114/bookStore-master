package com.bookstore.controller;

import com.bookstore.repository.MyBookRepository;
import com.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookListService myBookListService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable Long id){
        myBookListService.deleteById(id);
        return "redirect:/my_books";
    }

}
