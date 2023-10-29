package algorithms.primeCheck;

import java.math.BigInteger;
import java.util.Random;

public class FermatPrimalityTest implements PrimeAlgorithm {
    public boolean isPrime(BigInteger n, int k) {
        if (n.compareTo(BigInteger.ONE) <= 0)
            return false;
        if (n.compareTo(BigInteger.valueOf(3)) <= 0)
            return true;

        Random rand = new Random();

        for (int i = 0; i < k; i++) {
            BigInteger a = new BigInteger(n.bitLength(), rand);
            a = a.mod(n.subtract(BigInteger.valueOf(2))).add(BigInteger.valueOf(2));

            if (!fermatTest(a, n))
                return false;
        }

        return true;
    }

    private static boolean fermatTest(BigInteger a, BigInteger n) {
        BigInteger result = a.modPow(n.subtract(BigInteger.ONE), n);
        return result.equals(BigInteger.ONE);
    }

    public String getName() {
        return "Fermat Primality Test";
    }
}