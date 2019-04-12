/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class CurvaSM2 {
    
    // El tamaño de los parámetros es de 64 bits --> 8 digs * 8 bloques.
    private BigInteger p;
    private BigInteger n;
    //private BigInteger seed;   	//// Para generar de forma aleatoria curvas.
    private BigInteger a;	//// Esta curva se define como y^2 = x^3-3*x+b(modp) por eso a=-3.
    //private BigInteger c;			//// No tenemos el parámetro c porque estamos en cuerpos primos, ec. general --> y^2 = x^3+a*x+b
    private BigInteger b;
    private BigInteger[] Pxy;
    private BigInteger xP;
    private BigInteger yP;

    /* Constructor de la curva elíptica P-256 que pregunta si queire que se pongan manualmente o no y se definen en sus campos. */
    public CurvaSM2() {

        System.out.println("Creando la curva elíptica SM2..........");

        try {

            File f = new File("C:\\Users\\Andrea\\Documents\\NetBeansProjects\\ECDSA_tfg\\src\\andrea\\tfg\\resources\\SM2.txt");
            try (Scanner sAutomatico = new Scanner(f)) {
                p = new BigInteger(sAutomatico.nextLine(), 16);
                n = new BigInteger(sAutomatico.nextLine(), 16);
                a = new BigInteger(sAutomatico.nextLine(), 16);
                //seed = new BigInteger(sAutomatico.nextline(),16);
                //c = new BigInteger(sAutomatico.nextLine(),16);		
                b = new BigInteger(sAutomatico.nextLine(), 16);
                xP = new BigInteger(sAutomatico.nextLine(), 16);		//// Se puede poner en decimal ver https://safecurves.cr.yp.to/base.html
                yP = new BigInteger(sAutomatico.nextLine(), 16);

                Pxy = new BigInteger[2];
                Pxy[0] = xP;
                Pxy[1] = yP;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
        }
        System.out.println("Curva elíptica SM2 creada!!\n");

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
