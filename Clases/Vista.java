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

    public void error(){
		System.out.println("Ha ocurrido un error");
	}

    public void print(String string){
		System.out.println(string);
	}
}
