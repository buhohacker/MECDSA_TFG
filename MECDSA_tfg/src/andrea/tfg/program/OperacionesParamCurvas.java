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
public class OperacionesParamCurvas {

    ///// METODO MUY LENTO NO USAR!! /////
    // Método para saber si un BigInteger es primo, utilizrlo para verificar que p es primo de la curva.
    public static boolean esPrimoPrueba(BigInteger numero) {
        BigInteger contador = BigInteger.valueOf(2);
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero.mod(contador).equals(BigInteger.ZERO)) {
                primo = false;
            }
            contador.add(BigInteger.ONE);
        }
        return primo;
    }

    // Método más rápido para ver si un BigInteger es primo, 
    // con la ayuda de la página http://programandonet.com/questions/88818/el-algoritmo-mas-rapido-para-encontrar-si-un-biginteger-es-un-numero-primo-o-no-duplicar
    public static boolean esPrimo(BigInteger number) {
        if (!number.isProbablePrime(5)) {
            return false;
        }

        // Comprobamos si es par.
        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two))) {
            return false;
        }

        // Encontrar divisor si es que hay de 3 a 'número'
        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { // Comnenzando desde 3, 5, etc. el número impar, y buscamos un divisor si lo hubiera
            if (BigInteger.ZERO.equals(number.mod(i))) // Comprobamos si i es divisor del número.
            {
                return false;
            }
        }
        return true;
    }

    // Método para saber si los parámetros a y b de la curva pertenecen a Fp comprobando que p es primo.
    public static boolean pertenecenAFp(BigInteger p, BigInteger a, BigInteger b) {
        boolean pertenecen = false;
        boolean res = esPrimo(p);
        if (res && (a.compareTo(p) == -1) && (b.compareTo(p) == -1)) {
            pertenecen = true;
        }
        return pertenecen;
    }

    // Utilizamos este método para calcular el punto base de la curva según los parámetros introducidos por el usuario.
    public static BigInteger[] calcularPuntoBase(BigInteger p, BigInteger a, BigInteger b, BigInteger n) {
        BigInteger[] Pxy = new BigInteger[2];
        BigInteger x;
        BigInteger y;
        Boolean flag = false;
        /* El contador es para hacer 10000 iter, si antes de las 100 flag es true --> hemos encontrado un punto de la curva
         pero si no --> llegamos a la última iter salimos del bucle y devolvevemos que P es null, tenemos que controlarlo luego.
         */
        //int cont = 1000000;

        // Ojo bucle infinito si nunca se cumple la ecuación. --> Se intenta arreglar con la var contador.
        //while (cont > 0 && flag == false) {
            //cont = cont - 1;
        while (flag == false) {
            x = MetodosBigInt.randomMenorQueN(p);
            y = MetodosBigInt.randomMenorQueN(p);
            System.out.println("Antes del if: " + " x:" + x + " y:" + y);
            BigInteger xAux = x;
            BigInteger yAux = y;
            yAux = y.pow(2).mod(n);
            xAux = x.pow(3).mod(n);
            xAux = xAux.add(a.multiply(x).add(b)).mod(n);
            if (yAux.equals(xAux)) {
                Pxy[0] = x;
                Pxy[1] = y;
                flag = true;
            }
            System.out.println("Después del if " + " x:" + Pxy[0] + " y:" + Pxy[1]);
            System.out.println("El flag vale: " + flag);
        }

        // No sería necesario este if pq el pto esta inicializado a cero. --> Punto O es el infinito?? El (0,0)??
        /*
        if (cont == 0) {
            Pxy[0] = BigInteger.ZERO;
            Pxy[1] = BigInteger.ZERO;
        }
                */
        return Pxy;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Método alternativo para encontrar punto base.
    public static BigInteger[] obtPtoBase(BigInteger p, BigInteger a, BigInteger b, BigInteger n) {

        int longp = p.intValue();
        BigInteger[] punto = new BigInteger[2];
        BigInteger x;
        BigInteger y;
        BigInteger[] l1 = new BigInteger[longp - 1];
        BigInteger[] l2 = new BigInteger[longp - 1];
        Boolean flag = false;

        for (int i = 0; i < longp - 1; i++) {
            BigInteger aux = BigInteger.valueOf(i);
            l1[i] = aux.add(BigInteger.ONE);
            l2[i] = aux.add(BigInteger.ONE);
        }
        System.out.println("Prueba metodo punto base." + OperacionesString.arrayToJSON(l1) + "Lista dos: " + OperacionesString.arrayToJSON(l2));

        for (int j = 0; j < longp - 1 && flag == false; j++) {
            x = l1[j];
            y = l2[j];
            BigInteger xAux = x;
            BigInteger yAux = y;
            yAux = y.pow(2).mod(n);
            xAux = x.pow(3).mod(n);
            xAux = xAux.add(a.multiply(x).add(b)).mod(n);

            System.out.println("Antes del if: " + " Contador:" + j + " x:" + x + " y:" + y);

            if (yAux.equals(xAux)) {
                punto[0] = x;
                punto[1] = y;
                flag = true;
            }

            System.out.println("Después del if " + " x:" + punto[0] + " y:" + punto[1]);
            System.out.println("El flag vale: " + flag);
        }
        return punto;
    }
    
    // Método para saber si un punto pertenece a la curva.
    public static Boolean puntoPertenece (BigInteger[] punto, BigInteger a, BigInteger b, BigInteger n) {
        Boolean pertenece = false;
        BigInteger x = punto[0];
        BigInteger y = punto[1];
        BigInteger xAux = x;
        BigInteger yAux = y;
        yAux = y.pow(2).mod(n);
        xAux = x.pow(3);
        xAux = xAux.add(a.multiply(x).add(b)).mod(n);
        System.out.println("x : " + yAux + " y: " + xAux + '\n');
        if (yAux.equals(xAux)) {
                pertenece = true;
            }
        return pertenece;
    }
    
    
    /////////////// Parece que este método es el más eficiente hasta ahora /////////////
    //  p es primo, a el parámetro y n el orden.   https://stackoverflow.com/questions/11156779/generate-base-point-g-of-elliptic-curve-for-elliptic-curve-cryptography
    public static BigInteger[] pruebaPtoBaseP(BigInteger p, BigInteger n, BigInteger a, BigInteger b) {
        BigInteger[] punto = new BigInteger[2];
        BigInteger k = BigInteger.valueOf(2); //Ponemos 2 por poner algo. --> Cómo escogemos k?????
        BigInteger[] G = new BigInteger[2];
        boolean flag = false;
        //BigInteger[] cero = {BigInteger.ZERO, BigInteger.ZERO};

        do {
            BigInteger r1 = MetodosBigInt.randomMenorQueN(p);
            BigInteger r2 = MetodosBigInt.randomMenorQueN(p);
            punto[0] = r1;
            punto[1] = r2;
            System.out.println("Punto: " + OperacionesString.imprimirPunto(punto));
            System.out.println("Imprimimos k: "+k);
           // G = OperacionesCE.puntoPorEscalar(punto, a, n, k);
            G[0] = punto[0].multiply(k).mod(n);
            G[1] = punto[1].multiply(k).mod(n);
            System.out.println("G: " + OperacionesString.imprimirPunto(G)+'\n');
            //if (!Arrays.equals(G, cero)) {
            
            /*
            BigInteger[] compro = new BigInteger[2];
            compro[0] = G[0].multiply(n).mod(n);
            compro[1] = G[1].multiply(n).mod(n);
            */
            
            if (OperacionesString.imprimirPunto(G).compareTo("(0,0)")!=0) { //&& ToStringJSON.imprimirPunto(compro).compareTo("(0,0") == 0
                flag = true;
            }
        } while (flag == false);
        
        // Comprobamos si el punto pertenece a la curva.
        Boolean pertenece = puntoPertenece(G, a, b, n);
        if (pertenece) {
            System.out.println("El punto pertenece a la curva.\n");
        } else {
            System.out.println("El punto no pertenece a la curva.\n");
        }
        
        return G;
    }
    
    ///////////// Esto pude ser demasiado complejo para números tan grandes //////////////
   public static BigInteger[] obtenerPtosCurva (BigInteger p, BigInteger a, BigInteger b) {
        int cont = p.intValue();
        BigInteger[] listaPuntos = null;
       // BigInteger[] listaCuadrados = new BigInteger[cont];
        BigInteger[] listaCuadrados = new BigInteger[cont];
        
        for (int i = 0; i < cont; i++) {
            
            BigInteger iBig = BigInteger.valueOf(i);
            listaCuadrados[i] = iBig.pow(2).mod(p);
            //System.out.println("Lista de cuadrados con el módulo: " + ToStringJSON.arrayToJSON(listaCuadrados));
        }
        
        // No hay que devolver eso tenemos que devolver lo correspondiente.
        return listaCuadrados;
   }
   
   public static BigInteger[] pruebaPtoBase(BigInteger p, BigInteger n, BigInteger a, BigInteger b) {
        BigInteger[] punto = new BigInteger[2];
        BigInteger k = BigInteger.valueOf(2); //Ponemos 2 por poner algo. --> Cómo escogemos k?????
        BigInteger[] G = new BigInteger[2];
        //boolean flag = false;
        //BigInteger[] cero = {BigInteger.ZERO, BigInteger.ZERO};
        BigInteger[] comp = new BigInteger[2];

        do {
            BigInteger r1 = MetodosBigInt.randomMenorQueN(p);
            BigInteger r2 = MetodosBigInt.randomMenorQueN(p);
            punto[0] = r1;
            punto[1] = r2;
            System.out.println("Punto: " + OperacionesString.imprimirPunto(punto));
            System.out.println("Imprimimos k: "+k);
            G = OperacionesCE.puntoPorEscalar(punto, a, n, k);
            //G[0] = punto[0].multiply(k).mod(n);
            //G[1] = punto[1].multiply(k).mod(n);
            System.out.println("G: " + OperacionesString.imprimirPunto(G)+'\n');
            comp[0] = G[0].multiply(p).mod(n);
            comp[1] = G[1].multiply(p).mod(n);
            comp = OperacionesCE.puntoPorEscalar(G, a, n, p);
        } while (OperacionesString.imprimirPunto(G).compareTo("(0,0)")==0 && OperacionesString.imprimirPunto(comp).compareTo("(0,0)")==0);
        
        // Comprobamos si el punto pertenece a la curva.
        Boolean pertenece = puntoPertenece(G, a, b, n);
        if (pertenece) {
            System.out.println("El punto pertenece a la curva.\n");
        } else {
            System.out.println("El punto no pertenece a la curva.\n");
        }
        
        return G;
    }
   
}
