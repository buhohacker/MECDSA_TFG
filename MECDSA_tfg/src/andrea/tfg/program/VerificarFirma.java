/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.program;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 *
 * @author Andrea
 */
public class VerificarFirma {
    
    public static boolean verificacion(String msj, BigInteger[] firma, BigInteger n1, BigInteger n2, 
            BigInteger a1,BigInteger a2, BigInteger[] P1, BigInteger[] P2, BigInteger[] cpub1, BigInteger[] cpub2) throws NoSuchAlgorithmException {
       
        Boolean verifica = false;
        BigInteger r = firma[0];
        BigInteger s1 = firma[1];
        BigInteger s2 = firma[2];
        
        //Paso 1: comprobar si r y si son enteros en [t, n1+n2+..nt-t] y [1,ni-1] --> t = 2.
        BigInteger rag1I = BigInteger.valueOf(2);
        BigInteger rag1D = n1.add(n2);
        BigInteger rag2I = BigInteger.ONE;
        BigInteger rag2D1 = n1.subtract(BigInteger.ONE);
        BigInteger rag2D2 = n2.subtract(BigInteger.ONE);
        
        // Este if comprueba si r y si están fuera del rango --> no se verifica la firma.
        if ((r.compareTo(rag1I) >= 0 && r.compareTo(rag1D) <= 0) 
                && (s1.compareTo(rag2I) >= 0 && s1.compareTo(rag2D1) <= 0) 
                && (s2.compareTo(rag2I) >= 0 && s2.compareTo(rag2D2) <= 0)) {
            System.out.println("SE VERIFICA LA FIRMA.\n");
            verifica = true;
        }
        
        // Paso 2: Calcular e = H(m) con la misma función hash con la que se firmó.
        BigInteger e = new BigInteger(FirmaMensaje2Curvas.SHAsum(msj.getBytes()), 16);
        
        // Paso 3: Calcular wi = si^-1(mod ni) donde i = 1,2,...,t
        BigInteger w1 = s1.modInverse(n1);
        BigInteger w2 = s2.modInverse(n2);
        
        // Paso 4: Calcular ui = e*wi(mod ni), vi = r*wi(mod ni) donde i = 1,2,...,t
        BigInteger u1 = e.multiply(w1).mod(n1);
        BigInteger u2 = e.multiply(w2).mod(n2);
        BigInteger v1 = r.multiply(w1).mod(n1);
        BigInteger v2 = r.multiply(w2).mod(n2);
        System.out.println("Aqui??");
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
        // Paso 5:
        BigInteger[] auxP1 = OperacionesCE.puntoPorEscalar(P1, a1, n1, u1);
        BigInteger[] auxQ1 = OperacionesCE.puntoPorEscalar(cpub1, a1, n1, v1);
        BigInteger[] R1 = OperacionesCE.sumaPuntos(auxP1, auxQ1, n1);
        
        BigInteger[] auxP2 = OperacionesCE.puntoPorEscalar(P2, a2, n2, u2);
        BigInteger[] auxQ2 = OperacionesCE.puntoPorEscalar(cpub2, a2, n2, v2);
        BigInteger[] R2 = OperacionesCE.sumaPuntos(auxP2, auxQ2, n2);
        
        // Paso 6:
        BigInteger rPrima1 = R1[0].mod(n1);
        BigInteger rPrima2 = R2[0].mod(n2);
        BigInteger sumaRPrima = rPrima1.add(rPrima2);
        System.out.println(rPrima1);
        System.out.println(rPrima2);
        System.out.println(sumaRPrima);
        System.out.println(r);
        
        if (r.compareTo(sumaRPrima) < 0) {
            System.out.println("r es menor que la suma.");
        } else {
            System.out.println("r es mayor que la suma.");
        }
        
        // Comprobamos si r es igual a rPrima1 y a rPrima2, si lo son --> se verifica.
        if (r.compareTo(sumaRPrima) == 0) {
            System.out.println("SE VERIFICA LA FIRMA.");
            verifica = true;
        }   else {
            System.out.println("NO SE VERIFICA LA FIRMA.");
            verifica = false;
        }
        
        //System.out.println("SALTA TODOS LOS IF");
        return verifica;
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
