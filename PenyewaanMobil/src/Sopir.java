public class Sopir {
    private int idSopir;
    private String name;
    private String address;
    private String phoneNumber;
    private static int sopirCount;

    public Sopir() {
        Sopir.sopirCount += 1;
        this.idSopir = sopirCount + 1;
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
    }

    public Sopir(String name, String address, String phoneNumber) {
        Sopir.sopirCount += 1;
        this.idSopir = sopirCount + 1;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getIdSopir() {
        return idSopir;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static int getSopirCount() {
        return sopirCount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
