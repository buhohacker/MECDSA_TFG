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
import java.util.Random;

/*
 * Fichero: MetodosBigInt.java
 * Autor: Andrea del Nido García
 * Función: Esta clase se utilizará para crear métodos con las operaciones de las curvas elípticas en cuerpos primos.
 */
public class MetodosBigInt {

    // Vars estáticas para método Lucas-Meher ------> ver https://www.josechu.com/mates/tll/index_es.htm
    static double start_time = System.currentTimeMillis();
    static double time_elapsed;
    static int np;

    public static BigInteger randomMenorQueN(BigInteger n) {

        BigInteger r;
        Random al = new Random();
        do {
            r = new BigInteger(n.bitLength(), al);
        } while (r.compareTo(n) >= 0);
        return r;
    }

    // Con este método generamos un número aleatorio de 256 bits.
    public static BigInteger generadorRandom() {
        Random r = new Random();
        BigInteger xx = new BigInteger(256, r);
        return xx;
    }

    // Método que genera una lista de BigInteger random de tamaño 256 bits.
    public static BigInteger[] listaNumeros256b() {
        BigInteger[] lista = new BigInteger[300];
        BigInteger b;
        int cont = 0;

        while (cont < 300) {
            b = generadorRandom();
            lista[cont] = b;
            cont = cont + 1;
        }
        return lista;
    }

    // Método que obtiene una lista de primos, con n muy grande no funciona.
    public static BigInteger[] listaPrimos256b(BigInteger[] lista) {
        BigInteger[] primos = new BigInteger[300];
        int i = 0;

        while (i < 300) {
            //System.out.println("Llegas aquí?");
            if (OperacionesParamCurvas.esPrimo(lista[i])) {
                primos[i] = lista[i];
            } else {
                primos[i] = BigInteger.ZERO;
            }
            i = i + 1;
        }
        return primos;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Ver https://www.josechu.com/mates/tll/index_es.htm para saber más sobre cómo generar primos grandes.
    public static int esPrimoP(int n) {
        int rq = (int) Math.sqrt(n);
        for (int i = 2; i <= rq; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return n;
    }

    public static void escribePrimosMersenne() {
        for (int i = 3; i < 700; i++) {
            int n = esPrimoP(i);
            if (n != 0) {
                BigInteger Mp = BigInteger.valueOf(2).pow(n);
                Mp = Mp.add(BigInteger.valueOf(-1));
                BigInteger s = BigInteger.valueOf(4);
                for (int j = 2; j < n; j++) {
                    s = s.pow(2);
                    s = s.add(BigInteger.valueOf(-2));
                    s = s.mod(Mp);
                    if (s.equals(BigInteger.valueOf(0))) {
                        np++;
                        System.out.println("");
                        System.out.println("M" + n + " es primo");
                        System.out.println("p=" + n + " M" + n + "=2^" + n
                                + "-1=" + Mp + " S" + j + "=" + s);
                        break;
                    }
                }
            }
        }
    }
}
