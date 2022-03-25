/**
 * Autor: Maria Ramirez (asignado)
 */

package Clases;

import java.util.LinkedHashMap;
import java.util.Stack;

public class Funciones {

    //private LinkedList<Integer> values = new LinkedList<>();
    private String name;
    private String instruc;
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
     */
    //Referencia: utilizada en ejercicio, perfil de usuario: https://github.com/malonso-uvg?tab=repositories
    public void doFuncion(){
        if(operations.contains("Cond")){
            for (int j = 5; j < operations.length() ; j++) {
                if(operations.charAt(j) == 'a' || operations.charAt(j) == 'b' || operations.charAt(j) == 'c' || operations.charAt(j) == 'd'
                        || operations.charAt(j) == 'e' || operations.charAt(j) == 'f'){
                    operations = operations.replace(Character.toString(operations.charAt(j)), values.removeLast().toString());
                }

            }
        }else {
            for (int j = 0; j < operations.length() ; j++) {
                if(operations.charAt(j) == 'a' || operations.charAt(j) == 'b' || operations.charAt(j) == 'c' || operations.charAt(j) == 'd'
                        || operations.charAt(j) == 'e' || operations.charAt(j) == 'f'){
                    operations = operations.replace(Character.toString(operations.charAt(j)), values.removeLast().toString());
                }

            }
        }

        operations.push(operations);
        if(operations.peek().contains("+") || operations.peek().contains("-") || operations.peek().contains("*") || operations.peek().contains("/")){
            new OperacionesAritmeticas(operations.pop());
        }else if(operations.peek().contains("Cond")){ 
            new Condicionales(operations.pop());
        }

        if(operations.size() > 0){
            realizarFuncion();
        }else{
            return;
        }
        
    }


    /**
     * 
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name){
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
