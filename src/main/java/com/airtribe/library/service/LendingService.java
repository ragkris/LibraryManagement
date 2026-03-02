package com.airtribe.library.service;

import com.airtribe.library.model.Book;
import com.airtribe.library.model.Loan;
import com.airtribe.library.model.Patron;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LendingService {


    private static final Logger log = LoggerFactory.getLogger(LendingService.class);


    private final ReservationService
            reservationService;

    public LendingService(
            ReservationService rs) {

        this.reservationService = rs;
    }

    public Loan checkoutBook(
            Book b,
            Patron p) {

        if (!b.isAvailable()) {

            log.error(
                    "Book not available. Please reserve.");

            return null;
        }

        b.setAvailable(false);

        Loan loan =
                new Loan(b, p, reservationService);

        p.addLoan(loan);
        log.info("Book issued to patron {}: {}", p.getName(), b.getBookId());
        return loan;
    }
}
