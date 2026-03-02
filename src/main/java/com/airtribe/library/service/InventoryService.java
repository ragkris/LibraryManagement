package com.airtribe.library.service;

import com.airtribe.library.model.Book;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    public Map<String, Book> getAllBooks() {
        return books;
    }
}