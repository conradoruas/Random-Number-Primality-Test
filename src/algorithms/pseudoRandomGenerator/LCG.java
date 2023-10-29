package algorithms.pseudoRandomGenerator;

import utils.Result;

import java.math.BigInteger;

public class LCG implements Algorithm {
    private BigInteger state;
    private BigInteger m;
    private final BigInteger a;
    private final BigInteger c;
    private long initialTime;
    private long finalTime;
    private int numBits;

    public LCG() {
        this.initialTime = System.currentTimeMillis();

        this.state = BigInteger.valueOf(initialTime);
        this.a = new BigInteger("6364136223846793005");
        this.c = new BigInteger("1442695040888963407");
        this.m = BigInteger.ONE;
    }


    public Result generateRandomNumber(int bits) {
        this.numBits = bits;
        this.m = BigInteger.valueOf(2).pow(bits);

        state = state.multiply(a).add(c).mod(m);
        this.finalTime = System.currentTimeMillis() - initialTime;
        Result result = new Result("LCG", state, finalTime, bits);

        return result;
    }

    public long getFinalTime() {
        return finalTime;
    }
}
