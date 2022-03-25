//package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Interprete {
    HashMap<String, Double> myVars = new HashMap<String, Double>();
    Operaciones op = new Operaciones();
    SepararString sep = new SepararString();
    Vista v = new Vista();

    public Interprete() {
    }

    
    /** 
     * @param expresion
     */
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
                String result2;
                String instrucciones_array[] = sep.separar(expresion); // {"+", "y", "x"}
                if (MapContainsVar(instrucciones_array[1]) == true && MapContainsVar(instrucciones_array[2]) == true) {
                    for (int i = 1; i < instrucciones_array.length; i++) {
                        instrucciones_array[i] = instrucciones_array[i].replace(instrucciones_array[i],
                                getValue(instrucciones_array[i])); // modificando ambos elementos del array EN ORDEN de
                                                                   // aparición en el array.
                    }
                    result2 = op.operar(instrucciones_array[0], instrucciones_array[1], instrucciones_array[2]);

                } else {
                    result2 = "Error: Variable no encontrada";
                }

                v.print(result2);
                break;

            case 4: // (+ num var)
                String result3;
                String instrucciones_array2[] = sep.separar(expresion);
                if (MapContainsVar(instrucciones_array2[2]) == true) {
                    instrucciones_array2[2] = instrucciones_array2[2].replace(instrucciones_array2[2],
                            getValue(instrucciones_array2[2]));
                    result3 = op.operar(instrucciones_array2[0], instrucciones_array2[1], instrucciones_array2[2]);
                } else {
                    result3 = "Error: variable no encontrada";
                }

                v.print(result3);
                break;

            case 5: // (+ var num)
                String result4;
                String instrucciones_array3[] = sep.separar(expresion);
                if (MapContainsVar(instrucciones_array3[1]) == true) {
                    instrucciones_array3[1] = instrucciones_array3[1].replace(instrucciones_array3[1],
                            getValue(instrucciones_array3[1]));
                    result4 = op.operar(instrucciones_array3[0], instrucciones_array3[1], instrucciones_array3[2]);
                } else {
                    result4 = "Error: variable no encontrada";
                }
                v.print(result4);
                break;

            case 6: // defun y var, num.

                // **** CONSTRUCCION DE DEFUN ****
                // quitamos los paréntesis.
                String new_expresion = expresion;
                new_expresion = new_expresion.replace("(", "");
                new_expresion = new_expresion.replace(")", "");
                new_expresion = new_expresion.replace("defun ", "");

                String expresion_array[] = new_expresion.split(" ");// {"sum", "a", "+", "a", "10"} "(defun sum (a) (+ a
                                                                    // 10)"
                String funName = expresion_array[0]; // "sum" [0]
                ArrayList<String> lista_var = new ArrayList<>();
                lista_var.add(expresion_array[1]); // "a" [1]
                ArrayList<String> instrucciones = new ArrayList<>();
                for (int i = 2; i < expresion_array.length; i++) { // "+", "a", "10"
                    instrucciones.add(expresion_array[i]);
                }

                // for (int n = 0; n < instrucciones.size(); n++) {
                // v.print(instrucciones.get(n).toString()); // instrucciones para:
                // defun.execute(... instrucciones)
                // }

                Defun def = new Defun(funName, lista_var, instrucciones);
                ArrayList<Double> valores = v.funcion(funName, 1);

                List<Object> instrucciones_raw = def.executeInstructions(valores); // {"+", "num", "num"}

                // si la variable está en la segunda mierda esa.

                String resultados4 = op.operar(String.valueOf(instrucciones_raw.get(0)),
                        String.valueOf(valores.get(0)), String.valueOf(instrucciones_raw.get(2)));
                v.print(resultados4);
                break;

            case 7: // defun y num, var.

                // **** CONSTRUCCION DE DEFUN ****
                // quitamos los paréntesis.
                String new_expresion0 = expresion;
                new_expresion0 = new_expresion0.replace("(", "");
                new_expresion0 = new_expresion0.replace(")", "");
                new_expresion0 = new_expresion0.replace("defun ", "");

                String expresion_array0[] = new_expresion0.split(" ");// {"sum", "a", "+", "a", "10"} "(defun sum (a) (+
                                                                      // a
                                                                      // 10)"
                String funName0 = expresion_array0[0]; // "sum" [0]
                ArrayList<String> lista_var0 = new ArrayList<>();
                lista_var0.add(expresion_array0[1]); // "a" [1]
                ArrayList<String> instrucciones0 = new ArrayList<>();
                for (int i = 2; i < expresion_array0.length; i++) { // "+", "a", "10"
                    instrucciones0.add(expresion_array0[i]);
                }

                // for (int n = 0; n < instrucciones.size(); n++) {
                // v.print(instrucciones.get(n).toString()); // instrucciones para:
                // defun.execute(... instrucciones)
                // }

                Defun def0 = new Defun(funName0, lista_var0, instrucciones0);
                ArrayList<Double> valores0 = v.funcion(funName0, 1);

                List<Object> instrucciones_raw0 = def0.executeInstructions(valores0); // {"+", "num", "num"}

                // si la variable está en la segunda mierda esa.

                String resultados40 = op.operar(String.valueOf(instrucciones_raw0.get(0)),
                        String.valueOf(instrucciones_raw0.get(1)), String.valueOf(valores0.get(0)));
                v.print(resultados40);
                break;

            case -1:
                v.print("Error: Expresión invalida");
                break;
        }

        v.print("Ingrese otra operación: ");
    }

    
    /** 
     * @param expresion
     */
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

    
    /** 
     * @param a
     * @return String
     */
    public String getValue(String a) {
        String value = String.valueOf(myVars.get(" " + a + " "));
        return value;
    }

    
    /** 
     * @param a
     * @return boolean
     */
    public boolean MapContainsVar(String a) {
        if (myVars.containsKey(" " + a + " ") == true) {
            return true;
        } else {
            return false;
        }

    }
}
