/**
 * Autor: Alejandro Azurdia (asignado)
 */

package Clases;

public class Aritmetica {

    SepararString sep = new SepararString();

    public Aritmetica() {
    }

    /**
     * 
     * @param string instrucciones en formato LISP como String.
     * @return resultado de la operación aritmética.
     */
    public double execute_aritmetica(String string) {
        double ans;
        String operacion_string[] = sep.separar(string);

        String signo = operacion_string[0];
        double num1 = sep.stringToDouble(operacion_string[1]);
        double num2 = sep.stringToDouble(operacion_string[2]);

        switch (signo) {
            case "+":
                ans = num1 + num2;
                break;

            case "-":
                ans = num1 - num2;
                break;

            case "*":
                ans = num1 * num2;
                break;

            case "/":
                ans = num1 / num2;
                break;

            default:
                ans = 0;
                break;
        }

        return ans;
    }

    /**
     * Este método utiliza varias variables en vez de una sola cadena de texto.
     * 
     * @param signo operador
     * @param a     primero numero
     * @param b     segundo numero
     * @return double con la operación efectuada por el primer y segundo numero.
     */
    public double execute_aritmetica(String signo, String a, String b) {
        double ans = 0.0;

        double num1 = sep.stringToDouble(a);
        double num2 = sep.stringToDouble(b);

        switch (signo) {
            case "+":
                ans = num1 + num2;
                break;

            case "-":
                ans = num1 - num2;
                break;

            case "*":
                ans = num1 * num2;
                break;

            case "/":
                ans = num1 / num2;
                break;

            default:
                ans = 0;
                break;
        }

        return ans;
    }
}
