/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.programConsola;

/* 
 * Fichero: CurvasElipticas.java
 * Autor: Andrea del Nido García
 * Función: Esta clase se utilizará para guardar todos los datos de las curvas elípticas que se pasan por ficheros
 *          las curvas que se implementarás por ahora son: P-256, SM2, secp256r1 y secp256k1.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class CurvaP256Consola {

    private BigInteger p;
    private BigInteger n;
    //private BigInteger seed;   	//// Para generar de forma aleatoria curvas.
    private BigInteger a = BigInteger.valueOf(-3);	//// Esta curva se define como y^2 = x^3-3*x+b(modp) por eso a=-3.
    //private BigInteger c;			//// No tenemos el parámetro c porque estamos en cuerpos primos, ec. general --> y^2 = x^3+a*x+b
    private BigInteger b;
    private BigInteger[] Pxy;
    private BigInteger xP;
    private BigInteger yP;

    /* Constructor de la curva elíptica P-256 que pregunta si queire que se pongan manualmente o no y se definen en sus campos. */
    public CurvaP256Consola() {

        System.out.println("Si desea introducir los parámetros manualmente escriba Si, si quiere por defecto escriba No. \n");

        Scanner sConsulta = new Scanner(System.in);
        String consulta = sConsulta.nextLine();
        System.out.println();

        if (consulta.equals("Si")) {

            System.out.println("Introduzca el valor del parámetro p.");
            Scanner sParametros = new Scanner(System.in);
            p = new BigInteger(sParametros.nextLine());

            System.out.println("Itroduzca el valor del parámetro n.");
            sParametros = new Scanner(System.in);
            n = new BigInteger(sParametros.nextLine());

            System.out.println("Introduzca el valor del prámetro b que no sea hexadecimal");
            sParametros = new Scanner(System.in);
            b = new BigInteger(sParametros.nextLine());

            System.out.println("Introduzca el valor de la coordenada x del punto P o punto base que no sea hexadecimal.");
            sParametros = new Scanner(System.in);
            xP = new BigInteger(sParametros.nextLine());

            System.out.println("Introduzca el valor de la coordenada y del punto P o punto base que no sea hexadecimal.");
            sParametros = new Scanner(System.in);
            yP = new BigInteger(sParametros.nextLine());

            Pxy = new BigInteger[2];
            Pxy[0] = xP;
            Pxy[1] = yP;

            System.out.println();

            sParametros.close();

        } else if (consulta.equals("No")) {
            System.out.println("Creando la curva elíptica........ \n");
            try {

                File f = new File("C:\\Users\\Andrea\\Documents\\NetBeansProjects\\ECDSA_tfg\\src\\andrea\\tfg\\resources\\P256.txt");
                Scanner sAutomatico = new Scanner(f);

                p = new BigInteger(sAutomatico.nextLine());
                n = new BigInteger(sAutomatico.nextLine());
				//seed = new BigInteger(sAutomatico.nextline(),16);
                //c = new BigInteger(sAutomatico.nextLine(),16);		
                b = new BigInteger(sAutomatico.nextLine(), 16);
                xP = new BigInteger(sAutomatico.nextLine(), 16);		//// Se puede poner en decimal ver https://safecurves.cr.yp.to/base.html
                yP = new BigInteger(sAutomatico.nextLine(), 16);

                Pxy = new BigInteger[2];
                Pxy[0] = xP;
                Pxy[1] = yP;

                sAutomatico.close();

            } catch (FileNotFoundException e) {
                System.out.println("Fichero no encontrado.");
            }
            System.out.println("Curva elíptica creada!!\n");

        } else {
            System.out.println("Error al introducir respuesta.");

            // Apaño para que el print del main no pete.
            Pxy = new BigInteger[2];
            Pxy[0] = null;
            Pxy[1] = null;
        }
        sConsulta.close();
    }

    /* Getters y setters de los parámetros de la curva. */
    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getA() {
        return a;
    }

    public void setA(BigInteger a) {
        this.a = a;
    }

    public BigInteger getB() {
        return b;
    }

    public void setB(BigInteger b) {
        this.b = b;
    }

    public BigInteger[] getPxy() {
        return Pxy;
    }

    public void setPxy(BigInteger[] p) {
        Pxy = p;
    }

    public BigInteger getxP() {
        return xP;
    }

    public void setxP(BigInteger xP) {
        this.xP = xP;
    }

    public BigInteger getyP() {
        return yP;
    }

    public void setyP(BigInteger yP) {
        this.yP = yP;
    }
}
