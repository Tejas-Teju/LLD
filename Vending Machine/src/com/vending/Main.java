package com.vending;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        Admin admin = new Admin();
        Map<Integer, Slot> slots = new HashMap<>();
        Product p1 = new Product("Pepsi", 20, 1);
        Product p2 = new Product("Lays", 5, 2);
        slots.put(1, new Slot(p1, 10));
        slots.put(2, new Slot(p2, 10));
        admin.loadSlotsForVM(vm, slots);

        Map<Coin, Integer> coins = new HashMap<>();
        coins.put(Coin.TEN, 2);
        coins.put(Coin.FIVE, 3);
        coins.put(Coin.TWO, 5);
        coins.put(Coin.ONE, 5);
        admin.loadCoinsForVM(vm, coins);

        vm.displaySlotsData();
        vm.displayCoinsData();

        Order order = new Order();
        order.addItems(p1, 0);
        order.addItems(p2, 11);
        order.confirmOrder();

        Map<Coin, Integer> insertedcoins = new HashMap<>();
        insertedcoins.put(Coin.TEN, 5);
        insertedcoins.put(Coin.FIVE, 1);
        insertedcoins.put(Coin.TWO, 0);
        insertedcoins.put(Coin.ONE, 0);
        order.pay(vm, insertedcoins);

        vm.displayCoinsData();
        vm.displaySlotsData();
    }
}
