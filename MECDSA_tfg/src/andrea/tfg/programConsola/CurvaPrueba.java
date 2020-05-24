/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.programConsola;

import java.math.BigInteger;

/**
 *
 * @author Andrea
 */
public class CurvaPrueba {
    
    private BigInteger p = BigInteger.valueOf(17);
    private BigInteger n = BigInteger.valueOf(15);
    private BigInteger a = BigInteger.valueOf(1);
    private BigInteger b = BigInteger.valueOf(0);
    private BigInteger[] Pxy;
    
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
}
