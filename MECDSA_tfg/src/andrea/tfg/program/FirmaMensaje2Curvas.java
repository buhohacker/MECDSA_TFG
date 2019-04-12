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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/*
 * Fichero: FirmaMensaje2Curvas.java
 * Autor: Andrea del Nido García
 * Función: es la aplicación que permite realizar la firma y verificación de un mensaje.
 */

public class FirmaMensaje2Curvas {

    /*
    * Función: Firma el mensaje dado a partir de las claves.
    * Parámetros: mensaje msj, orden n, punto P, parámetro de la ec a, clave privada cp.
    * Salida: Un array BigInteger que contiene la firma (r,s).
    */
    public static BigInteger[] firmaMsj (String msj, BigInteger n1, BigInteger n2, BigInteger[] P1, BigInteger[] P2, BigInteger a1, BigInteger a2, BigInteger clavePrivada1, BigInteger clavePrivada2) throws NoSuchAlgorithmException {

		System.out.println("Firmando el mensaje..................");

		BigInteger k1, k2;
		BigInteger kInv1, kInv2;
		BigInteger r, r1, r2 = null;
		BigInteger e;
		BigInteger s1, s2;
		BigInteger[] rss1, rss2;
                BigInteger[] rss = new BigInteger[3];
                BigInteger comp1r;
                BigInteger comp2r;
                
                e = new BigInteger(SHAsum(msj.getBytes()), 16);         			// PASO 1. Calculamos e = H(msg) siendo H función Hass. 

		do {
                    do {
			do {
				//k = BigInteger.valueOf(1);				           	// PASO 2. Esta mal ya que k tiene que ser random.
				k1 = MetodosBigInt.randomMenorQueN(n1.subtract(BigInteger.valueOf(1)));
                                k2 = MetodosBigInt.randomMenorQueN(n2.subtract(BigInteger.valueOf(1)));
                                //System.out.println("Imprimimos k1: "+k1);
                                //System.out.println("Imprimimos n1: "+n1);
                                //System.out.println("Imprimimos k2: "+k2);
                                //System.out.println("Imprimimos n2: "+n2);
				rss1 = OperacionesCE.puntoPorEscalar(P1, a1, n1, k1);	   			// PASO 2.
                                rss2 = OperacionesCE.puntoPorEscalar(P2, a2, n2, k2);
				r1 = rss1[0].mod(n1);	
                                System.out.println("Esto en firma dos curvas y r2 antes es: " + r2);
                                r2 = rss2[0].mod(n2);                                                   // PASO 3.
                                System.out.println("Esto en firma dos curvas y r2 después es: " + r2);
			} while ((r1.compareTo(BigInteger.ZERO) == 0) || (r2.compareTo(BigInteger.ZERO) == 0));		   			// PASO 3. Si r != 0 --> volver a PASO 2.
                        
                        r = r1.add(r2);
                        comp1r = BigInteger.ZERO.mod(n1);
                        comp2r = BigInteger.ZERO.mod(n2);
                    } while ((r.compareTo(comp1r) == 0) || (r.compareTo(comp2r) == 0));
                    
			kInv1 = k1.modInverse(n1);
                        kInv2 = k2.modInverse(n2);
			s1 = (kInv1.multiply(e.add(clavePrivada1.multiply(r)))).mod(n1);    		// PASO 4.
                        s2 = (kInv2.multiply(e.add(clavePrivada2.multiply(r)))).mod(n2);
		} while ((s1.compareTo(BigInteger.ZERO) == 0) || (s2.compareTo(BigInteger.ZERO) == 0));						// PASO 4. Si s != 0 --> volver a PASO 2.
                        
                ///////////////////////////////////
                // Paso 2:
                
                
		rss[0] = r;								
		rss[1] = s1;
                rss[2] = s2;
		System.out.println("Mensaje firmado!! \n");

		return rss;
	}
	
    
	public static String SHAsum(byte[] convertme) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256"); 					//Utilizar SHA-2 que es más seguro.
	    return byteArray2Hex(md.digest(convertme));
	}

        
	@SuppressWarnings("resource")
	private static String byteArray2Hex(final byte[] hash) {
	    Formatter formato = new Formatter();
	    for (byte b : hash) {
	        formato.format("%02x", b);
	    }
	    return formato.toString();
	}
}
