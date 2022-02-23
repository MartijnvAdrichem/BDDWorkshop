package betalen;

public class Rekening {

    private int pincode;
    private int saldo;

    public Rekening(int pincode, int saldo) {
        this.pincode = pincode;
        this.saldo = saldo;
    }

    public int getPincode() {
        return pincode;
    }

    public int getSaldo() {
        return saldo;
    }

    public void haalSaldoAf(int saldo) {
        this.saldo -= saldo;
    }
}