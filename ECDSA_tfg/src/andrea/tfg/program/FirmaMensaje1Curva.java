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
 * Fichero: FirmaMensaje1Curva.java
 * Autor: Andrea del Nido García
 * Función: es la aplicación que permite realizar la firma y verificación de un mensaje.
 */

public class FirmaMensaje1Curva {

	/*
	 * Función: Firma el mensaje dado a partir de las claves-
	 * Parámetros: mensaje msj, orden n, punto P, parámetro de la ec a, clave privada cp.
	 * Salida: Un array BigInteger que contiene la firma (r,s).
	 */
	public static BigInteger[] firmaMsj (String msj, BigInteger n, BigInteger[] P, BigInteger a, BigInteger clavePrivada) throws NoSuchAlgorithmException {

		System.out.println("Firmando el mensaje..................");

		BigInteger k;
		BigInteger kInv;
		BigInteger r;
		BigInteger e;
		BigInteger s;
		BigInteger[] rs;

		do {
			do {
				//k = BigInteger.valueOf(1);				           	// PASO 2. Esta mal ya que k tiene que ser random.
				k = MetodosBigInt.randomMenorQueN(n.subtract(BigInteger.valueOf(1)));
				rs = OperacionesCE.puntoPorEscalar(P, a, n, k);	   			// PASO 2.
				r = rs[0].mod(n);							// PASO 3.
			} while (r.compareTo(BigInteger.ZERO) == 0);		   			// PASO 3. Si r != 0 --> volver a PASO 2.

			kInv = k.modInverse(n);
			e = new BigInteger(SHAsum(msj.getBytes()), 16);         			// PASO 1. Calculamos e = H(msg) siendo H función Hass. 
			s = (kInv.multiply(e.add(clavePrivada.multiply(r)))).mod(n);    		// PASO 4.
		} while (s.compareTo(BigInteger.ZERO) == 0);						// PASO 4. Si s != 0 --> volver a PASO 2.

		rs[0] = r;								
		rs[1] = s;
		System.out.println("Mensaje firmado!! \n");

		return rs;
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

