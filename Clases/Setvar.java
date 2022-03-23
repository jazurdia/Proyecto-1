package Clases;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Setvar {
    private HashMap<String, Double> myVars;
    public Setvar(){
        myVars= new HashMap<String, Double>(); 
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
