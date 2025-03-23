
import java.time.LocalDate;

public class Transaksi {
    /* ATRIBUT */
    private int ID_transaksi;
    private LocalDate tanggal_transaksi;
    private int durasi_sopir;
    private int durasi_kendaraan;
    private statusTransaksi status_transaksi; // antara Disewa atau Selesai
    private Mobil ID_mobil;
    private Penyewa ID_penyewa;
    private Sopir ID_sopir;
    private Pembayaran ID_pembayaran;
    private static int countTransaksi = 0;

    /* METHOD */
    // KONSTRUKTOR
    public Transaksi() {
        countTransaksi++;
        this.ID_transaksi = countTransaksi;
        this.tanggal_transaksi = LocalDate.now();
        this.durasi_kendaraan = 1;
        this.durasi_sopir = 0;
        if (tanggal_transaksi == LocalDate.of(tanggal_transaksi., durasi_mobil, durasi_mobil))
            status_transaksi = statusTransaksi.DISEWA;
    }

    public Transaksi(int durasi_mobil, int durasi_sopir) {

    }

    // GETTER
    // SETTER
    // METHOD LAIN
}
