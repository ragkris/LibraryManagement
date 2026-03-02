package com.airtribe.library.service;

import com.airtribe.library.model.Book;
import com.airtribe.library.model.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BranchTransferService {
    private static final Logger log = LoggerFactory.getLogger(BranchTransferService.class);

    public void transferBook(
            String bookId,
            Branch from,
            Branch to) {

        Book b = from.getInventory().getBook(bookId);
        from.getInventory().removeBook(bookId);
        to.getInventory().addBook(b);

        log.info("Book {} transferred from {} to {}", bookId, from.getBranchId(), to.getBranchId());
    }
}