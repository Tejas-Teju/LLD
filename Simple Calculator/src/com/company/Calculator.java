package com.company;

public class Calculator {
    private boolean ON = false;
    private boolean OFF = true;
    private IOperation operation;

    Calculator() {

    }

    Calculator(IOperation operation) {
        this.operation = operation;
    }

    public void switchON() {
        ON = !ON;
        OFF = !OFF;
        System.out.println("Switched ON calculator");
    }

    public void switchOFF() {
        ON = !ON;
        OFF = !OFF;
        System.out.println("Switched OFF calculator");
    }

    public void calculate(int num1, int num2) {
        if(ON && operation != null) {
            System.out.println(num1 + " " + operation.operator() + " " + num2 + " = " + operation.calculate(num1, num2));
        } else if(OFF) {
            System.out.println("Calculator is OFF, switch it ON! to calculate");
        } else {
            System.out.println("Operation is not defined, set the operation.");
        }
    }

    public void setOperation(IOperation operation) {
        this.operation = operation;
    }
}
