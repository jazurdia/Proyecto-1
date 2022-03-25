//Obtenido de: https://github.com/psao/UVG-CC2003-P1-Interprete-LISP/blob/master/InterpreteLisp/src/Defun.java

package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Defun2 {

    private String nombre_funcion; // String como nombre de nuestra función.
    private HashMap<String, Object> variables;
    private List lista_instrucciones;

    public Defun2(String nombre_funcion, Object vars, Object instrucciones) {

        List<String> variables = new ArrayList<>();
        variables.add(vars.toString());
        List lista_instrucciones = (List) instrucciones;

        this.nombre_funcion = nombre_funcion;
        for (String item : variables) {
            this.variables.put(item, null);
        }

        this.lista_instrucciones = lista_instrucciones; // hola :=)

    }

    public String getFunName() {
        return this.nombre_funcion;
    }

}
