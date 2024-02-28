package com.george.library.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookController {

    @GetMapping
    public ResponseEntity<String> getAllBooks() {
        return ResponseEntity.ok("All good man");
    }
}


