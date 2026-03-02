package com.airtribe.library.observer;

import com.airtribe.library.model.Patron;
import com.airtribe.library.service.LendingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatronObserver implements Observer {


    private static final Logger log = LoggerFactory.getLogger(PatronObserver.class);


    private final Patron patron;

    public PatronObserver(Patron p) {
        this.patron = p;
    }

    @Override
    public void update(String bookId) {

        log.info(
                "Notification to " + patron.getName() +
                        " : Reserved Book Available -> " + bookId);

    }
}