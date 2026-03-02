package com.airtribe.library.factory;

import com.airtribe.library.strategy.AuthorSearch;
import com.airtribe.library.strategy.BookIdSearch;
import com.airtribe.library.strategy.SearchStrategy;
import com.airtribe.library.strategy.TitleSearch;

public class SearchFactory {

    public static SearchStrategy getSearchStrategy(String type) {

        switch (type.toLowerCase()) {

            case "title":
                return new TitleSearch();

            case "author":
                return new AuthorSearch();

            case "bookId":
                return new BookIdSearch();

            default:
                throw new IllegalArgumentException("Invalid search type");
        }
    }
}