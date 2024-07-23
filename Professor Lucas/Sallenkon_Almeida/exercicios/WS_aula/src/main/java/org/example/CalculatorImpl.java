package org.example;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.example.Calculator")
public class CalculatorImpl implements Calculator {
    @Override
    public double add(double x, double y) {
        return x + y;
    }

    @Override
    public double sub(double x, double y) {
        return x - y;
    }

    @Override
    public double div(double x, double y) {
        return x / y;
    }

    @Override
    public double multi(double x, double y) {
        return x * y;
    }
}
