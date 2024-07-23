package org.example;

import jakarta.xml.ws.Endpoint;


// esta aplicacao seria um servidor
public class Main {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();

        Endpoint.publish("http://localhost:8085/Calculator", calculator);
        System.out.println("Web service is ready!");

    }
}