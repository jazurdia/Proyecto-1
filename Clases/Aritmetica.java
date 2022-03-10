/**
 * Autor: Alejandro Azurdia (asignado)
 */

package Clases;

public class Aritmetica<T> {

    T numero_a;
    T numero_b;
    T operacion;

    public Aritmetica(T numero_a, T numero_b, T operacion) {
        this.numero_a = numero_a;
        this.numero_b = numero_b;
        this.operacion = operacion;
    }

    public T suma() {
        T ans = numero_a + numero_b;
        return ans;
    }

}
