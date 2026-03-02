package com.airtribe.library.service;

import com.airtribe.library.model.Patron;
import com.airtribe.library.observer.Observer;
import com.airtribe.library.observer.PatronObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReservationService {
    private static final Logger log =LoggerFactory.getLogger(ReservationService.class);

    //Book id → Waiting Patrons
    private final Map<String, List<Observer>> waitList =
            new HashMap<>();

    //Reserve Book
    public void reserveBook(String bookId,Patron patron) { Observer observer = new PatronObserver(patron);
        waitList.computeIfAbsent(bookId, k -> new ArrayList<>()) .add(observer);

       log.info(  "{} added to waitlist for Book: {} " ,patron.getName(), bookId);
    }

    //Notify all waiting patrons
    public void notifyAvailability(String bookId) {

        if (waitList.containsKey(bookId)) {

           log.info("Book returned. Notifying patrons...");

            for (Observer o :waitList.get(bookId)) {

                o.update(bookId);
            }

            //clear waitlist after notifying
            waitList.remove(bookId);
        }
    }
}