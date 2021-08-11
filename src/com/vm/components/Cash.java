package com.vm.components;

public class Cash {

    private String name;
    private double value;

    public Cash(double value) { }
    public Cash(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

}
