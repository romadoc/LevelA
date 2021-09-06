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

    }

    private static boolean isOutOfRange(double c) {
        return Double.isInfinite(c) || Double.isNaN(c);
    }

}
