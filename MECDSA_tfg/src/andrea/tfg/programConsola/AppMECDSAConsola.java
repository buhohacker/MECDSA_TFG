/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.programConsola;

/*
 * Fichero: AppMECDSA.java
 * Autor: Andrea del Nido García
 * Función: es la aplicación que permite realizar la firma y verificación de un mensaje.
 */
import andrea.tfg.program.CurvaGenerica;
import andrea.tfg.program.CurvaP256;
import andrea.tfg.program.FirmaMensaje1Curva;
import andrea.tfg.program.FirmaMensaje2Curvas;
import andrea.tfg.program.GenerarClaves;
import andrea.tfg.program.GenerarClavesMECDSA;
import andrea.tfg.program.OperacionesParamCurvas;
import andrea.tfg.program.OperacionesString;
import andrea.tfg.program.VerificarFirma;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import static java.math.BigInteger.ZERO;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECPoint;

/**
 *
 * @author Andrea
 */
public class AppMECDSAConsola {

    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
      
        Boolean ver;
        
        do {
        
            /*
        BigInteger n = BigInteger.valueOf(13);
	BigInteger a = BigInteger.valueOf(5);
        BigInteger b = BigInteger.valueOf(-1);
        BigInteger p = BigInteger.valueOf(11);
	BigInteger x = BigInteger.valueOf(6);
        BigInteger y = BigInteger.valueOf(5);
        
        BigInteger n2 = BigInteger.valueOf(13);
	BigInteger a2 = BigInteger.valueOf(5);
        BigInteger b2 = BigInteger.valueOf(-1);
        BigInteger p2 = BigInteger.valueOf(11);
	BigInteger x2 = BigInteger.valueOf(6);
        BigInteger y2 = BigInteger.valueOf(5);
        
        BigInteger[] G = new BigInteger[2];
        BigInteger[] G2 = new BigInteger[2];
        
        G[0] = x;
        G[1] = y;
        G2[0] = x2;
        G2[1] = y2;
        */
        //CurvaGenerica cPruebaVer = new CurvaGenerica(p,n,a,b,x,y);
        //CurvaGenerica cPruebaVer2 = new CurvaGenerica(p2,n2,a2,b2,x2,y2);
        
        CurvaP256 c1 = new CurvaP256();
        c1.setA(BigInteger.valueOf(5)); c1.setB(BigInteger.valueOf(-1)); c1.setN(BigInteger.valueOf(13));
        c1.setP(BigInteger.valueOf(11)); c1.setxP(BigInteger.valueOf(6)); c1.setyP(BigInteger.valueOf(5));
        BigInteger[] P1 = new BigInteger[2];
        P1[0] = c1.getxP(); P1[1] = c1.getyP(); c1.setPxy(P1);
        
        CurvaP256 c2 = new CurvaP256();
        c2.setA(BigInteger.valueOf(5)); c2.setB(BigInteger.valueOf(-1)); c2.setN(BigInteger.valueOf(13));
        c2.setP(BigInteger.valueOf(11)); c2.setxP(BigInteger.valueOf(6)); c2.setyP(BigInteger.valueOf(5));
        BigInteger[] P2 = new BigInteger[2];
        P2[0] = c2.getxP(); P2[1] = c2.getyP(); c2.setPxy(P2);
        
	//GenerarClaves kp = new GenerarClaves(c1.getPxy(),c1.getA(), c1.getN());
        //GenerarClaves kp2 = new GenerarClaves(c2.getPxy(),c2.getA(), c2.getN());
        
        GenerarClavesMECDSA cls = new GenerarClavesMECDSA(c1.getPxy(), c2.getPxy(), c1.getA(), c2.getA(),
                c1.getN(), c2.getN());
        
	//Scanner s = new Scanner(System.in);
	//System.out.println("Enter your message on one line:");
	String msg = "Esto es una prueba para la verificacion de firma.";
        System.out.println(msg);
	System.out.println();
        
        //System.out.println("a:"+a+" b: "+b+" G: "+OperacionesString.imprimirPunto(G)+" n: "+n+" p: "+p);
        //System.out.println("a2:"+a2+" b2: "+b2+" G2: "+OperacionesString.imprimirPunto(G2)+" n2: "+n2+" p2: "+p2);
        //System.out.println("clavePriv1: "+kp.clavePrivada+" clavepriv2: "+kp2.clavePrivada);
        
	BigInteger[] signature = FirmaMensaje2Curvas.firmaMsj(msg, c1.getN(), c2.getN(), c1.getPxy(), c2.getPxy(),
                c1.getA(),c2.getA(), cls.getClavePrivada1(), cls.getClavePrivada2());
		
	System.out.println("Firma: " + OperacionesString.arrayToJSON(signature) + '\n');
        
        
        System.out.println("Comenzamos la verificación de la firma.");
        System.out.println();
        
        ver = VerificarFirma.verificacion(msg, signature, c1.getN(), c2.getN(), c1.getA(), c2.getA(), c1.getPxy(),
                c2.getPxy(), cls.getClavePublica1(), cls.getClavePublica2());
        System.out.println(ver);
        
        }while (ver == false);
    } 
    
}
