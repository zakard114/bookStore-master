package com.bookstore.service;

import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList myBookList){
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
    }

    public void deleteById(Long id){
        myBookRepository.deleteById(id);
    }

}
