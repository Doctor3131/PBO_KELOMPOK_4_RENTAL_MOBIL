public class PembayaranNonTunai extends Pembayaran {
    private String resiBank;

    public PembayaranNonTunai() {
        this.resiBank = "00000";
    }

    public PembayaranNonTunai(double nominal, String resiBank) {
        super(nominal);
        this.resiBank = resiBank;
    }

    public String getResiBank() {
        return resiBank;
    }

    public void setResiBank(String resiBank) {
        this.resiBank = resiBank;
    }

    @Override
    public void showIdPembayaran() {
        super.showIdPembayaran();
        System.out.println("Resi Bank : " + resiBank);
    }
}
