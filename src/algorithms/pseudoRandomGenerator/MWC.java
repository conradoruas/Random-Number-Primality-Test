package algorithms.pseudoRandomGenerator;

import utils.Result;

import java.math.BigInteger;

public class MWC implements Algorithm {
    private BigInteger state;
    private BigInteger carry;
    private BigInteger multiplier;
    private BigInteger base;
    private int bits;
    private long initialTime;
    private long finalTime;

    public MWC() {
        // Registra o tempo inicial para fins de medição
        this.initialTime = System.currentTimeMillis();

        // Inicialização do estado e dos parâmetros do MWC
        this.state = BigInteger.valueOf(System.currentTimeMillis());
        this.multiplier = new BigInteger("6364136223846793005");
        this.carry = BigInteger.ZERO;
    }

    // Função para gerar um número pseudoaleatório com "numBits" de comprimento
    public Result generateRandomNumber(int numBits) {
        this.bits = numBits;
        this.base = BigInteger.valueOf(2).pow(numBits);

        // Calcula o próximo estado do MWC
        state = state.multiply(multiplier).add(carry).mod(base);
        carry = state.divide(base);

        // Calcula o tempo decorrido para a geração
        this.finalTime = System.currentTimeMillis() - this.initialTime;

        // Cria um objeto "Result" com os detalhes da geração
        Result result = new Result("MWC", state,this.finalTime, numBits);
        return result;
    }
}
