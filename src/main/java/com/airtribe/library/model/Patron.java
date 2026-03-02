package com.airtribe.library.model;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private String id;
    private String name;
    private List<Loan> history = new ArrayList<>();

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name + " (" + id + ")";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLoan(Loan loan) {
        history.add(loan);
    }

    public List<Loan> getHistory() {
        return history;
    }

    public void setHistory(List<Loan> history) {
        this.history = history;
    }
}