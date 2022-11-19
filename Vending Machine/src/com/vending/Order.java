package com.vending;

import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<Product, Integer> items;
    boolean orderConfirmed;

    Order() {
        this.items = new HashMap<>();
        this.orderConfirmed = false;
    }

    public void addItems(Product p, int qty) {
        this.items.put(p, items.getOrDefault(p, 0) + qty);
    }

    public void deleteItems(Product p, int qty) {
        if (this.items.get(p) != null && this.items.get(p) != 0) {
            this.items.put(p, items.get(p) - qty);
        }
    }

    public void confirmOrder() {
        this.orderConfirmed = true;
    }

    public void revertOrder() {
        this.orderConfirmed = false;
    }

    public void pay(VendingMachine vm, Map<Coin, Integer> coins) {
        if (orderConfirmed) {
            Payment p = new Payment();
            p.pay(this, vm, coins);
        } else {
            System.out.println("Please confirm the order!!");
        }
    }

    public int getOrderCost() {
        int totalCost = 0;
        for (Map.Entry<Product, Integer> p : items.entrySet()) {
            totalCost += p.getKey().getPrice() * p.getValue();
        }

        return totalCost;
    }

    public Map<Product, Integer> getOrderedItems() {
        return items;
    }
}
