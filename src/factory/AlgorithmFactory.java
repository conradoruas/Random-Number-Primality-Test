package factory;

import algorithms.pseudoRandomGenerator.Algorithm;
import utils.Table;

public class AlgorithmFactory implements Factory {
    Algorithm algorithm;
    Table table;

    public AlgorithmFactory(Algorithm algorithm, Table table) {
        this.algorithm = algorithm;
        this.table = table;
    }

    public void populateTable() {
        for (PossibleBits bits : PossibleBits.values()) {
            int bit = bits.getValue();
            this.table.addElement(algorithm.generateRandomNumber(bit));
        }
    }
}
