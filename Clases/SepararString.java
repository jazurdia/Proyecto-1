package Clases;

public class SepararString {
    public SepararString() {
    }

    /**
     * 
     * @param string string con paréntesis
     * @return devuelve un array con estructura [signo, numero, numero]
     */
    public String[] separar(String string) {

        string = string.replace("(", "");
        string = string.replace(")", "");
        String final_array[] = string.split(" ");

        return final_array;
    }

    /**
     * 
     * @param string "Double" en formato String.
     * @return convertido a double.
     */
    public double stringToDouble(String string) {
        double num = Double.parseDouble(string);
        return num;
    }
}
