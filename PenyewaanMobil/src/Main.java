import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();
    private static ArrayList<Mobil> daftarMobil = new ArrayList<>();
    private static ArrayList<Sopir> daftarSopir = new ArrayList<>();
    private static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize some sample data
        initializeData();
        
        boolean running = true;
        while (running) {
            clearScreen();
            System.out.println("=== SISTEM PENYEWAAN MOBIL ===");
            System.out.println("1. Lihat Daftar Mobil");
            System.out.println("2. Lihat Daftar Sopir");
            System.out.println("3. Lihat Daftar Penyewa");
            System.out.println("4. Buat Transaksi Baru");
            System.out.println("5. Lihat Semua Transaksi");
            System.out.println("6. Lihat Transaksi Aktif");
            System.out.println("7. Selesaikan Transaksi");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    showMobil();
                    break;
                case 2:
                    showSopir();
                    break;
                case 3:
                    showPenyewa();
                    break;
                case 4:
                    createTransaksi();
                    break;
                case 5:
                    showAllTransaksi();
                    break;
                case 6:
                    showActiveTransaksi();
                    break;
                case 7:
                    completeTransaksi();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    waitForEnter();
            }
        }
        
        System.out.println("Terima kasih telah menggunakan sistem penyewaan mobil!");
    }
    
    private static void initializeData() {
        // Add sample mobil
        daftarMobil.add(new Mobil("Toyota Avanza", "MPV"));
        daftarMobil.add(new Mobil("Honda Jazz", "Hatchback"));
        daftarMobil.add(new Mobil("Toyota Fortuner", "SUV"));
        
        // Add sample sopir
        daftarSopir.add(new Sopir("Budi Santoso", "Jl. Pahlawan No. 10", "081234567890"));
        daftarSopir.add(new Sopir("Joko Widodo", "Jl. Merdeka No. 17", "087654321098"));
        
        // Add sample penyewa
        daftarPenyewa.add(new Penyewa("Andi Saputra", "Jl. Kenanga No. 5", "089876543210"));
        daftarPenyewa.add(new Penyewa("Dewi Lestari", "Jl. Mawar No. 7", "082345678901"));
    }
    
    private static void showMobil() {
        clearScreen();
        System.out.println("=== DAFTAR MOBIL ===");
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil yang tersedia.");
        } else {
            for (int i = 0; i < daftarMobil.size(); i++) {
                Mobil m = daftarMobil.get(i);
                System.out.println((i + 1) + ". " + m.getNama() + " (" + m.getJenis() + ") - Plat: " + m.getID_Plat());
            }
        }
        waitForEnter();
    }
    
    private static void showSopir() {
        clearScreen();
        System.out.println("=== DAFTAR SOPIR ===");
        if (daftarSopir.isEmpty()) {
            System.out.println("Tidak ada sopir yang tersedia.");
        } else {
            for (int i = 0; i < daftarSopir.size(); i++) {
                Sopir s = daftarSopir.get(i);
                System.out.println((i + 1) + ". " + s.getName() + " - Telepon: " + s.getPhoneNumber());
            }
        }
        waitForEnter();
    }
    
    private static void showPenyewa() {
        clearScreen();
        System.out.println("=== DAFTAR PENYEWA ===");
        if (daftarPenyewa.isEmpty()) {
            System.out.println("Tidak ada penyewa yang terdaftar.");
        } else {
            for (int i = 0; i < daftarPenyewa.size(); i++) {
                Penyewa p = daftarPenyewa.get(i);
                System.out.println((i + 1) + ". " + p.getName() + " - Telepon: " + p.getPhoneNumber());
            }
        }
        waitForEnter();
    }
    
    private static void createTransaksi() {
        clearScreen();
        System.out.println("=== BUAT TRANSAKSI BARU ===");
        
        if (daftarPenyewa.isEmpty() || daftarMobil.isEmpty()) {
            System.out.println("Tidak dapat membuat transaksi. Pastikan ada penyewa dan mobil yang terdaftar.");
            waitForEnter();
            return;
        }
        
        System.out.println("\nPilih Penyewa:");
        for (int i = 0; i < daftarPenyewa.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPenyewa.get(i).getName());
        }
        System.out.print("Pilihan (1-" + daftarPenyewa.size() + "): ");
        int penyewaChoice = getIntInput() - 1;
        
        if (penyewaChoice < 0 || penyewaChoice >= daftarPenyewa.size()) {
            System.out.println("Pilihan tidak valid!");
            waitForEnter();
            return;
        }
        
        Penyewa selectedPenyewa = daftarPenyewa.get(penyewaChoice);
        
        System.out.println("\nPilih Mobil:");
        for (int i = 0; i < daftarMobil.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMobil.get(i).getNama() + " (" + daftarMobil.get(i).getJenis() + ")");
        }
        System.out.print("Pilihan (1-" + daftarMobil.size() + "): ");
        int mobilChoice = getIntInput() - 1;
        
        if (mobilChoice < 0 || mobilChoice >= daftarMobil.size()) {
            System.out.println("Pilihan tidak valid!");
            waitForEnter();
            return;
        }
        
        Mobil selectedMobil = daftarMobil.get(mobilChoice);
        
        System.out.print("\nMasukkan durasi sewa kendaraan (hari): ");
        int durasiKendaraan = getIntInput();
        
        if (durasiKendaraan <= 0) {
            System.out.println("Durasi sewa tidak valid!");
            waitForEnter();
            return;
        }
        
        System.out.print("\nApakah membutuhkan sopir? (y/n): ");
        String needSopir = scanner.next().toLowerCase();
        
        Transaksi transaksi;
        
        if (needSopir.equals("y") && !daftarSopir.isEmpty()) {
            System.out.println("\nPilih Sopir:");
            for (int i = 0; i < daftarSopir.size(); i++) {
                System.out.println((i + 1) + ". " + daftarSopir.get(i).getName());
            }
            System.out.print("Pilihan (1-" + daftarSopir.size() + "): ");
            int sopirChoice = getIntInput() - 1;
            
            if (sopirChoice < 0 || sopirChoice >= daftarSopir.size()) {
                System.out.println("Pilihan tidak valid!");
                waitForEnter();
                return;
            }
            
            Sopir selectedSopir = daftarSopir.get(sopirChoice);
            
            System.out.print("\nMasukkan durasi sewa sopir (hari): ");
            int durasiSopir = getIntInput();
            
            if (durasiSopir <= 0 || durasiSopir > durasiKendaraan) {
                System.out.println("Durasi sewa sopir tidak valid atau melebihi durasi sewa kendaraan!");
                waitForEnter();
                return;
            }
            
            transaksi = new Transaksi(selectedPenyewa, selectedMobil, selectedSopir, durasiKendaraan, durasiSopir);
        } else {
            transaksi = new Transaksi(selectedPenyewa, selectedMobil, durasiKendaraan);
        }
        
        daftarTransaksi.add(transaksi);
        selectedPenyewa.addTransaction(transaksi);
        
        System.out.println("\nTransaksi berhasil dibuat!");
        transaksi.printInfo();
        
        waitForEnter();
    }
    
    private static void showAllTransaksi() {
        clearScreen();
        System.out.println("=== SEMUA TRANSAKSI ===");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi.");
        } else {
            for (Transaksi t : daftarTransaksi) {
                t.printInfo();
            }
        }
        waitForEnter();
    }
    
    private static void showActiveTransaksi() {
        clearScreen();
        System.out.println("=== TRANSAKSI AKTIF ===");
        boolean adaTransaksi = false;
        for (Transaksi t : daftarTransaksi) {
            if (t.isActive()) {
                t.printInfo();
                adaTransaksi = true;
            }
        }
        if (!adaTransaksi) {
            System.out.println("Tidak ada transaksi aktif.");
        }
        waitForEnter();
    }
    
    private static void completeTransaksi() {
        clearScreen();
        System.out.println("=== SELESAIKAN TRANSAKSI ===");
        
        ArrayList<Transaksi> activeTransaksi = new ArrayList<>();
        for (Transaksi t : daftarTransaksi) {
            if (t.isActive()) {
                activeTransaksi.add(t);
            }
        }
        
        if (activeTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi aktif yang dapat diselesaikan.");
            waitForEnter();
            return;
        }
        
        System.out.println("Transaksi Aktif:");
        for (int i = 0; i < activeTransaksi.size(); i++) {
            Transaksi t = activeTransaksi.get(i);
            System.out.println((i + 1) + ". ID: " + t.getID_transaksi() + " - Penyewa: " + 
                               t.getPenyewa().getName() + " - Mobil: " + t.getMobil().getNama());
        }
        
        System.out.print("Pilih transaksi yang akan diselesaikan (1-" + activeTransaksi.size() + "): ");
        int choice = getIntInput() - 1;
        
        if (choice < 0 || choice >= activeTransaksi.size()) {
            System.out.println("Pilihan tidak valid!");
            waitForEnter();
            return;
        }
        
        Transaksi selectedTransaksi = activeTransaksi.get(choice);
        
        selectedTransaksi.selesaikanTransaksi();
        
        System.out.println("\nTransaksi berhasil diselesaikan!");
        selectedTransaksi.printInfo();
        
        System.out.print("\nApakah pembayaran akan dilakukan secara non-tunai? (y/n): ");
        String nonTunai = scanner.next().toLowerCase();
        
        if (nonTunai.equals("y")) {
            System.out.print("Masukkan nomor resi bank: ");
            scanner.nextLine(); 
            String resiBank = scanner.nextLine();
            
            PembayaranNonTunai pembayaranNonTunai = new PembayaranNonTunai(
                selectedTransaksi.getPembayaran().getNominal(), resiBank);
            
            selectedTransaksi.setPembayaran(pembayaranNonTunai);
            System.out.println("\nPembayaran non-tunai berhasil dicatat.");
            pembayaranNonTunai.showIdPembayaran();
        }
        
        waitForEnter();
    }
    
    private static int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();  
                System.out.print("Input tidak valid. Masukkan angka: ");
            }
        }
    }
    
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private static void waitForEnter() {
        System.out.println("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();  
        scanner.nextLine();  
    }
}