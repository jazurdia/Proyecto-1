package Clases;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ScannerSintax {
    public static int getExpresion(String expresion) {
        if (evaluate("^[(][ ]*setq[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",expresion)) //This is a simple assignment using setq
			return 1;
		else if (evaluate("^[(][ ]*[+][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) //This is a simple add operation of 2 operands
			return 2;
		else 
			return -1; 
    }

    private static boolean evaluate(String regex, String expresion) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(expresion);
	    return matcher.find();
	}
}
