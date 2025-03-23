import java.util.ArrayList;

public class Penyewa {
    private String idPenyewa;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Transaksi> transactions;
    private static int countPenyewa = 0;

    public Penyewa () {
        countPenyewa += 1;
        this.idPenyewa = "NONE";
        this.name = "NONE";
        this.address = "NONE";
        this.phoneNumber = "NONE";
        this.transactions = new ArrayList<Transaksi>();
    }

    public Penyewa (String idPenyewa, String name, String address, String phoneNumber) {
        countPenyewa += 1;
        this.idPenyewa = idPenyewa;
        this.name = name;
        this.address = address; 
        this.phoneNumber = phoneNumber;
        this.transactions = new ArrayList<Transaksi>();
    }

    public static int countPenyewa() {
        return countPenyewa;
    }

    public String getIdPenyewa() {
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
    
    public void addTransaction(Transaksi transaksi) {
        this.transactions.add(transaksi);
    }

    public ArrayList<Transaksi> getTransactions() {
        return transactions;
    }

    public void showAllTransactions() {
        System.out.println("\n=== DAFTAR TRANSAKSI UNTUK " + name + " ===");
        if (transactions.isEmpty()) {
            System.out.println("Tidak ada transaksi.");
        } else {
            for (Transaksi t : transactions) {
                t.printInfo();
            }
        }
    }

    public void showAllActiveTransactions() {
        System.out.println("\n=== DAFTAR TRANSAKSI AKTIF UNTUK " + name + " ===");
        boolean adaTransaksi = false;
        for (Transaksi t : transactions) {
            if (t.isActive()) {
                t.printInfo();
                adaTransaksi = true;
            }
        }
        if (!adaTransaksi) {
            System.out.println("Tidak ada transaksi aktif.");
        }
    }
}