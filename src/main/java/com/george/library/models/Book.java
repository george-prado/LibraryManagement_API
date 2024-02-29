package com.george.library.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter private long id;
    @Setter @Getter private String name;
    @Setter @Getter private String slug;
    @Setter @Getter private String author;
    @Setter @Getter private String holder;
    @Setter @Getter private boolean available;
    @Setter @Getter private LocalDateTime arrivedAt;
    @Setter @Getter private LocalDateTime borrowedAt;

    public Book() {
    }

    public Book(String name, String slug, String author, String holder, boolean available, LocalDateTime arrivedAt) {
        this.name = name;
        this.slug = slug;
        this.author = author;
        this.holder = holder;
        this.available = available;
        this.arrivedAt = arrivedAt;
    }
}