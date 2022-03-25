package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerSintax {

	/**
	 * Obtiene la expresión que el usuario ingresa. Utiliza regex comparando
	 * caracter por caracter
	 * 
	 * @param expresion - Expresion que el usuario ingresa
	 * @return int - número de tipo de expresion
	 */
	public static int getExpresion(String expresion) {
		if (evaluate("^[(][ ]*setq[ ]+[A-z]+[ ]+[0-9.]+[ ]*[)]$", expresion)) // Asignación de variables SETQ
			return 1;
		else if (evaluate("^[(]{1}[+\\-*/]{1} [0-9.]+ [0-9.]+[)]{1}$", expresion)) // Operaciónes aritmeticas +-*/
																					// numeros
			return 2;
		else if (evaluate("^[(]{1}[<>]{1}[=]{0,1} [0-9.]+ [0-9.]+[)]{1}$", expresion)) // Comparacion <, >, <=, >= con
																						// numeros
			return 2;
		else if (evaluate("^[(]{1}[=]{2} [0-9.]+ [0-9.]+[)]{1}$", expresion)) // Comparacion == con numeros
			return 2;
		else if (evaluate("^[(]{1}[+\\-*/]{1} [A-z]+ [A-z]+[)]{1}$", expresion)) // Operaciónes aritmeticas +-*/
																					// Variables
			return 3;
		else if (evaluate("^[(]{1}[<>]{1}[=]{0,1} [A-z]+ [A-z]+[)]{1}$", expresion)) // Comparacion <, >, <=, >= con 2
																						// variables
			return 3;
		else if (evaluate("^[(]{1}[=]{2} [A-z]+ [A-z]+[)]{1}$", expresion)) // Comparacion == con 2 variables
			return 3;
		else if (evaluate("^[(]{1}[=]{2} [0-9.]+ [A-z]+[)]{1}$", expresion)) // Comparacion == con (Numero, Var)
			return 4;
		else if (evaluate("^[(]{1}[<>]{1}[=]{0,1} [0-9.]+ [A-z]+[)]{1}$", expresion)) // Comparacion <, >, <=, >= con
																						// (Numero, Var)
			return 4;
		else if (evaluate("^[(]{1}[+\\-*/]{1} [0-9.]+ [A-z]+[)]{1}$", expresion)) // Operaciónes aritmeticas +-*/
																					// (Numero, Var)
			return 4;
		else if (evaluate("^[(]{1}[=]{2} [A-z]+ [0-9.]+[)]{1}$", expresion)) // Comparacion == con 2 (Var, Numero)
			return 5;
		else if (evaluate("^[(]{1}[+\\-*/]{1} [A-z]+ [0-9.]+[)]{1}$", expresion)) // Operaciónes aritmeticas +-*/ (Var,
																					// Numero)
			return 5;
		else if (evaluate("^[(]{1}[<>]{1}[=]{0,1} [A-z]+ [0-9.]+[)]{1}$", expresion)) // Comparacion <, >, <=, >= con
																						// (Var, Numero)
			return 5;
		else if (evaluate(
				"[(]{1}[d]{1}[e]{1}[f]{1}[u]{1}[n]{1} [A-z]{1,20} [(][A-z]{1}[)] [(][+\\-*/<>]{0,1}[=]{0,2} [A-z]{1} [0-9.]+[)][)]$",
				expresion))
			return 6;
		else if (evaluate(
				"[(]{1}[d]{1}[e]{1}[f]{1}[u]{1}[n]{1} [A-z]{1,20} [(][A-z]{1}[)] [(][+\\-*/<>]{0,1}[=]{0,2} [0-9.]+ [A-z]+[)][)]$",
				expresion))
			return 6;
		else
			return -1;
	}

	/**
	 * Evalua la expresion ingresada por el usuario con una expresión regex
	 * 
	 * @param regex     - Expresión en regex
	 * @param expresion - Expresión del usuario
	 * @return boolean - Expresiones iguales o no
	 */
	private static boolean evaluate(String regex, String expresion) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(expresion);
		return matcher.find();
	}
}
