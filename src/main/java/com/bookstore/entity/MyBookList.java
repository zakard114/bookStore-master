package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Getters are needed to transmit data to Thymeleaf
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MyBooks")
public class MyBookList {

    @Id
    @Column(name = "book_id")
    private Long id;
    private String name;
    private String author;
    private String price;
}
