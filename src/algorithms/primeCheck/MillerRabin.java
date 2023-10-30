package algorithms.primeCheck;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabin implements PrimeAlgorithm {
    public BigInteger primeNumber;

    // Função para calcular x^y mod p
    public BigInteger power(BigInteger x, BigInteger y, BigInteger p) {
        BigInteger res = BigInteger.ONE;
        x = x.mod(p);

        while (y.compareTo(BigInteger.ZERO) > 0) {
            if (y.testBit(0)) {
                res = res.multiply(x).mod(p);
            }
            y = y.shiftRight(1);
            x = x.multiply(x).mod(p);
        }

        return res;
    }

    // Teste de Miller-Rabin para um valor específico "a"
    public boolean millerTest(BigInteger d, BigInteger n) {
        BigInteger a = BigInteger.TWO.add(new BigInteger(n.bitLength() - 2, new Random()));

        BigInteger x = power(a, d, n);

        if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) {
            return true;
        }

        while (!d.equals(n.subtract(BigInteger.ONE))) {
            x = x.multiply(x).mod(n);
            d = d.multiply(BigInteger.TWO);

            if (x.equals(BigInteger.ONE)) {
                return false;
            }
            if (x.equals(n.subtract(BigInteger.ONE))) {
                return true;
            }
        }

        return false;
    }

    // Função principal para verificar se um número é primo usando o algoritmo Miller-Rabin
    public boolean isPrime(BigInteger n, int k) {
        this.primeNumber = n;
        if (n.compareTo(BigInteger.ONE) <= 0 || n.equals(BigInteger.valueOf(4))) {
            return false;
        }
        if (n.compareTo(BigInteger.valueOf(3)) <= 0) {
            return true;
        }

        // Encontrar o valor "d" e garantir que "n" seja ímpar
        BigInteger d = n.subtract(BigInteger.ONE);
        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
        }

        for (int i = 0; i < k; i++) {
            if (!millerTest(d, n)) {
                return false;
            }
        }

        return true;
    }

    // Retorna o nome do algoritmo
    public String getName() {
        return "Miller Rabin";
    }
}
