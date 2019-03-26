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

public class GenerarCurvasInputParam {
    
    /* TODO: Ver cómo optimizar estas funciones. IDEA: Ver si se puede hacer por casos, con switch o algo así. */
    
    // Método que crea una curva P256 cambiando los parámetros a, b, p y P por los que introduce el usuario.
    public CurvaP256 generarCurvaParamP256(String a, String b, String p) {
        CurvaP256 c = new CurvaP256(); 
        BigInteger aa = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger pp = new BigInteger(p);
        //BigInteger[] ptoBase = OperacionesParamCurvas.pruebaPtoBase(pp, c.getN(), aa, bb);
        c.setA(aa);
        c.setB(bb);
        c.setP(pp);  
        //c.setPxy(ptoBase);
        return c;
    }
    
    // Método que crea una curva SM2 cambiando los parámetros a, b, p y P por los que introduce el usuario.
    public CurvaSM2 generarCurvaParamSM2(String a, String b, String p) {
        CurvaSM2 c = new CurvaSM2(); 
        BigInteger aa = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger pp = new BigInteger(p);
        //BigInteger[] ptoBase = OperacionesParamCurvas.calcularPuntoBase(pp, aa, bb, c.getN());
        c.setA(aa);
        c.setB(bb);
        c.setP(pp);  
        //c.setPxy(ptoBase);
        return c;
    }
    
    // Método que crea una curva Secp256r1 cambiando los parámetros a, b, p y P por los que introduce el usuario.
    public CurvaSecp256r1 generarCurvaParamSecp256r1(String a, String b, String p) {
        CurvaSecp256r1 c = new CurvaSecp256r1(); 
        BigInteger aa = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger pp = new BigInteger(p);
        //BigInteger[] ptoBase = OperacionesParamCurvas.calcularPuntoBase(pp, aa, bb, c.getN());
        c.setA(aa);
        c.setB(bb);
        c.setP(pp);  
        //c.setPxy(ptoBase);
        return c;
    }
    
    // Método que crea una curva Secp256k1 cambiando los parámetros a, b, p y P por los que introduce el usuario.
    public CurvaSecp256k1 generarCurvaParamSecp256k1(String a, String b, String p) {
        CurvaSecp256k1 c = new CurvaSecp256k1(); 
        BigInteger aa = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger pp = new BigInteger(p);
        //BigInteger[] ptoBase = OperacionesParamCurvas.calcularPuntoBase(pp, aa, bb, c.getN());
        c.setA(aa);
        c.setB(bb);
        c.setP(pp);  
        //c.setPxy(ptoBase);
        return c;
    }
}
