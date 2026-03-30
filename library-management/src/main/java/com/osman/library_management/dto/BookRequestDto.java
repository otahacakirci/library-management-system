package com.osman.library_management.dto;

import jakarta.validation.constraints.*;

public class BookRequestDto {

    @NotBlank(message = "Title cannot be blank.")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters" )
    private String title;

    @NotBlank(message = "Author cannot be blank.")
    @Size(min = 2, max = 60, message = "Author must be between 2 and 60 characters" )
    private String author;

    @NotNull(message = "Published Year cannot be null.")
    @Min(value = 1000, message = "Published Year must be at least 1000")
    @Max(value = 2100, message = "Published Year must be at most 2100")
    private Integer publishedYear;

    public BookRequestDto() {}

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

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
