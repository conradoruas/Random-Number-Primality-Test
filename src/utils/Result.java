package utils;

import java.math.BigInteger;

public class Result {
    String algorithm;
    BigInteger randomNumber;
    int numberBits;
    long timeOfOperation;

    public Result(String algorithm, BigInteger randNumber, long time, int numberBits) {
        this.algorithm = algorithm;
        this.randomNumber = randNumber;
        this.timeOfOperation = time;
        this.numberBits = numberBits;
    }

    public long getTimeOfOperation() {
        return timeOfOperation;
    }

    public BigInteger getRandomNumber() {
        return randomNumber;
    }

    public int getNumberBits() {
        return numberBits;
    }

    @Override
    public String toString() {
        return String.format("| %-9s | %-15s | %-152s | %-5d |", algorithm, numberBits, randomNumber, timeOfOperation);
    }
}

