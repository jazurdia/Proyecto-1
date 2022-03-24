package Clases;

public class Operaciones {
    private Aritmetica aritmetica = new Aritmetica();
    private Predicados predicados = new Predicados();
    private SepararString sep = new SepararString();

    public Operaciones() {
    }

    public String operar(String instrucciones) {
        String ans = "";

        String instrucciones_array[] = sep.separar(instrucciones);
        String signo = instrucciones_array[0];

        if (signo.equals("+") || signo.equals("-") || signo.equals("*") || signo.equals("/")) {
            double temp = aritmetica.execute_aritmetica(instrucciones);
            ans = String.valueOf(temp); // ""+""
        } else if (signo.equals("==") || signo.equals("<") || signo.equals(">")) {
            boolean temp = predicados.comparar(instrucciones);
            ans = String.valueOf(temp);
        }

        return ans;
    }
}
