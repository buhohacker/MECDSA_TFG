/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.program;

/**
 *
 * @author Andrea
 */
import java.math.BigInteger;

/*
 * Fichero: GenerarClaves.java
 * Autor: Andrea del Nido García
 * Función: Esta clase se utilizará para generar la clave privada y la clave pública.
 */

public class GenerarClaves {
	
	public BigInteger clavePrivada;
	public BigInteger[] clavePublica;
	
	/*
	 * Función: Generamos las dos claves.
	 * Parámetros: El punto P, el orden n y el parámetro a de la ec.
	 * Salida: 
	 */
	public GenerarClaves(BigInteger[] p, BigInteger a, BigInteger n) {
		
		//System.out.println("Generando el par de claves...........");
		
		clavePrivada = MetodosBigInt.randomMenorQueN(n);
		clavePublica = OperacionesCE.puntoPorEscalar(p, a, n, clavePrivada);
		
		//System.out.println("Claves generdas!! \n");
	}
	
	//Getters par de claves.
	public BigInteger getClavePrivada() {
		return this.clavePrivada;
	}

	public BigInteger[] getClavePublica() {
		return this.clavePublica;
	}
}
