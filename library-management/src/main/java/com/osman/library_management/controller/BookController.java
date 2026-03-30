package com.osman.library_management.controller;

import com.osman.library_management.dto.BookRequestDto;
import com.osman.library_management.entity.Book;
import com.osman.library_management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<Book>  createBook( @Valid @RequestBody BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookService.createBook(bookRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody  BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookService.updateBook(id , bookRequestDto));
    }

    @DeleteMapping( "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted");
    }


}
