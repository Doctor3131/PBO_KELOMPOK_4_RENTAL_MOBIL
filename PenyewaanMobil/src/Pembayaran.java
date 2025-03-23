public class Pembayaran {
    private int idPembayaran;
    private double nominal;
    private static int pembayaranCounter = 0;

    public Pembayaran() {
        pembayaranCounter += 1;
        this.idPembayaran = pembayaranCounter;
        this.nominal = 0;
    }

    public Pembayaran(double nominal) {
        pembayaranCounter += 1;
        this.idPembayaran = pembayaranCounter;
        this.nominal = nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public double getNominal() {
        return nominal;
    }

    public int getIdPembayaran() {
        return idPembayaran;
    }

    public static int getPembayaranCounter() {
        return pembayaranCounter;
    }

    public void showIdPembayaran() {
        System.out.println("ID Pembayaran : " + idPembayaran);
        System.out.println("Nominal : " + nominal);
    }
}
