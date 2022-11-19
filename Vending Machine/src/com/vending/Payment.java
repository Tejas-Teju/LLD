package com.vending;

import java.util.Map;

public class Payment {
    public void pay(Order order, VendingMachine vm, Map<Coin, Integer> insertedCoins) {
        int totalCost = 0, orderCost = order.getOrderCost();
        for (Map.Entry<Coin, Integer> c : insertedCoins.entrySet()) {
            totalCost +=  c.getKey().getCoinValue() * c.getValue();
        }

        if (totalCost == orderCost) {
            vm.dispenseItems(order);
            vm.addCoins(insertedCoins);
            System.out.println("Order fulfilled\n");
        }
        else if (totalCost < orderCost) {
            System.out.println("ERROR!!! Insert more coins\n");
        } else {
            if(vm.validate(insertedCoins)) {
                vm.dispenseItems(order);
                vm.deductCoins(insertedCoins);
                vm.dispenseCoins(totalCost - orderCost);
                System.out.println("Order fulfilled\n");
            } else {
                vm.dispenseInsertedCoins(insertedCoins);
                System.out.println("Please insert exact coins as Vending machine doesn't have enough coins\n");
            }
        }
    }
}
