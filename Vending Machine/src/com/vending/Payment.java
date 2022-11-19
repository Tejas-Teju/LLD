package com.vending;

import java.util.Map;

public class Payment {
    public void pay(Order order, VendingMachine vm, Map<Coin, Integer> insertedCoins) {
        int totalCost = 0, orderCost = order.getOrderCost();
        for (Map.Entry<Coin, Integer> c : insertedCoins.entrySet()) {
            totalCost +=  c.getKey().getCoinValue() * c.getValue();
        }

        if (totalCost == orderCost && vm.validate(order)) {
            vm.dispenseItems(order);
            vm.addCoins(insertedCoins);
            System.out.println("Order fulfilled\n");
        }
        else if (totalCost < orderCost) {
            System.out.println("ERROR!!! Insert more coins\n");
        } else if (totalCost > orderCost) {
            System.out.println("Validate Order, inserted coins\n");
            if(vm.validate(insertedCoins) && vm.validate(order)) {
                vm.dispenseItems(order);
                vm.deductCoins(insertedCoins);
                vm.dispenseCoins(totalCost - orderCost);
                System.out.println("Order fulfilled\n");
            } else {
                vm.dispenseInsertedCoins(insertedCoins);
                System.out.println("Please insert exact coins as Vending machine doesn't have enough coins\n");
            }
        } else {
            System.out.println("ERROR!!! vending machine doesn't have enough quantity to fulfil this order\n");
        }
    }
}
