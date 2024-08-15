package ar.edu.unju.fi.poo2024;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("HOLA MUNDO");
		Scanner teclado = new Scanner (System.in);
		System.out.println("Ingrese un numero: ");
		//int numero = teclado.nextInt();  //lee la entrada y lo convierte en entero nextInt
		String cadena = teclado.next();
		//System.out.println("El numero ingresado es: " + numero);
		System.out.println("La cadena  ingresada es: " + cadena);
		System.out.println("La longitud de la cadena es: " + cadena.length());
		System.out.println("el valor en la posicion 2 es: " + cadena.charAt(2));
		System.out.println("el valor en mayusculas es: " + cadena.toUpperCase()); // muestra la cadena en mayusculas
		System.out.println("La subcadena de 0 a n es: " + cadena.substring(0, cadena.length()));
		
	
		int numSubcadenasEspeciales = contarSubcadenasEspeciales(cadena);
        System.out.println("El número de subcadenas especiales es: " + numSubcadenasEspeciales);

        teclado.close(); // Sin esto, habrá una advertencia de no cerrar el Scanner
    }

    public static int contarSubcadenasEspeciales(String cadenaEspecial) {
        int num = cadenaEspecial.length();
        int count = 0;
        
        for (int longitud = 1; longitud <= num; longitud++) {
            for (int i = 0; i <= num - longitud; i++) {
                String subcadena = cadenaEspecial.substring(i, i + longitud);
                if (esSubcadenaEspecial(subcadena)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static boolean esSubcadenaEspecial(String subCadenaE) {
        int numE = subCadenaE.length();
        if (numE == 1) {
            return true;
        }
        
        boolean todosIguales = true;
        char primerCaracter = subCadenaE.charAt(0);
        for (int i = 1; i < numE; i++) {
            if (subCadenaE.charAt(i) != primerCaracter) {
                todosIguales = false;
                break;
            }
        }
        if (todosIguales) {
            return true;
        }
        
        if (numE % 2 == 1) {
            int medio = numE / 2;
            boolean todosIgualesMenosMedio = true;
            char primerLado = subCadenaE.charAt(0);
            for (int i = 0; i < numE; i++) {
                if (i != medio && subCadenaE.charAt(i) != primerLado) {
                    todosIgualesMenosMedio = false;
                    break;
                }
            }
            if (todosIgualesMenosMedio) {
                return true;
            }
        }
        
        return false;
	}

}
