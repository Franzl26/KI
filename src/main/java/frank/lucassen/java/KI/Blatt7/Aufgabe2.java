package frank.lucassen.java.KI.Blatt7;

public class Aufgabe2 {
    public static void main(String[] args) {
//        one();
//        System.out.println("-------------------------------");
        two();
    }
    
    public static void one() {
        // weiß = 0, schwarz = 1
        int[] A = new int[]{1, 0, 1, 0};
        int[] B = new int[]{0, 1, 1, 1};
        int[] C = new int[]{0, 0, 0, 1};
        int[] D = new int[]{0, 0, 1, 0};
        int[] E = new int[]{1, 0, 0, 0};
        Hopfield h = new Hopfield(4);
        h.train(A);
        h.train(B);
        System.out.println(h);
        h.use(A, true);
        h.use(B, true);
        h.use(D, true);
        h.use(E, true);
        h.train(C);
        System.out.println(h);
        h.use(A, true);
        h.use(B, true);
        h.use(C, true);
        h.use(D, true);
        h.use(E, true);
    }

    public static void two() {
        // weiß = -1, schwarz = 1
        int[] A = new int[]{1, -1, 1, -1};
        int[] B = new int[]{-1, 1, 1, 1};
        int[] C = new int[]{-1, -1, -1, 1};
        int[] D = new int[]{-1, -1, 1, -1};
        int[] E = new int[]{1, -1, -1, -1};
        Hopfield h = new Hopfield(4);
        h.train(A);
        h.train(B);
        System.out.println(h);
        h.use(A, true);
        h.use(B, true);
        h.use(D, true);
        h.use(E, true);
        h.train(C);
        System.out.println(h);
        h.use(A, true);
        h.use(B, true);
        h.use(C, true);
        h.use(D, true);
        h.use(E, true);
    }
}
