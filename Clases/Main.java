package Clases;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /**
        Interprete miLispInterpreter = new Interprete();
        Vista v=new Vista(); 
		Scanner in = new Scanner(System.in);
        v.bienvenida();
        System.out.println("Bienvenido al interpreter Lisp ingrese una expresion o escriba exit para salir");
        String opt = "";
        opt = in.nextLine();
        miLispInterpreter.Operar(opt);

        */

        Aritmetica aritmetica = new Aritmetica();
        aritmetica.execute_aritmetica_2("(+ 1.0 2.0)");

    }
}
