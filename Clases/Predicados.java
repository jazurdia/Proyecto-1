/**
 * Autor: Alejandro Azurdia (asignado)
 */

package Clases;

public class Predicados {

    SepararString sep = new SepararString();

    public Predicados() {
    }

    /**
     * 
     * @param a Primer número a comparar
     * @param b Segundo número a comparar
     * @return boolean
     */
    public boolean isEqual(double a, double b) {
        boolean ans = false;
        if (a == b) {
            ans = true;
        }
        return ans;

    }

    /**
     * 
     * @param a Primer número a comparar
     * @param b Segundo número a comparar
     * @return boolean
     */
    public boolean isGreater(double a, double b) {
        boolean ans = false;
        if (a > b) {
            ans = true;
        }
        return ans;
    }

    /**
     * 
     * @param a Primer número a comparar
     * @param b Segundo número a comparar
     * @return boolean
     */
    public boolean isLesser(double a, double b) {
        boolean ans = false;
        if (a < b) {
            ans = true;
        }
        return ans;
    }

    public boolean comparar(String string) {
        boolean ans = false;
        String operacion_string[] = sep.separar(string);
        String signo = operacion_string[0];
        double num1 = sep.stringToDouble(operacion_string[1]);
        double num2 = sep.stringToDouble(operacion_string[2]);

        switch (signo) {
            case "==": // equals
                ans = isEqual(num1, num2);
                break;

            case "<": // isLesser
                ans = isLesser(num1, num2);
                break;

            case ">": // isGreater
                ans = isGreater(num1, num2);
                break;
        }

        return ans;
    }

}
