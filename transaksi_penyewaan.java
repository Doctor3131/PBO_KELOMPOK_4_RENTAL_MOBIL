
import java.time.LocalDate;

public class transaksi_penyewaan {
    /* ATRIBUT */
    private int ID_transaksi;
    private LocalDate tanggal_transaksi;
    private int durasi_sopir;
    private int durasi_kendaraan;
    private statusTransaksi status_transaksi; // antara Disewa atau Selesai
    private mobil ID_mobil;
    private penyewa ID_penyewa;
    private sopir ID_sopir;
    private pembayaran ID_pembayaran;
    private static int countTransaksi = 0;

    /* METHOD */
    // KONSTRUKTOR
    public transaksi_penyewaan() {
        countTransaksi++;
        this.ID_transaksi = countTransaksi;
        this.tanggal_transaksi = LocalDate.now();
        this.durasi_kendaraan = 1;
        this.durasi_sopir = 0;
        if (tanggal_transaksi == LocalDate.of(tanggal_transaksi., durasi_mobil, durasi_mobil))
        this.status_transaksi.DISEWA;
    }

    public transaksi_penyewaan(int durasi_mobil, int durasi_sopir) {

    }

    // GETTER
    // SETTER
    // METHOD LAIN
}
