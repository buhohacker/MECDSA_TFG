/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.program;

import static andrea.tfg.program.FirmaMensaje2Curvas.SHAsum;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 *
 * @author Andrea
 */
public class PruebaFirma {
    
    public static BigInteger[] firmar(String msj, BigInteger n1, BigInteger n2) throws NoSuchAlgorithmException {
        BigInteger r;
        BigInteger s1;
        BigInteger s2;
        BigInteger[] firma = null;
        BigInteger[] rs1;
        BigInteger[] rs2;
        
        BigInteger e = new BigInteger(SHAsum(msj.getBytes()), 16); 
        
        BigInteger k1 = MetodosBigInt.randomMenorQueN(n1.subtract(BigInteger.ONE));
        BigInteger k2 = MetodosBigInt.randomMenorQueN(n2.subtract(BigInteger.ONE));
        
        
        return firma;
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