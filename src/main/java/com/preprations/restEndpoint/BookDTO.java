package com.preprations.restEndpoint;

// 2. Book DTO
public class BookDTO {
    //@NotBlank
    private String title;

    //@NotBlank
    private String author;

    // Getters and Setters


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}