package Clases;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Interprete {
    private HashMap<String, Double> myVars;
    private Aritmetica aritmetica = new Aritmetica();

    public Interprete(){
        myVars= new HashMap<String, Double>(); 
    }
    public void Operar(String expresion) { // "+ 2 2"
        int state = ScannerSintax.getExpresion(expresion);
        switch (state) {
            case 1:
                SetVar(expresion);
                break;
        
            case 2:

                String expresion_array[] = expresion.split(" ");
                double a = Double.parseDouble(expresion_array[1]);
                double b = Double.parseDouble(expresion_array[2]);
                double respuesta =  aritmetica.execute_aritmetica(a, b, expresion_array[0]);

                System.out.println(respuesta);

                //(+ 1 (+ 1 2))

                break;
        }
    }

    public void SetVar(String expresion) {
        Pattern pattern = Pattern.compile("[ ]+[a-z]+[ ]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expresion);
        String Nombre = "";
	    double Valor = 0; 
        if (matcher.find()) {
            Nombre = matcher.group();
        }
        pattern = Pattern.compile("[ ]+[0-9]+[ ]*", Pattern.CASE_INSENSITIVE); //
        matcher = pattern.matcher(expresion);
        if (matcher.find()) {
            Valor = Integer.parseInt(matcher.group().trim());
        }
        myVars.put(Nombre, Valor);
        System.out.println("Variable: " + Nombre + " asignada con valor " + Valor);
    }
}
