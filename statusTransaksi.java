public enum statusTransaksi {
    DISEWA("Disewa"),
    SELESAI("Selesai");

    private final String label;

    statusTransaksi(String label) {
        this.label = label;
    }

    public String getStatus() {
        return label;
    }
}
