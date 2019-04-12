/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.program;

import java.math.BigInteger;

/**
 *
 * @author Andrea
 */
public class GenerarClavesMECDSA {
    
    public BigInteger clavePrivada1;
    public BigInteger clavePrivada2;
    public BigInteger[] clavePublica1;
    public BigInteger[] clavePublica2;
	
	/*
	 * Función: Generamos las dos claves.
	 * Parámetros: El punto P, el orden n y el parámetro a de la ec.
	 * Salida: 
	 */
	public GenerarClavesMECDSA (BigInteger[] p1, BigInteger[] p2, BigInteger a1, BigInteger a2,
                BigInteger n1, BigInteger n2) {
		
		//System.out.println("Generando el par de claves...........");
		
		clavePrivada1 = MetodosBigInt.randomMenorQueN(n1);
		clavePublica1 = OperacionesCE.puntoPorEscalar(p1, a1, n1, clavePrivada1);
                
                clavePrivada2 = MetodosBigInt.randomMenorQueN(n2);
		clavePublica2 = OperacionesCE.puntoPorEscalar(p2, a2, n2, clavePrivada2);
		
		//System.out.println("Claves generdas!! \n");
	}
	
	//Getters par de claves.
	public BigInteger getClavePrivada1() {
		return this.clavePrivada1;
	}
	public BigInteger[] getClavePublica1() {
		return this.clavePublica1;
	}
        public BigInteger getClavePrivada2() {
		return this.clavePrivada2;
	}
	public BigInteger[] getClavePublica2() {
		return this.clavePublica2;
	}
}
