package com.airtribe.library.main;

import com.airtribe.library.factory.SearchFactory;
import com.airtribe.library.model.Book;
import com.airtribe.library.model.Branch;
import com.airtribe.library.model.Loan;
import com.airtribe.library.model.Patron;
import com.airtribe.library.service.*;
import com.airtribe.library.strategy.SearchStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryApp {

    private static final Logger log = LoggerFactory.getLogger(LibraryApp.class);

    public static void main(String[] args) {
        Branch branch1 = new Branch("Chennai");
        Branch branch2 = new Branch("Bangalore");

        InventoryService inventory = new InventoryService();
        ReservationService rsv = new ReservationService();
        LendingService lend = new LendingService(rsv);

        //Add Books
        Book b1 = new Book("101", "Head First Java", "Kathy Siera", 2005);
        Book b2 = new Book("102", "System Design", "Alex Xu", 2015);
        Book b3 = new Book("103", "Fundamentals of Software Architectured", "Craig Risi", 2008);

        branch1.getInventory().addBook(b1);
        branch1.getInventory().addBook(b2);
        branch2.getInventory().addBook(b3);

        log.info("Books in {} Inventory:{} ",branch1.getBranchId(), branch1.getInventory().getAllBooks());
        log.info("Books in {} Inventory:{} ",branch2.getBranchId(), branch2.getInventory().getAllBooks());

        //Add Patron
        Patron p1 = new Patron("P01", "Kavitha");
        Patron p2 = new Patron("P02", "Sathya");


        Loan loan1 = lend.checkoutBook(b1, p1);
        Loan loan2 = lend.checkoutBook(b2, p2);


        rsv.reserveBook(b1.getBookId(), p2);

        loan1.returnBook();

        SearchStrategy s = SearchFactory.getSearchStrategy("author");

        String searchAuthor = "Alex Xu";
        log.info("Books by {} : {}", searchAuthor, s.search(branch1.getInventory().getAllBooks(), searchAuthor));


        BranchTransferService t = new BranchTransferService();
        t.transferBook("101", branch1, branch2);

        log.info("Books in {} Inventory:{} ",branch1.getBranchId(), branch1.getInventory().getAllBooks());
        log.info("Books in {} Inventory:{} ",branch2.getBranchId(), branch2.getInventory().getAllBooks());


        RecommendationService r = new RecommendationService();

        log.info("Recommended books for {} are: {}", p1.getName(), r.recommendBooks(p1, branch2.getInventory()));


    }
}