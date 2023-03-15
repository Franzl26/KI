package frank.lucassen.java.KI;

import java.util.Arrays;

public class EntropieGain {
    private static final boolean printFull = true;

    public static void main(String[] args) {
        /*// Blatt 5 Aufgabe 2
        entropie(3, 3);
        gain(new int[]{3, 2, 1}, new int[]{3, 2, 1});

        // Blatt 5 Aufgabe 3
        // sport, farbe
        gain(new int[]{4, 3, 1}, new int[]{1, 0, 1});
        // sport ursprung
        gain(new int[]{4, 2, 2}, new int[]{1, 1, 0});

        // Blatt 5 Aufgabe 4
        gain(new int[]{9, 2, 4, 3}, new int[]{6, 4, 0, 2}); // vorhersage
        gain(new int[]{9, 2, 4, 3}, new int[]{6, 2, 3, 1}); // temp
        gain(new int[]{9, 3, 6}, new int[]{6, 4, 2}); // luftf
        gain(new int[]{9, 6, 3}, new int[]{6, 3, 3}); // wind*/

        //gain(new int[]{4,2,2}, new int[]{4,2,2}); // klima
        //gain(new int[]{4,3,1}, new int[]{4,2,2}); // meer
        //gain(new int[]{4,4,0}, new int[]{4,2,2}); // kosten

        // sonnig
        gain(new int[]{2,1,1}, new int[]{4,4,0}); // temp warm, kalt
        gain(new int[]{2,1,1}, new int[]{4,1,3}); // wind stark, schwach

    }

    public static double entropie(int p, int n) {
        return entropie(p, n, true);
    }

    public static double entropie(int p, int n, boolean print) {
        double result;
        if (p == 0 || n == 0) {
            result = 0.0;
        } else {
            double pOverN = 1.0 * p / (p + n);
            double nOverP = 1.0 * n / (p + n);
            result = -pOverN * (Math.log(pOverN) / Math.log(2)) - nOverP * (Math.log(nOverP) / Math.log(2));
        }
        if (print) System.out.println("Entropie von p=" + p + " und n=" + n + " ist: " + result);
        return result;
    }

    /**
     * @param p 0: positive ohne Trennung, danach für jede Möglichkeit der Variable
     * @param n 0: negative ohne Trennung, danach für jede Möglichkeit der Variable
     * @return gain
     */
    public static double gain(int[] p, int[] n) {
        return gain(p, n, true);
    }

    /**
     * @param p 0: positive ohne Trennung, danach für jede Möglichkeit der Variable
     * @param n 0: negative ohne Trennung, danach für jede Möglichkeit der Variable
     * @return gain
     */
    public static double gain(int[] p, int[] n, boolean print) {
        if (p.length != n.length) throw new RuntimeException();
        double result = entropie(p[0], n[0], false);
        //double result = gesEntropie;
        for (int i = 1; i < p.length; i++) {
            result -= (1.0 * (p[i] + n[i]) / (p[0] + n[0])) * entropie(p[i], n[i], false);
        }
        if (print) System.out.println("gain für p=" + Arrays.toString(p) + " n=" + Arrays.toString(n) + " ist: " + result);
        if (printFull) {
            System.out.println("Entropie(S) = e(p,n) = -p/(p+n) * log2(p/[p+n]) - n/(p+n) * log2(n/[p+n])");
            System.out.print("gain für p=" + Arrays.toString(p) + " n=" + Arrays.toString(n) + " = ");
            System.out.print("e(" + p[0]+","+n[0]+") - [");
            for (int i = 1; i < p.length; i++) {
                System.out.print((p[i] + n[i]) +"/"+ (p[0] + n[0]) + " * e("+p[i]+","+n[i]+")");
                if (i != p.length-1) System.out.print(" + ");
            }
            System.out.println("] = " + result + "\n");

        }
        return result;
    }
}
