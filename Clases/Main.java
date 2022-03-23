package Clases;

public class Main {
    public static void main(String[] args) {
        
        Aritmetica aritmetica = new Aritmetica();
        double resultado = aritmetica.execute_aritmetica(2.0, 3.0, "/");
        System.out.println(resultado);

    }
}
