package algorithms.primeCheck;

import java.math.BigInteger;
import java.util.Random;

public class FermatPrimalityTest implements PrimeAlgorithm {
    // Função para verificar se um número é primo
    public boolean isPrime(BigInteger n, int k) {
        // Verifique se o número é menor ou igual a 1 e se é igual a 2 ou 3.
        if (n.compareTo(BigInteger.ONE) <= 0)
            return false;
        if (n.compareTo(BigInteger.valueOf(3)) <= 0)
            return true;

        Random rand = new Random();

        // Realize o teste de Fermat k vezes
        for (int i = 0; i < k; i++) {
            // Gere um número aleatório "a" no mesmo tamanho que "n"
            BigInteger a = new BigInteger(n.bitLength(), rand);
            // Certifique-se de que "a" esteja dentro do intervalo [2, n-2]
            a = a.mod(n.subtract(BigInteger.valueOf(2))).add(BigInteger.valueOf(2));

            // Realize o teste de Fermat com "a"
            if (!fermatTest(a, n))
                return false;
        }

        return true;
    }

    // Função privada para executar o teste de Fermat com um valor "a"
    private static boolean fermatTest(BigInteger a, BigInteger n) {
        // Calcula a^(n-1) mod n
        BigInteger result = a.modPow(n.subtract(BigInteger.ONE), n);
        // Se o resultado for igual a 1, o teste de Fermat passou
        return result.equals(BigInteger.ONE);
    }

    // Retorna o nome do algoritmo
    public String getName() {
        return "Fermat Primality Test";
    }
}