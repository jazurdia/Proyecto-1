/**
 * Autor: Alejandro Azurdia (asignado)
 */

package Clases;

public class Aritmetica {
    public Aritmetica() {
    }

    public double execute_aritmetica(double numero_a, double numero_b, String operacion){
        double ans;

        switch (operacion) {
            case "+":
                ans = numero_a + numero_b;
                break;
        
            case "-":
                ans = numero_a - numero_b;
                break;

            case "*":
                ans = numero_a * numero_b;
                break;

            case "/":
                ans = numero_a / numero_b;
                break;

            default:
                ans = 0;
                break;

        }
        
        return ans;
    }

}
