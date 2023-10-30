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
        // Registra o tempo inicial para fins de medição
        this.initialTime = System.currentTimeMillis();

        // Inicialização do estado e dos parâmetros do LCG
        this.state = BigInteger.valueOf(initialTime);
        this.a = new BigInteger("6364136223846793005");
        this.c = new BigInteger("1442695040888963407");
        this.m = BigInteger.ONE;
    }

    // Função para gerar um número pseudoaleatório com "bits" de comprimento
    public Result generateRandomNumber(int numBits) {
        this.numBits = numBits;

        // Defina o tamanho do módulo "m" com base na quantidade de bits
        this.m = BigInteger.valueOf(2).pow(numBits);

        // Calcule o próximo estado do LCG
        state = state.multiply(a).add(c).mod(m);

        // Calcule o tempo decorrido para a geração
        this.finalTime = System.currentTimeMillis() - initialTime;

        // Crie um objeto "Result" com os detalhes da geração
        Result result = new Result("LCG", state, finalTime, numBits);

        return result;
    }
}
