package factory;

import algorithms.pseudoRandomGenerator.Algorithm;
import utils.Table;

public class AlgorithmFactory implements Factory {
    Algorithm algorithm;
    Table table;

    // Construtor que recebe uma instância de um algoritmo e uma tabela
    public AlgorithmFactory(Algorithm algorithm, Table table) {
        this.algorithm = algorithm;
        this.table = table;
    }

    // Método para preencher a tabela com números gerados pelo algoritmo
    public void populateTable() {
        // Itera sobre os possíveis tamanhos de bits definidos em "PossibleBits"
        for (PossibleBits bits : PossibleBits.values()) {
            int bit = bits.getValue();
            // Gera um número pseudoaleatório com o tamanho de bits atual usando o algoritmo e Adiciona
            // o resultado à tabela
            this.table.addElement(algorithm.generateRandomNumber(bit));
        }
    }
}
