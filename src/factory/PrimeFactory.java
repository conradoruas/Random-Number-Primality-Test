package factory;

import algorithms.primeCheck.PrimeAlgorithm;
import algorithms.pseudoRandomGenerator.Algorithm;
import utils.Result;
import utils.Table;

import java.math.BigInteger;

public class PrimeFactory implements Factory {
    Table table;
    Table primeTable;
    Algorithm numberGeneratorAlgorithm;
    PrimeAlgorithm primeAlgorithm;

    public PrimeFactory(Table table, Table primeTable,  PrimeAlgorithm primeAlgorithm, Algorithm numberGeneratorAlgorithm) {
        this.table = table;
        this.primeTable = primeTable;
        this.numberGeneratorAlgorithm = numberGeneratorAlgorithm;
        this.primeAlgorithm = primeAlgorithm;
    }

    public void getPrime() {
        try {
            for (Result result : table.getAllElements()) {
                if (result.getNumberBits() < 2049) {
                    long initialTime = System.currentTimeMillis();
                    boolean notPrime = true;
                    BigInteger possiblePrimeNumber = result.getRandomNumber();

                    while (notPrime) {
                        if (isPrime(possiblePrimeNumber)) {
                            long finalTime = System.currentTimeMillis() - initialTime;
                            primeTable.addElement(new Result(primeAlgorithm.getName(),possiblePrimeNumber, finalTime,result.getNumberBits()));
                            notPrime = false;
                        }
                        possiblePrimeNumber = getNewRandomNumber(result.getNumberBits()).getRandomNumber();
                    }
                }
            }


        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Result getNewRandomNumber(int bits) {
        return numberGeneratorAlgorithm.generateRandomNumber(bits);
    }

    public boolean isPrime(BigInteger number) {
       return primeAlgorithm.isPrime(number, 10);
    }

    public void populateTable() {
        for (PossibleBits bits : PossibleBits.values()) {
            int bit = bits.getValue();
            this.table.addElement(numberGeneratorAlgorithm.generateRandomNumber(bit));
        }
    }

}

