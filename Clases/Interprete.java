package Clases;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Interprete {
    private HashMap<String, Double> myVars;
    Operaciones op = new Operaciones();
    Vista v = new Vista(); 
    public Interprete() {
        myVars = new HashMap<String, Double>();
    }

    public void Operar(String expresion) { 
        int state = ScannerSintax.getExpresion(expresion);
        switch (state) {
            case 1:
                SetVar(expresion);
                break;

            case 2: // operar. Debe llevar aritmetica o predicados.
                String result = op.operar(expresion);
                v.print(result);

                break;
            case -1:
                v.print("Error: Expresión invalida");
        }
    }

    public void SetVar(String expresion) {
        Pattern pattern = Pattern.compile("[ ]+[A-z]+[ ]+", Pattern.CASE_INSENSITIVE);
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
        v.print("Variable: " + Nombre + " asignada con valor " + Valor);
    }

    public double getValue(String a){
        double value=0; 
        try {
            value=myVars.get(a); 
        } catch (Exception e) {
            v.print("Error: Variable no encontrada");
        }
        return value; 
    }
}
