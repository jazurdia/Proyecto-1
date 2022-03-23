/**
 * Autor: Alejandro Azurdia (asignado)
 */

package Clases;

import java.util.ArrayList;

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

    public void execute_aritmetica_2(String string){
        double ans = 0;

        string = string.replace("(", "");
        string = string.replace(")", "");
        String array_string[] = string.split(" ");

        //for(int i = 0; i<array_string.length; i++){
        //    System.out.println(array_string[i]);
        //}

        double number_one = Double.parseDouble(array_string[1]);
        double number_two = Double.parseDouble(array_string[2]);

        System.out.println(execute_aritmetica(number_one, number_two, array_string[0]));


        //return ans;
    }

}
