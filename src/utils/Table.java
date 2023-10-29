package utils;

import java.util.ArrayList;

public class Table {
    ArrayList<Result> results = new ArrayList<Result>();

    public void addElement(Result result) {
        results.add(result);
    }

    public void draw() {
        System.out.println("+-----------+-----------------+----------------------------------------------------------------------------------------------------------------------------------------------------------+-----------+");
        System.out.println("| Algorithm |  Number of Bits |                                                           Number                                                                                         | Time (ms) |");
        System.out.println("+-----------+-----------------+----------------------------------------------------------------------------------------------------------------------------------------------------------+-----------+");

        for (Result result : results) {
            System.out.println(result);
        }

        System.out.println("+-----------+-----------------+----------------------------------------------------------------------------------------------------------------------------------------------------------+-----------+");

    }

    public ArrayList<Result> getAllElements() {
        return results;
    }
}
