package frank.lucassen.java.KI.Blatt7;

public class Aufgabe3 {
    public static void main(String[] args) {
        Hopfield h = new Hopfield(3);
        h.setMatrix(new int[][]{{0, 1, 2}, {1, 0, 1}, {2, 1, 0}});
        int[] vektor = new int[]{-1, 1, 1};
        h.use(vektor, true);
    }
}
