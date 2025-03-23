public class Kendaraan {
    /* ATRIBUT */
    private String ID_Plat;
    private static int countKendaraan = 0;
    private static String[] listID_Plat = new String[100]; // Initialize with capacity for 100 vehicles

    /* METHOD */
    // EXCEPTION
    public static void cekID_Plat(String ID) throws ID_PlatException {
        for (int i = 0; i < countKendaraan; i++) {
            if (listID_Plat[i] != null && listID_Plat[i].equals(ID)) {
                throw new ID_PlatException();
            }
        }
    }

    // KONSTRUKTOR
    public Kendaraan() {
        countKendaraan++;
        this.ID_Plat = String.valueOf(countKendaraan);
        listID_Plat[countKendaraan - 1] = ID_Plat;
    }

    public Kendaraan(String ID_Plat) {
        countKendaraan++;
        this.ID_Plat = ID_Plat;
        try {
            cekID_Plat(ID_Plat);
            listID_Plat[countKendaraan - 1] = ID_Plat;
        } catch (ID_PlatException tolak) {
            System.out.println(tolak.getMessage());
            this.ID_Plat = String.valueOf(countKendaraan);
            listID_Plat[countKendaraan - 1] = this.ID_Plat;
        }
    }

    // GETTER
    public String getID_Plat() {
        return ID_Plat;
    }

    public static int getCountKendaraan() {
        return countKendaraan;
    }

    // SETTER
    public void setID_Plat(String ID_Plat) {
        try {
            cekID_Plat(ID_Plat);
            this.ID_Plat = ID_Plat;
            // Update the list
            for (int i = 0; i < countKendaraan; i++) {
                if (listID_Plat[i] != null && listID_Plat[i].equals(this.ID_Plat)) {
                    listID_Plat[i] = ID_Plat;
                    break;
                }
            }
        } catch (ID_PlatException tolak) {
            System.out.println(tolak.getMessage());
        }
    }
}