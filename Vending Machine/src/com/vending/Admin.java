package com.vending;

import java.util.Map;

public class Admin {
    public void loadSlotsForVM(VendingMachine vm, Map<Integer, Slot> slots) {
        vm.setSlots(slots);
    }

    public void loadCoinsForVM(VendingMachine vm, Map<Coin, Integer> coins) {
        vm.setCoins(coins);
    }
}
