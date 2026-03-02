package com.airtribe.library.model;

import com.airtribe.library.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Loan {


    private static final Logger log = LoggerFactory.getLogger(Loan.class);


    private final Book book;
    private final Patron patron;
    private final LocalDate issueDate;
    private final ReservationService
            reservationService;
    private LocalDate returnDate;

    public Loan(Book b,
                Patron p,
                ReservationService rs) {

        this.book = b;
        this.patron = p;
        this.reservationService = rs;

        issueDate = LocalDate.now();
    }

    public void returnBook() {

        returnDate = LocalDate.now();
        book.setAvailable(true);

        //Notify waitlist automatically
        reservationService.notifyAvailability(book.getBookId());

        log.info("Book " + book.getBookId() + " has been returned by " + patron.getName());
    }

    public Book getBook() {
        return book;
    }


}