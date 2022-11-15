package com.company;

public class Addition implements IOperation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public String operator() {
        return "+";
    }
}
