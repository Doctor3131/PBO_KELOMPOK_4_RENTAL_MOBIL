public class Motor extends kendaraan {
    /* ATRIBUT */
    private String nama_motor;
    private String jenis_motor;

    /* METHOD */
    // KONSTRUKTOR
    public Motor() {
        super();
        this.nama_motor = "-";
        this.jenis_motor = "-";
    }

    public Motor(String ID_Plat, String nama_motor, String jenis_motor) {
        super(ID_Plat);
        this.nama_motor = nama_motor;
        this.jenis_motor = jenis_motor;
    }

    // GETTER
    public String getNama() {
        return nama_motor;
    }

    public String getJenis() {
        return jenis_motor;
    }

    // SETTER
    public void setNama(String nama_motor) {
        this.nama_motor = nama_motor;
    }

    public void setJenis(String jenis_motor) {
        this.jenis_motor = jenis_motor;
    }
    
}
