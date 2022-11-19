package com.vending;

public class Slot {
    Product product;
    int qty;

    Slot(Product product, int quantity) {
        this.product = product;
        this.qty = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return qty;
    }

    public void decrementQuantity() {
        this.qty--;
    }

    public void updateQuantity(int quantity) {
        this.qty = quantity;
    }
}
