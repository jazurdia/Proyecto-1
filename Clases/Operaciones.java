package Clases;

public class Operaciones {
    private Aritmetica aritmetica = new Aritmetica();
    private Predicados predicados = new Predicados();
    private SepararString sep = new SepararString();

    public Operaciones() {
    }

    /**
     * 
     * @param instrucciones instrucciones en formato LISP.
     * @return string, que puede ser int o boolean casteado a string.
     */
    public String operar(String instrucciones) {
        String ans = "";

        String instrucciones_array[] = sep.separar(instrucciones);// {"+", "1", "2"}
        String signo = instrucciones_array[0];

        if (signo.equals("+") || signo.equals("-") || signo.equals("*") || signo.equals("/")) {
            double temp = aritmetica.execute_aritmetica(instrucciones);
            ans = String.valueOf(temp); // ""+""
        } else if (signo.equals("==") || signo.equals("<") || signo.equals(">") || signo.equals("<=")
                || signo.equals(">=")) {
            boolean temp = predicados.comparar(instrucciones);
            ans = String.valueOf(temp);
        }

        return ans;
    }

    /**
     * Este método trabaja con parametros en String, en vez de solo una cadena de
     * texto.
     * 
     * @param signo signo a operar o comparar
     * @param a     primer numero
     * @param b     segundo numero
     * @return comparación o operación de los dos numeros, en formato String.
     */
    public String operar(String signo, String a, String b) {
        String ans = "";

        if (signo.equals("+") || signo.equals("-") || signo.equals("*") || signo.equals("/")) {

            double temp = aritmetica.execute_aritmetica(signo, a, b);
            ans = String.valueOf(temp);

        } else if (signo.equals("==") || signo.equals("<") || signo.equals(">") || signo.equals("<=")
                || signo.equals(">=")) {
            boolean temp = predicados.comparar(signo, a, b);
            ans = String.valueOf(temp);
        }

        return ans;
    }
}
