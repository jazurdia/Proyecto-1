//package Clases;

/**
 *
 * Proyecto 1: Interprete para LISP
 * Autores: Diego Morales y Alejandro Azurdia
 * Ingeniería en Computación y Tecnologías de la información.
 * Estructuras de bases de datos. 
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Interprete LispInterpreter = new Interprete();
        Vista v = new Vista();
        Scanner in = new Scanner(System.in);
        v.bienvenida();
        v.print("Ingrese una expresion o escriba 'exit' para salir");
        String opt = "";
        do {
            opt = in.nextLine();
            if (!opt.toUpperCase().equals("EXIT")) {
                LispInterpreter.Operar(opt);
            } else {
                v.despedida();
            }
        } while (!opt.toUpperCase().equals("EXIT"));

    }
}
