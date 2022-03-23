/**
 * Autor: Alejandro Azurdia (asignado)
 */

package Clases;

public class Aritmetica {

    double numero_a;
    double numero_b;
    String operacion;

    public Aritmetica(double numero_a, double numero_b, String operacion) {
        this.numero_a = numero_a;
        this.numero_b = numero_b;
        this.operacion = operacion;
    }

    public double execute_aritmetica(String operacion){
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
