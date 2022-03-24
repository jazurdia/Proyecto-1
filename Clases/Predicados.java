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
    private boolean isEqual(double a, double b) {
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
    private boolean isGreater(double a, double b) {
        boolean ans = false;
        if (a > b) {
            ans = true;
        }
        return ans;
    }

    /**
     * 
     * @param a primer numero a comparar.
     * @param b segundo numero a comparar.
     * @return boolean.
     */
    private boolean isGreaterOrEqual(double a, double b) {
        boolean ans = false;
        if (a >= b) {
            ans = true;
        }
        return ans;
    }

    /**
     * 
     * @param a Primer número a comparar.
     * @param b Segundo número a comparar.
     * @return
     */
    private boolean isLesserOrEqual(double a, double b) {
        boolean ans = false;
        if (a <= b) {
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
    private boolean isLesser(double a, double b) {
        boolean ans = false;
        if (a < b) {
            ans = true;
        }
        return ans;
    }

    /**
     * 
     * @param string instrucciones para comparación en forma de String.
     * @return boolean. True si se cumplen las condiciones, false si no.
     */
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

            case ">=":
                ans = isGreaterOrEqual(num1, num2);
                break;

            case "<=":
                ans = isLesserOrEqual(num1, num2);
                break;

        }

        return ans;
    }

}
