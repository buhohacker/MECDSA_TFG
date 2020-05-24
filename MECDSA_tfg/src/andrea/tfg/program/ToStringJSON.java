/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.program;

/*
 * Fichero: toStringJSON.java
 * Autor: Andrea del Nido García
 * Función: esta clase se utilizará para convertir distintos tipos a JSON con String.
 */

import java.math.BigInteger;

/**
 *
 * @author Andrea
 */
public class ToStringJSON {
    
    /*Método que se utilizará para pasr de un array de BigInteger a un JSON con formato String para poder visualizarlo por consola. */
	public static String arrayToJSON(BigInteger[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < array.length; i++) {
			sb.append(String.valueOf(array[i]));
			if (i < array.length-1) {
				sb.append(", \n");
			}			
		}
		sb.append(")");
			return sb.toString();
	}
        
        // Método para imprimir un punto de la curva.
        public static String imprimirPunto(BigInteger[] p) {
		return "("+ p[0].toString() +","+p[1].toString()+")";
	}
        
        
}
