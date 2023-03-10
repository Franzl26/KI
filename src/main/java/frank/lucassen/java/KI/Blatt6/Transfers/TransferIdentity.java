package frank.lucassen.java.KI.Blatt6.Transfers;

public class TransferIdentity implements TransferFunktion{
    @Override
    public double funktion(double in) {
        return in;
    }

    @Override
    public double ableitung(double in) {
        return 1;
    }
}
