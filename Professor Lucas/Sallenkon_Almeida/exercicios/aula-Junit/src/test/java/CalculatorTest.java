import calculator.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    double a;
    double b;
    double res;
    Calculator calculator;


    @BeforeAll
    static void setUpBeforeClass() throws Exception {

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {}

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
        a = 5;
        b = 2;
        res = 0;
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }

    @Test
    public void testSub() {
        res = calculator.subtract(a, b);
        assertEquals(3, res);
    }

    @Test
    public void testMultiply() {
        res = calculator.multiply(a, b);
        assertEquals(2.5, res);
    }

    @Test
    public void testDivide() {
        res = calculator.divide(a, b);
        assertEquals(2.5, res);
    }

    @Test
    public void testDivideByZero() {
        b = 0;
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        String message = exception.getMessage();
        String expected = "Division by zero";
        assertEquals(expected, message);
    }

    @Test
    public void testPow() {
        res = calculator.pow(a, b);
        assertEquals(25, res);
    }

    @Test
    public void testSqrt() {
        res = calculator.sqrt(a);
        assertEquals(2, res);
    }
}
