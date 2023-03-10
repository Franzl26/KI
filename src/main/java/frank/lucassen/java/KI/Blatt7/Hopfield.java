package frank.lucassen.java.KI.Blatt7;

import java.util.Arrays;

public class Hopfield {
    private final int[][] matrix;
    private final int neuronen;

    public Hopfield(int neuronen) {
        this.neuronen = neuronen;
        matrix = new int[neuronen][neuronen];
    }

    public void setMatrix(int[][] matrix) {
        if (matrix.length != neuronen) throw new IllegalArgumentException("Falsche Höhe");
        for (int y = 0;y<neuronen;y++) {
            if (matrix[y].length != neuronen) throw new IllegalArgumentException("Falsche Breite");
            System.arraycopy(matrix[y], 0, this.matrix[y], 0, neuronen);
        }
    }

    public void train(int[][] vektoren) {
        for (int[] i : vektoren) train(i);
    }

    public void train(int[] vektor) {
        if (vektor.length != neuronen) throw new IllegalArgumentException("Falsche Länge");
        for (int x = 0; x < neuronen; x++) {
            for (int y = 0; y < neuronen; y++) {
                matrix[y][x] += vektor[x] * vektor[y];
                if (x == y) matrix[y][x]--;
            }
        }
    }

    public void use(int[] vektor, boolean printSteps) {
        if (vektor.length != neuronen) throw new IllegalArgumentException("Falsche Länge");
        int step = 0;
        int[] input = vektor.clone();
        int[] alt = new int[neuronen];
        if (printSteps) System.out.println("0: " + Arrays.toString(input));
        while (true) {
            step++;
            int[] neu = new int[neuronen];
            // multiplizieren
            for (int y = 0; y < neuronen; y++) {
                for (int x = 0; x < neuronen; x++) {
                    neu[y] += matrix[y][x] * input[x];
                }
            }
            // Signum anwenden
            for (int y = 0; y < neuronen; y++) {
                if (neu[y] < 0) neu[y] = -1;
                else if (neu[y] > 0) neu[y] = 1;
                else neu[y] = input[y];
            }
            if (printSteps) System.out.println(step + ": " + Arrays.toString(neu));
            // Abbruch/Enden
            if (step == 100 || Arrays.equals(alt, neu)) {
                System.out.println("Konvergiert nicht");
                return;
            }
            alt = input;
            input = neu;
            if (Arrays.equals(neu, alt)) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int[] arr : matrix) {
            for (int i : arr) {
                if (i >= 0) s.append(" ");
                s.append(i);
            }
            s.append("\n");
        }
        return s.toString();
    }
}
