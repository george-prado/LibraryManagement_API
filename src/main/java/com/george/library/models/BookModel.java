package com.george.library.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class BookModel {
    @Setter @Getter private long id;
    @Setter @Getter private String name;
    @Setter @Getter private String slug;
    @Setter @Getter private String author;
    @Setter @Getter private String holder;
    @Setter @Getter private boolean available;
    @Setter @Getter private LocalDateTime arrivedAt;
    @Setter @Getter private LocalDateTime borrowedAt;


    public BookModel(long id, String name, String slug, String author, String holder, boolean available, LocalDateTime arrivedAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.author = author;
        this.holder = holder;
        this.available = available;
        this.arrivedAt = arrivedAt;
    }
}