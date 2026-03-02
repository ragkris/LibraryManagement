package com.airtribe.library.strategy;

import com.airtribe.library.model.Book;

import java.util.List;
import java.util.Map;

public class TitleSearch implements SearchStrategy {

    public List<Book> search(Map<String, Book> books, String title) {
        return books.values()
                .stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .toList();
    }
}