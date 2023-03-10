package frank.lucassen.java.KI.Blatt6.Transfers;

public class FF2 {
    final int anzIn;
    final int anzOut;
    final double[][] weights;
    final TransferFunktion tf;

    public FF2(int anzIn, int anzOut, TransferFunktion funktion) {
        this.anzIn = anzIn;
        this.anzOut = anzOut;
        weights = new double[anzOut][anzIn];
        tf = funktion;
    }

    public double[] use(double[] in) {
        if (in.length != anzIn) throw new RuntimeException();
        double[] out = new double[anzOut];
        for (int i = 0; i < anzOut; i++) {
            for (int j = 0; j < anzIn; j++) {
                out[i] += in[j] * weights[i][j];
            }
            out[i] = tf.funktion(out[i]);
        }
        return out;
    }

    public void trainHebb(double[] in, double[] out) {
        if (in.length != anzIn || out.length != anzOut) throw new RuntimeException();
        for (int i = 0; i < anzOut; i++) {
            for (int j = 0; j < anzIn; j++) {
                weights[i][j] += in[j] * out[i];
                //System.out.println(in[j] +"  "+ out[i]);
                //System.out.println(Arrays.deepToString(weights));
            }
            out[i] = tf.funktion(out[i]);
        }
    }
}
