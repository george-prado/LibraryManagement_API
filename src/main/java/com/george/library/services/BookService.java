package com.george.library.services;

import com.george.library.models.Book;
import com.george.library.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book borrowBook(Long bookId, String holder) throws ChangeSetPersister.NotFoundException {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        existingBook.setHolder(holder);
        existingBook.setBorrowedAt(LocalDateTime.now());


        return bookRepository.save(existingBook);
    }

    @Transactional
    public Book returnBook(Long bookId) throws ChangeSetPersister.NotFoundException {

        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        existingBook.setHolder(null);
        existingBook.setBorrowedAt(null);

        return bookRepository.save(existingBook);
    }

}
