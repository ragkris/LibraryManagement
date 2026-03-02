package com.airtribe.library.strategy;

import com.airtribe.library.model.Book;

import java.util.List;
import java.util.Map;

public interface SearchStrategy {
    List<Book> search(Map<String, Book> books, String input);
}