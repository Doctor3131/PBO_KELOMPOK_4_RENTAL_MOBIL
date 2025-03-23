public class Mobil extends Kendaraan {
    /* ATRIBUT */
    private String nama_mobil;
    private String jenis_mobil;
    private static int countMobil = 0;

    /* METHOD */
    // KOSTRUKTOR
    public Mobil() {
        super();
        countMobil++;
        this.nama_mobil = "-";
        this.jenis_mobil = "-";
    }

    public Mobil(String ID_Plat, String nama_mobil, String jenis_mobil) {
        super(ID_Plat);
        countMobil++;
        this.nama_mobil = nama_mobil;
        this.jenis_mobil = jenis_mobil;
    }

    // GETTER
    public String getNama() {
        return nama_mobil;
    }

    public String getJenis() {
        return jenis_mobil;
    }

    public int getCountMobil() {
        return countMobil;
    }

    // SETTER
    public void setNama(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public void setJenis(String jenis_mobil) {
        this.jenis_mobil = jenis_mobil;
    }
}
