package algorithms.primeCheck;

import java.math.BigInteger;

public interface PrimeAlgorithm {
    public boolean isPrime(BigInteger n, int k);
    public String getName();
}
