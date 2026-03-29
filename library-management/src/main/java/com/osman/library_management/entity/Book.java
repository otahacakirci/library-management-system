package com.osman.library_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank.")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters.")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Author cannot be blank.")
    @Size(min = 2, max = 60, message = "Title must be between 2 and 60 characters.")
    @Column(nullable = false)
    private String author;

    @Min(value = 1000, message = "Published year must be at least 1000")
    @Max(value = 2100, message = "Published year cannot be greater than 2100")
    @Column(nullable = false)
    private int publicationYear;

    public Book() {

    }

    public Book(Long id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
