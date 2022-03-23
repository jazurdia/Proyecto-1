package Clases;

public class Operaciones {
    Aritmetica aritmetica = new Aritmetica();
    Predicados predicados = new Predicados();
    SepararString sep = new SepararString();
    public Operaciones(){}

    public String operar(String instrucciones){
        String ans = "";

        String instrucciones_array[] = sep.separar(instrucciones);
        String signo = instrucciones_array[0];
        if(signo == "+"|| signo == "-" || signo == "*" || signo == "/"){
            double temp = aritmetica.execute_aritmetica(instrucciones)


        }else ( signo == "=="|| signo == "<" || signo == ">"){

        }


        return ans;
    }

    
}
