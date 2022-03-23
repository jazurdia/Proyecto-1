/**
 * Autor: Alejandro Azurdia (asignado)
 */

package Clases;
public class Predicados {

    public Predicados(){}

    /**
     * 
     * @param a Primer número a comparar
     * @param b Segundo número a comparar
     * @return boolean
     *//
    public boolean isEqual(double a, double b){
        boolean ans = false;
        if(a == b){
            ans = true;
        }
        return ans;
    
    }
    
    /**
     * 
     * @param a Primer número a comparar
     * @param b Segundo número a comparar
     * @return boolean
     *//
    public boolean isGreater(double a, double b){
        boolean ans = false;
        if(a < b){
            ans = true;
        }
        return ans;
    }

    /**
     * 
     * @param a Primer número a comparar
     * @param b Segundo número a comparar
     * @return boolean
     *//
    public boolean isLesser(double a, double b){
        boolean ans = false;
        if(a < b){
            ans = true;
        }
        return ans;
    }

}
