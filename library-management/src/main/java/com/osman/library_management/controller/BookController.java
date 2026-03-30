package com.osman.library_management.controller;

import com.osman.library_management.dto.BookRequestDto;
import com.osman.library_management.entity.Book;
import com.osman.library_management.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book Controller", description = "APIs for managing books")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get all books")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Operation(summary = "Get a book by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Operation(summary = "Create a new book")
    @PostMapping
    public ResponseEntity<Book>  createBook( @Valid @RequestBody BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookService.createBook(bookRequestDto));
    }

    @Operation(summary = "Update a book")
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody  BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookService.updateBook(id , bookRequestDto));
    }

    @Operation(summary = "Delete a book")
    @DeleteMapping( "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted");
    }


}
