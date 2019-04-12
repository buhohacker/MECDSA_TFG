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

/*
 * Fichero: OperacionesCE.java
 * Autor: Andrea del Nido García
 * Función: Esta clase se utilizará para crear métodos con las operaciones de las curvas elípticas en cuerpos primos.
 */

public class OperacionesCE {

	/*
	 * Función: Negación, función que devulve la negación de un punto de la CE.
	 * Parámetros: Punto p de la curva.
	 * Salida: Punto -p de la curva.
	 */	
	public static BigInteger[] negacionPunto(BigInteger[] p) {
		
		BigInteger[] pInv = new BigInteger[2];
		
		//Tener en cuenta que -P = (x, -y) siendo P = (x, y),
		pInv[0] = p[0];
		pInv[1] = p[1].multiply(BigInteger.valueOf(-1));
		
		return pInv;
	}
	
	/*
	 * Función: Suma, función que suma dos puntos, p y q de la curva.
	 * Parámetros: Dos puntos de la curva, p y q, el orden n de la curva.
	 * Salida: Un punto r que resulta sumando p y q.
	 */
	public static BigInteger[] sumaPuntos(BigInteger[] p, BigInteger[] q, BigInteger n) {
		
		BigInteger[] r = new BigInteger[2];
		
		// Tener en cuenta que Xr = λ^2-Xp-Xq, Yr = λ(Xp-Xr)-Yp, λ = (Yq-Yp)/(Xq-Xp) 
		BigInteger a = (q[1].subtract(p[1])); // Inicialmente es el numerador.
		BigInteger b = (q[0].subtract(p[0])); // Inicialmente es el denominador.
		b = b.modInverse(n);
                //b = b.mod(n);
		a = a.multiply(b).mod(n); // a = λ
		b = a.multiply(a); // b = λ^2
		b = ((b.subtract(p[0])).subtract(q[0])).mod(n); // b = Xr
		
		r[0] = b;
		r[1] = (a.multiply(p[0].subtract(b))).subtract(p[1]).mod(n); // Yr = λ(Xp-Xr)-Yp siendo a = λ
	
		return r;
	}
	
	/*
	 * Función: Duplicación, de un punto p resulta de realizar la opración p + p = 2p.
	 * Parámetros: El punto p, el oden n, y el parámetro a de la ecuación.
	 * Salida: Duplicación del punto p, es decir, 2p = r.
	 */
	public static BigInteger[] duplicacionPunto(BigInteger[] p, BigInteger a, BigInteger n) {
		
		BigInteger[] r = new BigInteger[2];
		
		// Tener en cuenta que Xr = λ^2-2*Xp, Yr = λ(Xp-Xr)-Yp, λ = (3*Xp^2+a)/(2*Yp)
		BigInteger w = p[0].multiply(p[0]).multiply(BigInteger.valueOf(3)).add(a);  // Inicialmente es el numerador.
		BigInteger z = (p[1].multiply(BigInteger.valueOf(2))).modInverse(n);        // Inicialmente es el denominador.
                //BigInteger z = (p[1].multiply(BigInteger.valueOf(2))).mod(n);  
		w = (w.multiply(z)).mod(n);  												// w = λ
		z = w.multiply(w); 															// z = λ^2
		z = (z.subtract(p[0].multiply(BigInteger.valueOf(2)))).mod(n);  			// z = λ^2-2*Xp
		
		r[0] = z;																	// Xr = z
		r[1] = (w.multiply(p[0].subtract(z))).subtract(p[1]).mod(n);				// Yr = λ(Xp-Xr)-Yp siendo w = λ
		
		return r;
	}
	
	/*
	 * Función: Multiplicación de un punto de CE por un escalar.
	 * Parámetros: el punto p de la curva, el parámetro a de la ec, el orden n y el escalar esc por el que multiplicar.
	 * Salida: El punto r un vez multiplicado p por el escalar esc- 
	 */
	public static BigInteger[] puntoPorEscalar(BigInteger[] p, BigInteger a, BigInteger n, BigInteger esc) {
		
		BigInteger[] r = new BigInteger[2];
		BigInteger[] duplicarP = p;

		boolean control = false;
		String binMult = esc.toString(2);
		int binMultLen = binMult.length();

		for (int i = binMultLen-1; i >= 0; i--) {
			if (binMult.charAt(i) == '1') {
				if (control) {
					r = sumaPuntos(r, duplicarP, n);
				} else {
					r = duplicarP;
					control = true;
				}
			}
			duplicarP = duplicacionPunto(duplicarP, a, n);
		}	
		return r;
		
	}
}
