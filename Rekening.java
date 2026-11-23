
public class Rekening {

    private double saldo;
    private String pin;

    public Rekening(double saldo, String pin) {
        this.saldo = saldo;
        this.pin = pin;
    }

    public boolean cekPin(String pin) {
        return this.pin.equals(pin);
    }

    public double getSaldo() {
        return saldo;
    }

    public void gantiPin(String pinBaru) {
        this.pin = pinBaru;
    }

    public void tarikSaldo(double jumlah) {
        saldo -= jumlah;
    }

    public void tambahSaldo(double jumlah) {
        saldo += jumlah;
    }
}
