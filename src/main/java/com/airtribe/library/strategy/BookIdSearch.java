package com.airtribe.library.strategy;

import com.airtribe.library.model.Book;

import java.util.List;
import java.util.Map;

public class BookIdSearch implements SearchStrategy {

    public List<Book> search(Map<String, Book> books, String bookId) {
        return books.values()
                .stream()
                .filter(b -> b.getBookId().equalsIgnoreCase(bookId))
                .toList();
    }
}