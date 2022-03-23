package Clases;
import java.util.Scanner;
public class Vista {
    private Scanner scan;
    public Vista(){
		scan = new Scanner(System.in);
	} 

    public void bienvenida(){
        System.out.println("Bienvenido al interprete de Lisp");
    }

    public void despedida(){
        System.out.println("Gracias por utilizar el interprete de Lisp");
    }

    public int menuOpcionesInicio(){
        int op=0;
        try {
            String s= "¿Que deseas hacer?\n" +
                        "1. Ingresar expresión\n" +
                        "2. Salir\n";
            System.out.println(s);
            op = scan.nextInt();            
        } catch (Exception e) {
            error();
            scan.next();
        }
        return op; 
    }

    public int menuOpcionesExpresiones(){
        int op=0;
        try {
            String s= "¿Que deseas ingresar?\n" +
                        "1. Operación aritmética\n" +
                        "2. Funcion\n";
            System.out.println(s);
            op = scan.nextInt();            
        } catch (Exception e) {
            error();
            scan.next();
        }
        return op; 
    }

    public void error(){
		System.out.println("Ha ocurrido un error");
	}

    public void opcionInvalida(){
		System.out.println("Has elegido una opción inválida.");
	}

    public void print(String string){
		System.out.println(string);
	}
}
