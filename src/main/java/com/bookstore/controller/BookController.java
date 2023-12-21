package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/bookStore")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/my_books")
    public ModelAndView getMyBooks(){
        List<MyBookList> list = myBookListService.getAllMyBooks();
//        for (int i = 0; i < list.size() ; i++) {
//            System.out.println(list.get(i).getId());
//            System.out.println(list.get(i).getName());
//            System.out.println(list.get(i).getAuthor());
//            System.out.println(list.get(i).getPrice());
//        }
//        System.out.println("success by far");
        return new ModelAndView("myBooks", "book", list);
    }

    @GetMapping("/available_books")
    public ModelAndView getAllbook(){
        List<Book> list = bookService.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book", list);
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        System.out.println("success1");
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(),
                book.getAuthor(), book.getPrice());
        System.out.println("success2");
        myBookListService.saveMyBooks(myBookList);
        System.out.println("success3");
        return "redirect:/my_books";
    }
}
