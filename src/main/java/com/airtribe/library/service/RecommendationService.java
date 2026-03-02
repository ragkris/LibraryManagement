package com.airtribe.library.service;

import com.airtribe.library.model.Book;
import com.airtribe.library.model.Loan;
import com.airtribe.library.model.Patron;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecommendationService {

    public List<Book> recommendBooks(
            Patron patron,
            InventoryService inventory) {

        Set<String> authors = new HashSet<>();

        for (Loan l : patron.getHistory())
            authors.add(l.getBook().getAuthor());

        List<Book> result = new ArrayList<>();

        for (Book b : inventory.getAllBooks().values())
            if (authors.contains(b.getAuthor()))
                result.add(b);

        return result;
    }
}