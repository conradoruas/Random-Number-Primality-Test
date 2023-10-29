import algorithms.primeCheck.FermatPrimalityTest;
import algorithms.pseudoRandomGenerator.LCG;
import algorithms.pseudoRandomGenerator.MWC;
import algorithms.primeCheck.MillerRabin;
import factory.AlgorithmFactory;

import factory.PrimeFactory;
import utils.Table;


public class main {
    public static void main(String[] args) {
        Table table = new Table();
        Table primeTable = new Table();

        LCG lcg = new LCG();
        MWC mwc = new MWC();
        MillerRabin millerRabin = new MillerRabin();
        FermatPrimalityTest fermat = new FermatPrimalityTest();

        AlgorithmFactory LCGFactory = new AlgorithmFactory(lcg, table);
        AlgorithmFactory MWCFactory = new AlgorithmFactory(mwc, table);
        PrimeFactory MillerFactory = new PrimeFactory(table, primeTable, millerRabin, lcg);
        PrimeFactory FermatFactory = new PrimeFactory(table, primeTable, fermat, lcg);

        LCGFactory.populateTable();
        MWCFactory.populateTable();

        table.draw();

        MillerFactory.getPrime();
        FermatFactory.getPrime();

        primeTable.draw();

    }

}