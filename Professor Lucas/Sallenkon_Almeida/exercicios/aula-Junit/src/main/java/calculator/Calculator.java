package calculator;

public class Calculator {
    public Double add(Double a, Double b) {
        return a + b;
    }
    public Double subtract(Double a, Double b) {
        return a - b;
    }
    public Double multiply(Double a, Double b) {
        return a * b;
    }
    public Double divide(Double a, Double b) {
        if(b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
    public Double pow(Double a, Double b) {
        return Math.pow(a, b);
    }
    public Double sqrt(Double a) {
        return Math.sqrt(a);
    }
}
