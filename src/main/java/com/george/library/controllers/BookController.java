package com.george.library.controllers;

import com.george.library.models.Book;
import com.george.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<String> getAllBooks() {
        return ResponseEntity.ok("All good man");
    }


    @PostMapping("/book/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        try {
            Book savedBook = bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added with ID: " + savedBook.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding the book");
        }
    }

    @PostMapping("/book/update")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        try {
            Book savedBook = bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added with ID: " + savedBook.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding the book");
        }
    }

    @PutMapping("/{id}/borrow")
    public ResponseEntity<String> borrowBook(@PathVariable Long id, @RequestParam String holder) {
        Book borrowedBook = null;
        try {
            borrowedBook = bookService.borrowBook(id, holder);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Borrowed to: " + borrowedBook.getHolder());
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<String> returnBook(@PathVariable Long id) {
        Book returnedBook = null;
        try {
            returnedBook = bookService.returnBook(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Returned by: " + returnedBook.getHolder());
    }
}


