package frank.lucassen.java.KI.Blatt7;

public class Aufgabe1 {
    public static void main(String[] args) {
        Hopfield h = new Hopfield(5);
        h.train(new int[]{-1, 1, 1, 0, -1});
        System.out.println(h);
        h.use(new int[]{-1, 1, 1, 0, -1}, true);
    }
}
