//package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    private Scanner scan;

    public Vista() {
        scan = new Scanner(System.in);
    }

    public void bienvenida() {
        System.out.println("Bienvenido al interprete de Lisp");
    }

    public void despedida() {
        System.out.println("Gracias por utilizar el interprete de Lisp");
    }

    public void error() {
        System.out.println("Ha ocurrido un error");
    }

    
    /** 
     * @param string
     */
    public void print(String string) {
        System.out.println(string);
    }

    
    /** 
     * @param nombre
     * @param variables
     * @return ArrayList<Double>
     */
    public ArrayList<Double> funcion(String nombre, int variables) {
        System.out.println("Ingrese el/los valores de: " + nombre);
        ArrayList<Double> valores_variables = new ArrayList<>();

        print("valor de variable 1");
        valores_variables.add(scan.nextDouble());

        return valores_variables;

    }
}
