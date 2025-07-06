package com.library.controller;

import com.library.service.BookService;

public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void issue(String title) {
        System.out.println("Controller: Request received to issue book");
        bookService.issueBook(title);
    }
}
