import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaksi {
    /* ATRIBUT */
    private int ID_transaksi;
    private LocalDate tanggal_transaksi;
    private int durasi_sopir;
    private int durasi_kendaraan;
    private statusTransaksi status_transaksi; // antara Disewa atau Selesai
    private Mobil mobil;
    private Penyewa penyewa;
    private Sopir sopir;
    private Pembayaran pembayaran;
    private static int countTransaksi = 0;
    private double hargaPerHariKendaraan = 300000; // Rp 300.000 per day
    private double hargaPerHariSopir = 150000;     // Rp 150.000 per day

    /* METHOD */
    // KONSTRUKTOR
    public Transaksi() {
        countTransaksi++;
        this.ID_transaksi = countTransaksi;
        this.tanggal_transaksi = LocalDate.now();
        this.durasi_kendaraan = 1;
        this.durasi_sopir = 0;
        this.status_transaksi = statusTransaksi.DISEWA;
        this.mobil = null;
        this.penyewa = null;
        this.sopir = null;
        this.pembayaran = new Pembayaran(calculateBiaya());
    }

    public Transaksi(Penyewa penyewa, Mobil mobil, int durasi_kendaraan) {
        countTransaksi++;
        this.ID_transaksi = countTransaksi;
        this.tanggal_transaksi = LocalDate.now();
        this.durasi_kendaraan = durasi_kendaraan;
        this.durasi_sopir = 0;
        this.status_transaksi = statusTransaksi.DISEWA;
        this.mobil = mobil;
        this.penyewa = penyewa;
        this.sopir = null;
        this.pembayaran = new Pembayaran(calculateBiaya());
    }

    public Transaksi(Penyewa penyewa, Mobil mobil, Sopir sopir, int durasi_kendaraan, int durasi_sopir) {
        countTransaksi++;
        this.ID_transaksi = countTransaksi;
        this.tanggal_transaksi = LocalDate.now();
        this.durasi_kendaraan = durasi_kendaraan;
        this.durasi_sopir = durasi_sopir;
        this.status_transaksi = statusTransaksi.DISEWA;
        this.mobil = mobil;
        this.penyewa = penyewa;
        this.sopir = sopir;
        this.pembayaran = new Pembayaran(calculateBiaya());
    }

    // GETTER
    public int getID_transaksi() {
        return ID_transaksi;
    }

    public LocalDate getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public int getDurasi_sopir() {
        return durasi_sopir;
    }

    public int getDurasi_kendaraan() {
        return durasi_kendaraan;
    }

    public statusTransaksi getStatus_transaksi() {
        return status_transaksi;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public Penyewa getPenyewa() {
        return penyewa;
    }

    public Sopir getSopir() {
        return sopir;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public static int getCountTransaksi() {
        return countTransaksi;
    }

    // SETTER
    public void setDurasi_sopir(int durasi_sopir) {
        this.durasi_sopir = durasi_sopir;
        this.pembayaran.setNominal(calculateBiaya());
    }

    public void setDurasi_kendaraan(int durasi_kendaraan) {
        this.durasi_kendaraan = durasi_kendaraan;
        this.pembayaran.setNominal(calculateBiaya());
    }

    public void setStatus_transaksi(statusTransaksi status_transaksi) {
        this.status_transaksi = status_transaksi;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
        this.pembayaran.setNominal(calculateBiaya());
    }

    public void setPenyewa(Penyewa penyewa) {
        this.penyewa = penyewa;
    }

    public void setSopir(Sopir sopir) {
        this.sopir = sopir;
        this.pembayaran.setNominal(calculateBiaya());
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    // METHOD LAIN
    public double calculateBiaya() {
        double biayaKendaraan = durasi_kendaraan * hargaPerHariKendaraan;
        double biayaSopir = durasi_sopir * hargaPerHariSopir;
        return biayaKendaraan + biayaSopir;
    }

    public boolean isActive() {
        return status_transaksi == statusTransaksi.DISEWA;
    }

    public void selesaikanTransaksi() {
        this.status_transaksi = statusTransaksi.SELESAI;
    }

    public void printInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("====== INFORMASI TRANSAKSI ======");
        System.out.println("ID Transaksi: " + ID_transaksi);
        System.out.println("Tanggal: " + tanggal_transaksi.format(formatter));
        System.out.println("Status: " + status_transaksi);
        
        if (penyewa != null) {
            System.out.println("Penyewa: " + penyewa.getName() + " (ID: " + penyewa.getIdPenyewa() + ")");
        } else {
            System.out.println("Penyewa: -");
        }
        
        if (mobil != null) {
            System.out.println("Mobil: " + mobil.getNama() + " (Plat: " + mobil.getID_Plat() + ")");
            System.out.println("Durasi sewa kendaraan: " + durasi_kendaraan + " hari");
        } else {
            System.out.println("Mobil: -");
        }
        
        if (sopir != null) {
            System.out.println("Sopir: " + sopir.getName() + " (ID: " + sopir.getIdSopir() + ")");
            System.out.println("Durasi sewa sopir: " + durasi_sopir + " hari");
        } else {
            System.out.println("Sopir: -");
        }
        
        System.out.println("Total Biaya: Rp " + String.format("%,.2f", pembayaran.getNominal()));
        System.out.println("==============================");
    }
}