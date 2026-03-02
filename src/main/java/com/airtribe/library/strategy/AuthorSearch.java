package com.airtribe.library.strategy;

import com.airtribe.library.model.Book;

import java.util.List;
import java.util.Map;

public class AuthorSearch implements SearchStrategy {

    public List<Book> search(Map<String, Book> books, String author) {
        return books.values()
                .stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .toList();
    }
}