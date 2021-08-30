package com.epam.tat.calculator.impl;

public class TestCalc {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(2);
        System.out.println(calculator.divide(-5.2, 0.0));
    }


}
