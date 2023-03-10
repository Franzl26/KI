package frank.lucassen.java.KI.Blatt6;

import frank.lucassen.java.KI.Blatt6.Transfers.FF2;
import frank.lucassen.java.KI.Blatt6.Transfers.TransferIdentity;

import java.util.Arrays;

public class Aufgabe2 {
    public static void main(String[] args) {
        FF2 netz = new FF2(2, 1, new TransferIdentity());
        netz.trainHebb(new double[]{0, 0}, new double[]{0});
        netz.trainHebb(new double[]{0, 1}, new double[]{0});
        netz.trainHebb(new double[]{1, 0}, new double[]{1});
        netz.trainHebb(new double[]{1, 1}, new double[]{0});
        System.out.println(Arrays.toString(netz.use(new double[]{0, 0})));
        System.out.println(Arrays.toString(netz.use(new double[]{0, 1})));
        System.out.println(Arrays.toString(netz.use(new double[]{1, 0})));
        System.out.println(Arrays.toString(netz.use(new double[]{1, 1})));
    }
}
