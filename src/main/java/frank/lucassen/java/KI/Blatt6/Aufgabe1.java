package frank.lucassen.java.KI.Blatt6;

import frank.lucassen.java.KI.Blatt6.Transfers.FF2;
import frank.lucassen.java.KI.Blatt6.Transfers.TransferIdentity;

import java.util.Arrays;

public class Aufgabe1 {
    public static void main(String[] args) {
        FF2 netz = new FF2(3, 2, new TransferIdentity());
        netz.trainHebb(new double[]{0.6, 0, 0.8}, new double[]{4, 3});
        netz.trainHebb(new double[]{-0.8, 0, 0.6}, new double[]{-1, 2});
        System.out.println(Arrays.toString(netz.use(new double[]{0.6, 0, 0.8})));
        System.out.println(Arrays.toString(netz.use(new double[]{-0.8, 0, 0.6})));
        netz.trainHebb(new double[]{0,1,0}, new double[]{1,1});
        System.out.println(Arrays.toString(netz.use(new double[]{0.6, 0, 0.8})));
        System.out.println(Arrays.toString(netz.use(new double[]{-0.8, 0, 0.6})));
        System.out.println(Arrays.toString(netz.use(new double[]{0,1,0})));
        netz.trainHebb(new double[]{1,0,0}, new double[]{0,1});
        System.out.println(Arrays.toString(netz.use(new double[]{0.6, 0, 0.8})));
        System.out.println(Arrays.toString(netz.use(new double[]{-0.8, 0, 0.6})));
        System.out.println(Arrays.toString(netz.use(new double[]{0,1,0})));
        System.out.println(Arrays.toString(netz.use(new double[]{1,0,0})));
    }
}
