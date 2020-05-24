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
public class CurvaGenerica {
    
    private BigInteger p;
    private BigInteger n;
    private BigInteger a;
    private BigInteger b;
    private BigInteger x;
    private BigInteger y;
    
    public CurvaGenerica(BigInteger p, BigInteger n, BigInteger a, BigInteger b, BigInteger x, BigInteger y) {
        
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

    public BigInteger getxP() {
        return x;
    }

    public void setxP(BigInteger xP) {
        this.x = xP;
    }

    public BigInteger getyP() {
        return y;
    }

    public void setyP(BigInteger yP) {
        this.y = yP;
    }
}
