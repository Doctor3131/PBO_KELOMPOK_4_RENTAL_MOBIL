

public class kendaraan {
    /* ATRIBUT */
    private String ID_Plat;
    private static int countKendaraan = 0;
    private static String[] listID_Plat; // untuk me

    /* METHOD */
    // EXCEPTION
    public static void cekID_Plat(String ID) throws ID_PlatException {
        for (String plat : listID_Plat) {
            if (!plat.equals(ID)) {
                throw new ID_PlatException();
            }
            break;
        }
    }

    // KONSTRUKTOR
    public kendaraan() {
        countKendaraan++;
        this.ID_Plat = String.valueOf(countKendaraan);
        listID_Plat[countKendaraan - 1] = ID_Plat;
    }

    public kendaraan(String ID_Plat) {
        countKendaraan++;
        try {
            cekID_Plat(ID_Plat);
        } catch (ID_PlatException tolak) {
            System.out.println(tolak.getMessage());
        }
        listID_Plat[countKendaraan - 1] = ID_Plat;
    }

    // GETTER
    public String getID_Plat() {
        return ID_Plat;
    }

    public int getCountKendaraan() {
        return countKendaraan;
    }

    // SETTER
    public void setID_Plat(String ID_Plat) {
        this.ID_Plat = ID_Plat;
    }

    // METHOD LAIN
}
