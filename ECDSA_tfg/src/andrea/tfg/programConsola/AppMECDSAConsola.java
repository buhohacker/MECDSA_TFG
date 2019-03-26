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
import andrea.tfg.program.CurvaP256;
import andrea.tfg.program.FirmaMensaje1Curva;
import andrea.tfg.program.GenerarClaves;
import andrea.tfg.program.OperacionesParamCurvas;
import andrea.tfg.program.ToStringJSON;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import java.math.BigInteger;
import static java.math.BigInteger.ZERO;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECPoint;
import static org.bouncycastle.math.raw.Mod.random;

/**
 *
 * @author Andrea
 */
public class AppMECDSAConsola extends ToStringJSON {

    static double start_time = System.currentTimeMillis();
    static double time_elapsed;
    static int np;

    public static void main(String[] args, byte[] random) throws NoSuchAlgorithmException, FileNotFoundException {

        //Curva_P_256 ec = new Curva_P_256();
        //System.out.println("Imprimimos el punto base de la curva P_256. \n" + arrayToJSON(ec.getPxy()));
        CurvaP256 ec1 = new CurvaP256();

        BigInteger nn = ec1.getN();
        BigInteger a = ec1.getA();
        BigInteger[] P = ec1.getPxy();

        GenerarClaves kp = new GenerarClaves(P, a, nn);

        //Scanner s = new Scanner(System.in);
        //Scanner kkk = new Scanner(System.in);
        //System.out.println("Enter your message on one line:");
        //String msg = s.nextLine();
        String msg = "Esto es una kk";

        System.out.println();

        BigInteger[] signature = FirmaMensaje1Curva.firmaMsj(msg, nn, P, a, kp.getClavePrivada());

        System.out.println("Firma: " + ToStringJSON.arrayToJSON(signature) + '\n');

		//System.out.println("No funciona la verificacion aun!!!");
        //MessageSV.messageVerify(msg, signature, n, G, a, kp.getPublicKey());
        /// Diria que aquí no se puede probar, nice!!
        // System.out.println("A partir de aqui prueba con curvas y sus parámetros");
        //CurvaP256Param cccc = new CurvaP256Param();
        //System.out.println("Imprimimos parametro a de la curva P_256. \n" + cccc.getA().toString());
        // Con esto generamos números grandes de 64 bits mínimo.
        /*
         Random r = new Random();
         BigInteger xx = new BigInteger(256, r);
         System.out.println(xx);
         */
        //BigInteger[] lixta = MetodosBigInt.listaNumeros256b();
        //System.out.println("Generamos números de 256 bits: \n" + ToStringJSON.arrayToJSON(lixta) + '\n');
        System.out.println(".....................");

        //BigInteger[] primos = MetodosBigInt.listaPrimos256b(lixta);
        // System.out.println("Obtenemos los que son primos: \n"+ToStringJSON.arrayToJSON(primos)+'\n');
        /*
         MetodosBigInt.escribePrimosMersenne();
         time_elapsed = System.currentTimeMillis() - start_time;
         System.out.println("");
         System.out.println(np + " primos de Mersenne por el método de " + "Lucas-Lehmer");
                
         System.out.println("Tiempo: " + time_elapsed / 1000 + " seg");
        
         */
        //BigInteger[] pppp = obtPtoBase(BigInteger.valueOf(17), BigInteger.valueOf(10), BigInteger.valueOf(2));
        //System.out.println(ToStringJSON.imprimirPunto(pppp));
        
        /*
        BigInteger p;
        BigInteger nn;
        BigInteger bb;
        BigInteger aa = BigInteger.valueOf(-3);
        File f = new File("C:\\Users\\Andrea\\Documents\\NetBeansProjects\\ECDSA_tfg\\src\\andrea\\tfg\\resources\\P256.txt");
        try (Scanner sAutomatico = new Scanner(f)) {
            p = new BigInteger(sAutomatico.nextLine());
            nn = new BigInteger(sAutomatico.nextLine());
            bb = new BigInteger(sAutomatico.nextLine(), 16);
            BigInteger[] kk = OperacionesParamCurvas.pruebaPtoBase(p, nn, aa, bb);
            System.out.println("Prueba pto base otra vez: " + ToStringJSON.imprimirPunto(kk));
        }
        */
                
          
        CurvaPrueba pruebaa = new CurvaPrueba();
        BigInteger[] puntico = OperacionesParamCurvas.pruebaPtoBase(pruebaa.getP(), pruebaa.getN(), pruebaa.getA(), pruebaa.getB());
        
        System.out.println("Puntico: " + ToStringJSON.imprimirPunto(puntico));
                     
                     
        
        //CurvaPrueba pruebaaa = new CurvaPrueba();
        //System.out.println("KKKKK: " + ToStringJSON.arrayToJSON(OperacionesParamCurvas.obtenerPtosCurva(pruebaaa.getP(), pruebaaa.getA(), pruebaaa.getB())));
        
        X9ECParameters x9 = NISTNamedCurves.getByName("P-224");
        // or whatever curve you want to use ECPoint
        ECPoint g = x9.getG(); 
        BigInteger n = x9.getN(); 
        int nBitLength = n.bitLength(); 
        BigInteger x; 
        do {
            x = new BigInteger(nBitLength, random); 
        } while (x.equals(ZERO) || (x.compareTo(n) >= 0)); 
        ECPoint randomPoint = g.multiply(x); 
        
        System.out.println("Punto g de la curva NIST");
    }
    
}
