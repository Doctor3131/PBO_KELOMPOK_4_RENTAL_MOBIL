import java.util.ArrayList;

public class Penyewa {
    private int idPenyewa;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Transaksi> transactions;
    private static int countPenyewa = 0;

    public Penyewa () {
        countPenyewa += 1;
        this.idPenyewa = countPenyewa;
        this.name = "NONE";
        this.address = "NONE";
        this.phoneNumber = "NONE";
        this.transactions = new ArrayList<Transaksi>();
    }

    public Penyewa (String name, String address, String phoneNumber) {
        countPenyewa += 1;
        this.idPenyewa = countPenyewa;
        this.name = name;
        this.address = address; 
        this.phoneNumber = phoneNumber;
        this.transactions = new ArrayList<Transaksi>();
    }

    public int getIdPenyewa() {
        return idPenyewa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void showAllTransactions() {
        for (Transaksi t : transactions ) {
            t.printInfo(); // print info transaksi sebagai method class Transaksi saja
        }
    }

    public void showAllActiveTransactions() {
        for (Transaksi t : transactions ) {
            if (t.isActive()) {
                t.printInfo(); // print info transaksi sebagai method class Transaksi saja
            }
        }
    }
} 
