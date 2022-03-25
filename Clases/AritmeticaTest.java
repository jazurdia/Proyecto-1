import static org.junit.jupiter.api.Assertions.*;

class AritmeticaTest {

    Aritmetica ar = new Aritmetica();

    @org.junit.jupiter.api.Test
    void execute_aritmetica() {
        Double result = ar.execute_aritmetica("+", "1.0", "4.0");
        assertEquals(5, result);
    }

    @org.junit.jupiter.api.Test
    void testExecute_aritmetica() {
       Double result = ar.execute_aritmetica("(+ 1.0 1.0)");
       assertEquals(2.0, result);
    }
}