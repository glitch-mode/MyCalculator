package com.example.mycalculator.Model;

public class Calculator {
    private long firstInt;
    private long secondInt;
    private long intMemory = 0;
    private double firstDouble;
    private double secondDouble;
    private double doubleMemory = 0;
//Integer number___________________________
    //add___________________________

    public long add(long a, long b) {
        firstInt = a;
        secondInt = b;
        intMemory = firstInt + secondInt;
        return firstInt + secondInt;
    }

    public long add(long a) {
        intMemory += a;
        return intMemory;
    }

    //subtraction_________________________
    public long subtraction(long a, long b) {
        firstInt = a;
        secondInt = b;
        intMemory = firstInt - secondInt;
        return firstInt - secondInt;
    }

    public long subtraction(long a) {
        intMemory -= a;
        return intMemory;
    }

    //multiply_________________________
    public long multiply(long a, long b) {
        firstInt = a;
        secondInt = b;
        intMemory = firstInt * secondInt;
        return firstInt * secondInt;
    }

    public long multiply(long a) {
        intMemory *= a;
        return intMemory;
    }

    //division_________________________
    public long division(long a, long b) {
        firstInt = a;
        if (b != 0) secondInt = b;
        else System.out.println("error div by 0");
        intMemory = firstInt / secondInt;
        return intMemory;
    }

    public long division(long a) {
        if (a != 0) intMemory /= a;
        else System.out.println("error div by 0");
        return intMemory;
    }


    //Double Number______________________
    //add____________________________
    public double add(double a, double b) {
        firstDouble = a;
        secondDouble = b;
        doubleMemory = firstDouble + secondDouble;
        return firstDouble + secondDouble;
    }

    public double add(long a, double b) {
        firstInt = a;
        secondDouble = b;
        doubleMemory = firstInt + secondDouble;
        return firstInt + secondDouble;
    }

    public double add(double a, long b) {
        firstDouble = a;
        secondInt = b;
        doubleMemory = firstDouble + secondInt;
        return firstDouble + secondInt;
    }

    public double add(double a) {
        doubleMemory += a;
        return doubleMemory;
    }

    //subtraction_________________________
    public double subtraction(double a, double b) {
        firstDouble = a;
        secondDouble = b;
        doubleMemory = firstDouble - secondDouble;
        return firstDouble - secondDouble;
    }

    public double subtraction(long a, double b) {
        firstInt = a;
        secondDouble = b;
        doubleMemory = firstInt - secondDouble;
        return firstInt - secondDouble;
    }

    public double subtraction(double a, long b) {
        firstDouble = a;
        secondInt = b;
        doubleMemory = firstDouble - secondInt;
        return firstDouble - secondInt;
    }

    public double subtraction(double a) {
        doubleMemory -= a;
        return doubleMemory;
    }

    //multiply_________________________
    public double multiply(double a, double b) {
        firstDouble = a;
        secondDouble = b;
        doubleMemory = firstDouble * secondDouble;
        return firstDouble * secondDouble;
    }

    public double multiply(long a, double b) {
        firstInt = a;
        secondDouble = b;
        doubleMemory = firstInt * secondDouble;
        return firstInt * secondDouble;
    }

    public double multiply(double a, long b) {
        firstDouble = a;
        secondInt = b;
        doubleMemory = firstDouble * secondInt;
        return firstDouble * secondInt;
    }

    public double multiply(double a) {
        doubleMemory *= a;
        return doubleMemory;
    }

    //division_________________________
    public double division(double a, double b) {
        firstDouble = a;
        if (b != 0) secondDouble = b;
        else System.out.println("error div by 0");
        doubleMemory = firstDouble / secondDouble;
        return doubleMemory;
    }

    public double division(long a, double b) {
        firstInt = a;
        secondDouble = b;
        doubleMemory = firstInt / secondDouble;
        return doubleMemory;
    }

    public double division(double a, long b) {
        firstDouble = a;
        secondInt = b;
        doubleMemory = firstDouble / secondInt;
        return secondInt;
    }

    public double division(double a) {
        if (a != 0) doubleMemory /= a;
        else System.out.println("error div by 0");
        return doubleMemory;
    }

    //reset
    public void reset() {
        intMemory = 0;
        doubleMemory = 0;
    }
}
