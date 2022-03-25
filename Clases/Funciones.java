/**
 * Autor: Maria Ramirez (asignado)
 */

package Clases;

import java.util.LinkedHashMap;
//import java.util.LinkedList;
import java.util.Stack;

public class Funciones {

    //private LinkedList<Integer> values = new LinkedList<>();
    private String name;
    private String isntruc;
    private String operations;
    private String parametros;


    /**
     * **
     * 
     * @param name
     * Nombre dada a la funcion
     * @param parametros
     * Parametros para la funcion
     * @param instruc
     * Intrucciones de que es lo que realizara la funcion
     * @param operations
     * Operaciones que se tienen que realizar
     */

    public void nuevaFuncion(String name, String parametros, String instruc, String operations){

        LinkedHashMap<String, String> parametrosFuncion = new LinkedHashMap<String, String>();
        this.name = name;
        this.parametros = parametros;
        this.instruc = instruc;
        System.out.println("Funcion creada con exito: ");
        System.out.println(name + parametros + instruc);

    }

    /**
     * @param values
     * La lista de los valores que se le agregaran a la funcion
     * 
     * Instancia
     */
    public void doFuncion(LinkedHashMap values){
        this.values = values;
        doFuncion();

    }

    /**
     * Metodo 
     * PENDIENTE
     */
    public void doFuncion(){
        
        //if()
    }


    /**
     * @param name
     */
    public void getName(String name){
        this.name = name;
    }

    /**
     * 
     * @return
     */
    public String getParametros(){
        return parametros;
    }

    /**
     * 
     * @param parametros
     */
    public void setParametros(String parametros){
        this.parametros = parametros;
    }

    /**
     * 
     * @return
     */
    public Stack<String> getOperations(){
        return operations;
    }

    /**
     * @param operations
     */
    public void setOperations(Stack<String> operations){
        this.operations = operations;
    }
}
