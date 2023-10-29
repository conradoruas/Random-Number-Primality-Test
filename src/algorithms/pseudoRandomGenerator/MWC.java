package algorithms.pseudoRandomGenerator;

import utils.Result;

import java.math.BigInteger;

public class MWC implements Algorithm {
    private BigInteger state;
    private BigInteger carry;
    private BigInteger multiplier;
    private int bits;
    private long initialTime;
    private long finalTime;

    public MWC() {
        this.initialTime = System.currentTimeMillis();
        this.state = BigInteger.valueOf(System.currentTimeMillis());
        this.multiplier = new BigInteger("6364136223846793005");
        this.carry = BigInteger.ZERO;
    }

    public Result generateRandomNumber(int numBits) {
        this.bits = numBits;
        BigInteger base = BigInteger.valueOf(2).pow(numBits);
        state = state.multiply(multiplier).add(carry).mod(base);
        carry = state.divide(base);
        this.finalTime = System.currentTimeMillis() - this.initialTime;

        Result result = new Result("MWC", state,this.finalTime, numBits);
        return result;
    }
}
