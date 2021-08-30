package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.math.BigDecimal;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        double c = a + b;
        if (isOutOfRange(c)) {
            return c;
        }
        BigDecimal result = new BigDecimal(c);
        result = result.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
       //throw new UnsupportedOperationException("You need to implement this method");

    }

    @Override
    public double subtract(double a, double b) {
        double c = a - b;
        if (isOutOfRange(c)) {
            return c;
        }
        BigDecimal result = new BigDecimal(c);
        result = result.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
        //throw new UnsupportedOperationException("You need to implement this method");

    }

    @Override
    public double multiply(double a, double b) {
        double c = a * b;
        if (isOutOfRange(c)) {
            return c;
        }
        BigDecimal result = new BigDecimal(c);
        result = result.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
        //throw new UnsupportedOperationException("You need to implement this method");

    }

    @Override
    public double divide(double a, double b) {
        double c = a / b;
        if (isOutOfRange(c)) {
            return c;
        }
        BigDecimal result = new BigDecimal(c);
        result = result.setScale(precision, BigDecimal.ROUND_HALF_UP);

        return result.doubleValue();
        //throw new UnsupportedOperationException("You need to implement this method");

    }

    private static boolean isOutOfRange(double c) {
        return Double.isInfinite(c) || Double.isNaN(c);
    }

}
