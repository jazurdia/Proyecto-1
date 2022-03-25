import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredicadosTest {
    Predicados predicados = new Predicados();

    @Test
    void comparar() {
        var result = predicados.comparar("(== 1.0 1.0)");
        assertEquals(true, result);
    }

    @Test
    void testComparar() {
        var result = predicados.comparar("==", "3.0", "2.0");
        assertEquals(false, result);
    }
}