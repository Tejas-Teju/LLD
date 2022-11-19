package com.vending;

public class Product {
    private String name;
    private int price;
    private int slotNo;

    Product(String name, int price, int slotNo) {
        this.name = name;
        this.price = price;
        this.slotNo = slotNo;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getSlotNo() {
        return this.slotNo;
    }
}
