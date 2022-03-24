package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerSintax {
	public static int getExpresion(String expresion) {
		if (evaluate("^[(][ ]*setq[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$", expresion)) // This is a simple assignment using setq
			return 1;
		else if (evaluate("^[(]{1}[+\\-*/]{1} [0-9.]+ [0-9.]+[)]{1}$", expresion)) // This is a simple add operation of
																					// 2 operands
			return 2;
		else if (evaluate("^[(]{1}[<>]{1}[=]{0,1} [0-9.]+ [0-9.]+[)]{1}$", expresion))
			return 2; // Mora te mamaste.
		else if (evaluate("^[(]{1}[+\\-*/]{1} [A-z]+ [A-z]+[)]{1}$", expresion))
			return 4;
		else if (evaluate("^[(]{1}[<>]{1}[=]{0,1} [A-z]+ [A-z]+[)]{1}$", expresion))
			return 5;
		else if (evaluate("^[(]{1}[=]{2} [A-z]+ [A-z]+[)]{1}$", expresion))
			return 6;
		else if (evaluate("^[(]{1}[=]{2} [0-9.]+ [0-9.]+[)]{1}$", expresion))
			return 7;
		else
			return -1;
	}

	private static boolean evaluate(String regex, String expresion) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(expresion);
		return matcher.find();
	}
}
