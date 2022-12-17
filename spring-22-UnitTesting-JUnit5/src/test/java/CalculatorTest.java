import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Adding Method")
    void add() {

        int actual = Calculator.add(2,3);
        assertEquals(5, actual, "Test faild ");

    }
    @Test

    void cas2() {

        assertEquals("add",Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));

    }
}