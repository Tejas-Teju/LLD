package com.company;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(new Calculator());
        user1.calculator.switchON();
        user1.calculator.setOperation(new Division());
        user1.calculator.calculate(2, 2);

        User user2 = new User(new Calculator());
        user2.calculator.switchON();
        user2.calculator.setOperation(new Addition());
        user2.calculator.calculate(1, 2);
    }
}