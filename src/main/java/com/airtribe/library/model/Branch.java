package com.airtribe.library.model;

import com.airtribe.library.service.InventoryService;

public class Branch {

    private final InventoryService inventory;
    private String branchId;

    public Branch(String id) {
        this.branchId = id;
        this.inventory = new InventoryService();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public InventoryService getInventory() {
        return inventory;
    }
}