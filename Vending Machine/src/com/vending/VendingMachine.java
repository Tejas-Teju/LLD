package com.vending;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    Map<Integer, Slot> slots;
    Map<Coin, Integer> coins;

    VendingMachine() {
        this.slots = new HashMap<>();
        this.coins = new HashMap<>();
    }

    public void displaySlotsData() {
        for (Map.Entry<Integer, Slot> e : slots.entrySet()) {
            System.out.println("Slot #" + e.getKey() + " Product: " + e.getValue().product.getName() + " Qty: " + e.getValue().qty);
        }
    }

    public void displayCoinsData() {
        for (Map.Entry<Coin, Integer> e : coins.entrySet()) {
            System.out.println("Coin: " + e.getKey() + " Qty: " + e.getValue());
        }
    }

    public void setSlots(Map<Integer, Slot> slots) {
        this.slots = slots;
    }

    public void setCoins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public boolean validate(Map<Coin, Integer> coins) {
        for (Map.Entry<Coin, Integer> c : coins.entrySet()) {
            if (this.coins.get(c.getKey()) == null || c.getValue() > this.coins.get(c.getKey())) {
                System.out.println("c.getValue()" + c.getValue() + " this.coins.get(c.getKey())" + this.coins.get(c.getKey()) + " decision" + (c.getValue() > this.coins.get(c.getKey())));
                return false;
            }
        }

        return true;
    }

    public boolean validate(Order order) {
        for (Map.Entry<Product, Integer> p : order.getOrderedItems().entrySet()) {
            if (slots.get(p.getKey().getSlotNo()).qty < p.getValue()) return false;
        }

        return true;
    }

    public void dispenseItems(Order order) {
        System.out.println("Items dispensed are as follow:");
        for (Map.Entry<Product, Integer> p : order.getOrderedItems().entrySet()) {
            slots.get(p.getKey().getSlotNo()).qty = slots.get(p.getKey().getSlotNo()).qty - p.getValue();
            System.out.println("Product: " + p.getKey().getName() + " Qty: " + p.getValue());
        }
    }

    public void dispenseInsertedCoins(Map<Coin, Integer> insertedCoins) {
        System.out.println("Dispense coins" + insertedCoins);
    }

    public void deductCoins(Map<Coin, Integer> insertedCoins) {
        for (Map.Entry<Coin, Integer> c : insertedCoins.entrySet()) {
            this.coins.put(c.getKey(), this.coins.getOrDefault(c.getKey(), 0) - c.getValue());
        }
    }

    public void addCoins(Map<Coin, Integer> insertedCoins) {
        for (Map.Entry<Coin, Integer> c : insertedCoins.entrySet()) {
            this.coins.put(c.getKey(), this.coins.getOrDefault(c.getKey(), 0) + c.getValue());
        }
    }

    public void dispenseCoins(int amount) {
        Map<Coin, Integer> coinsToDispense = new HashMap<>();

        int count = amount / Coin.TEN.getCoinValue();
        coinsToDispense.put(Coin.TEN, coinsToDispense.getOrDefault(Coin.TEN, 0) + count);
        this.coins.put(Coin.TEN, coins.getOrDefault(Coin.TEN, 0) - count);
        amount -= Coin.TEN.getCoinValue() * count;
        System.out.println("10: " + count);

        count = amount / Coin.FIVE.getCoinValue();
        coinsToDispense.put(Coin.FIVE, coinsToDispense.getOrDefault(Coin.FIVE, 0) + count);
        this.coins.put(Coin.FIVE, coins.getOrDefault(Coin.FIVE, 0) - count);
        amount -= Coin.FIVE.getCoinValue() * (amount / Coin.FIVE.getCoinValue());
        System.out.println("5: " + count);

        count = amount / Coin.TWO.getCoinValue();
        coinsToDispense.put(Coin.TWO, coinsToDispense.getOrDefault(Coin.TWO, 0) + count);
        this.coins.put(Coin.TWO, coins.getOrDefault(Coin.TWO, 0) - count);
        amount -= Coin.TWO.getCoinValue() * (amount / Coin.TWO.getCoinValue());
        System.out.println("2: " + count);

        count = amount / Coin.ONE.getCoinValue();
        coinsToDispense.put(Coin.ONE, coinsToDispense.getOrDefault(Coin.ONE, 0) + count);
        this.coins.put(Coin.ONE, coins.getOrDefault(Coin.ONE, 0) - count);
        amount -= Coin.ONE.getCoinValue() * (amount / Coin.ONE.getCoinValue());
        System.out.println("1: " + count);
    }
}
