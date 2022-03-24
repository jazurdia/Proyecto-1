package Clases;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Interprete {
    private HashMap<String, Double> myVars;
    Operaciones op = new Operaciones();
    SepararString sep = new SepararString();
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

            case 3: // (dos variables)

                // (setqu x 10)
                // (setqu y 5)
                // "(+ y x)" -> expresion
                String result2;
                String instrucciones_array[] = sep.separar(expresion); // {"+", "y", "x"}

                if (MapContainsVar(instrucciones_array[1]) && MapContainsVar(instrucciones_array[2])) {
                    for (int i = 1; i < instrucciones_array.length; i++) {
                        instrucciones_array[i] = instrucciones_array[i].replace(instrucciones_array[i],
                                getValue(instrucciones_array[i])); // modificando ambos elementos del array EN ORDEN de
                                                                   // aparición en el array.
                    }
                    // ya modifiqué mi array.

                    result2 = op.operar(instrucciones_array[0], instrucciones_array[1], instrucciones_array[2]);

                } else {
                    result2 = "Ocurrió un error";
                }

                v.print(result2);
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

    public String getValue(String a) {
        String value = String.valueOf(myVars.get(a));
        return value;
    }

    public boolean MapContainsVar(String a) {
        if (myVars.containsKey(a)) {
            return true;
        } else {
            return false;
        }

    }
}
