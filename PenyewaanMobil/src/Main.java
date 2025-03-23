import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();
    private static ArrayList<Mobil> daftarMobil = new ArrayList<>();
    private static ArrayList<Sopir> daftarSopir = new ArrayList<>();
    private static ArrayList<Motor> daftarMotor = new ArrayList<>();
    private static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize some sample data
        initializeData();
        
        boolean running = true;
        while (running) {
            clearScreen();
            System.out.println("=== SISTEM PENYEWAAN MOBIL ===");
            System.out.println("1. Lihat Daftar Mobil");
            System.out.println("2. Lihat Daftar Motor");
            System.out.println("3. Lihat Daftar Sopir");
            System.out.println("4. Lihat Daftar Penyewa");
            System.out.println("5. Buat Transaksi Baru");
            System.out.println("6. Lihat Semua Transaksi");
            System.out.println("7. Lihat Transaksi Aktif");
            System.out.println("8. Selesaikan Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    showMobil();
                    break;
                case 2:
                    showMotor();
                    break;
                case 3:
                    showSopir();
                    break;
                case 4:
                    showPenyewa();
                    break;
                case 5:
                    createTransaksi();
                    break;
                case 6:
                    showAllTransaksi();
                    break;
                case 7:
                    showActiveTransaksi();
                    break;
                case 8:
                    completeTransaksi();
                    break;
                case 0:
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
        // Add sample mobil (10 cars)
        daftarMobil.add(new Mobil("B1234KL", "Toyota Avanza", "MPV"));
        daftarMobil.add(new Mobil("B2345KL", "Honda Jazz", "Hatchback"));
        daftarMobil.add(new Mobil("B3456KL", "Toyota Fortuner", "SUV"));
        daftarMobil.add(new Mobil("B4567KL", "Honda Civic", "Sedan"));
        daftarMobil.add(new Mobil("B5678KL", "Toyota Alphard", "MPV"));
        daftarMobil.add(new Mobil("B6789KL", "Mitsubishi Pajero", "SUV"));
        daftarMobil.add(new Mobil("B7890KL", "Suzuki Ertiga", "MPV"));
        daftarMobil.add(new Mobil("B8901KL", "Daihatsu Xenia", "MPV"));
        daftarMobil.add(new Mobil("B9012KL", "Toyota Kijang Innova", "MPV"));
        daftarMobil.add(new Mobil("B0123KL", "Honda HR-V", "SUV"));
        
        // Add sample motor (10 motorcycles)
        daftarMotor.add(new Motor("B1234AB", "Honda Beat", "Matic"));
        daftarMotor.add(new Motor("B2345AB", "Yamaha NMAX", "Matic"));
        daftarMotor.add(new Motor("B3456AB", "Honda Vario", "Matic"));
        daftarMotor.add(new Motor("B4567AB", "Yamaha Mio", "Matic"));
        daftarMotor.add(new Motor("B5678AB", "Honda PCX", "Matic"));
        daftarMotor.add(new Motor("B6789AB", "Kawasaki Ninja", "Sport"));
        daftarMotor.add(new Motor("B7890AB", "Yamaha R15", "Sport"));
        daftarMotor.add(new Motor("B8901AB", "Honda CBR", "Sport"));
        daftarMotor.add(new Motor("B9012AB", "Suzuki Satria", "Sport"));
        daftarMotor.add(new Motor("B0123AB", "Yamaha Jupiter", "Bebek"));
        
        // Add sample sopir
        daftarSopir.add(new Sopir("Budi Santoso", "Jl. Pahlawan No. 10", "081234567890"));
        daftarSopir.add(new Sopir("Joko Widodo", "Jl. Merdeka No. 17", "087654321098"));
        daftarSopir.add(new Sopir("Agus Harimurti", "Jl. Sudirman No. 55", "089876543210"));
        daftarSopir.add(new Sopir("Rudi Hartono", "Jl. Diponegoro No. 12", "081122334455"));
        daftarSopir.add(new Sopir("Bambang Pamungkas", "Jl. Thamrin No. 7", "082233445566"));
        
        
        // Add sample penyewa
        daftarPenyewa.add(new Penyewa("3374238490842","Andi Saputra", "Jl. Kenanga No. 5", "089876543210"));
        daftarPenyewa.add(new Penyewa("23742472378","Dewi Lestari", "Jl. Mawar No. 7", "082345678901"));
    }
    
    // private static void showMobil() {
    //     clearScreen();
    //     System.out.println("=== DAFTAR MOBIL ===");
    //     if (daftarMobil.isEmpty()) {
    //         System.out.println("Tidak ada mobil yang tersedia.");
    //     } else {
    //         for (int i = 0; i < daftarMobil.size(); i++) {
    //             Mobil m = daftarMobil.get(i);
    //             System.out.println((i + 1) + ". " + m.getNama() + " (" + m.getJenis() + ") - Plat: " + m.getID_Plat());
    //         }
    //     }
    //     waitForEnter();
    // }

    // private static void showMotor() {
    //     clearScreen();
    //     System.out.println("=== DAFTAR MOTOR ===");
    //     if (daftarMotor.isEmpty()) {
    //         System.out.println("Tidak ada motor yang tersedia.");
    //     } else {
    //         for (int i = 0; i < daftarMotor.size(); i++) {
    //             Motor m = daftarMotor.get(i);
    //             System.out.println((i + 1) + ". " + m.getNama() + " (" + m.getJenis() + ") - Plat: " + m.getID_Plat());
    //         }
    //     }
    //     waitForEnter();
    // }

    // private static void showSopir() {
    //     clearScreen();
    //     System.out.println("=== DAFTAR SOPIR ===");
    //     if (daftarSopir.isEmpty()) {
    //         System.out.println("Tidak ada sopir yang tersedia.");
    //     } else {
    //         for (int i = 0; i < daftarSopir.size(); i++) {
    //             Sopir s = daftarSopir.get(i);
    //             System.out.println((i + 1) + ". " + s.getName() + " - Telepon: " + s.getPhoneNumber());
    //         }
    //     }
    //     waitForEnter();
    // }
    

    private static boolean cekDisewa(String platID) {
        for (Transaksi t : daftarTransaksi) {
            if (t.isActive()) {
                if (t.getMobil() != null && t.getMobil().getID_Plat().equals(platID)) {
                    return true;
                }
                
                if (t.getMotor() != null && t.getMotor().getID_Plat().equals(platID)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean cekDisewa(int sopirID) {
        for (Transaksi t : daftarTransaksi) {
            if (t.isActive() && t.getSopir() != null && t.getSopir().getIdSopir() == sopirID) {
                return true;
            }
        }
        return false;
    }

    private static void showMobil() {
        clearScreen();
        System.out.println("=== DAFTAR MOBIL ===");
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil yang tersedia.");
        } else {
            System.out.println("No. | ID Plat  | Nama Mobil          | Jenis      | Status");
            System.out.println("-----------------------------------------------------------");
            int i = 1;
            for (Mobil m : daftarMobil) {
                String status = cekDisewa(m.getID_Plat()) ? "Disewa" : "Tersedia";
                System.out.printf("%-3d | %-8s | %-20s | %-10s | %s%n", 
                                 i++, m.getID_Plat(), m.getNama(), m.getJenis(), status);
            }
        }
        waitForEnter();
    }
    
    private static void showMotor() {
        clearScreen();
        System.out.println("=== DAFTAR MOTOR ===");
        if (daftarMotor.isEmpty()) {
            System.out.println("Tidak ada motor yang tersedia.");
        } else {
            System.out.println("No. | ID Plat  | Nama Motor          | Jenis      | Status");
            System.out.println("-----------------------------------------------------------");
            int i = 1;
            for (Motor m : daftarMotor) {
                String status = cekDisewa(m.getID_Plat()) ? "Disewa" : "Tersedia";
                System.out.printf("%-3d | %-8s | %-20s | %-10s | %s%n", 
                                 i++, m.getID_Plat(), m.getNama(), m.getJenis(), status);
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
            System.out.println("No. | ID | Nama               | Telepon        | Status");
            System.out.println("----------------------------------------------------------");
            int i = 1;
            for (Sopir s : daftarSopir) {
                String status = cekDisewa(s.getIdSopir()) ? "Disewa" : "Tersedia";
                System.out.printf("%-3d | %-2d | %-18s | %-14s | %s%n", 
                                 i++, s.getIdSopir(), s.getName(), s.getPhoneNumber(), status);
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
    
    // private static void createTransaksi() {
    //     clearScreen();
    //     System.out.println("=== BUAT TRANSAKSI BARU ===");
        
    //     if (daftarPenyewa.isEmpty() || daftarMobil.isEmpty()) {
    //         System.out.println("Tidak dapat membuat transaksi. Pastikan ada penyewa dan mobil yang terdaftar.");
    //         waitForEnter();
    //         return;
    //     }
        
    //     System.out.println("\nPilih Penyewa:");
    //     for (int i = 0; i < daftarPenyewa.size(); i++) {
    //         System.out.println((i + 1) + ". " + daftarPenyewa.get(i).getName());
    //     }
    //     System.out.print("Pilihan (1-" + daftarPenyewa.size() + "): ");
    //     int penyewaChoice = getIntInput() - 1;
        
    //     if (penyewaChoice < 0 || penyewaChoice >= daftarPenyewa.size()) {
    //         System.out.println("Pilihan tidak valid!");
    //         waitForEnter();
    //         return;
    //     }
        
    //     Penyewa selectedPenyewa = daftarPenyewa.get(penyewaChoice);
        
    //     System.out.println("\nPilih Mobil:");
    //     for (int i = 0; i < daftarMobil.size(); i++) {
    //         System.out.println((i + 1) + ". " + daftarMobil.get(i).getNama() + " (" + daftarMobil.get(i).getJenis() + ")");
    //     }
    //     System.out.print("Pilihan (1-" + daftarMobil.size() + "): ");
    //     int mobilChoice = getIntInput() - 1;
        
    //     if (mobilChoice < 0 || mobilChoice >= daftarMobil.size()) {
    //         System.out.println("Pilihan tidak valid!");
    //         waitForEnter();
    //         return;
    //     }
        
    //     Mobil selectedMobil = daftarMobil.get(mobilChoice);
        
    //     System.out.print("\nMasukkan durasi sewa kendaraan (hari): ");
    //     int durasiKendaraan = getIntInput();
        
    //     if (durasiKendaraan <= 0) {
    //         System.out.println("Durasi sewa tidak valid!");
    //         waitForEnter();
    //         return;
    //     }
        
    //     System.out.print("\nApakah membutuhkan sopir? (y/n): ");
    //     String needSopir = scanner.next().toLowerCase();
        
    //     Transaksi transaksi;
        
    //     if (needSopir.equals("y") && !daftarSopir.isEmpty()) {
    //         System.out.println("\nPilih Sopir:");
    //         for (int i = 0; i < daftarSopir.size(); i++) {
    //             System.out.println((i + 1) + ". " + daftarSopir.get(i).getName());
    //         }
    //         System.out.print("Pilihan (1-" + daftarSopir.size() + "): ");
    //         int sopirChoice = getIntInput() - 1;
            
    //         if (sopirChoice < 0 || sopirChoice >= daftarSopir.size()) {
    //             System.out.println("Pilihan tidak valid!");
    //             waitForEnter();
    //             return;
    //         }
            
    //         Sopir selectedSopir = daftarSopir.get(sopirChoice);
            
    //         System.out.print("\nMasukkan durasi sewa sopir (hari): ");
    //         int durasiSopir = getIntInput();
            
    //         if (durasiSopir <= 0 || durasiSopir > durasiKendaraan) {
    //             System.out.println("Durasi sewa sopir tidak valid atau melebihi durasi sewa kendaraan!");
    //             waitForEnter();
    //             return;
    //         }
            
    //         transaksi = new Transaksi(selectedPenyewa, selectedMobil, selectedSopir, durasiKendaraan, durasiSopir);
    //     } else {
    //         transaksi = new Transaksi(selectedPenyewa, selectedMobil, durasiKendaraan);
    //     }
        
    //     daftarTransaksi.add(transaksi);
    //     selectedPenyewa.addTransaction(transaksi);
        
    //     System.out.println("\nTransaksi berhasil dibuat!");
    //     transaksi.printInfo();
        
    //     waitForEnter();
    // }

    
    private static void addPenyewa() {
        clearScreen();
        System.out.println("=== TAMBAH PENYEWA BARU ===");
        
        scanner.nextLine(); 

        System.out.print("Masukkan NIK: ");
        String nik = scanner.nextLine();
        
        for (Penyewa p : daftarPenyewa) {
            if (p.getIdPenyewa().equals(nik)) {
                System.out.println("Penyewa dengan NIK tersebut sudah terdaftar!");
                waitForEnter();
                return;
            }
        }
        
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();
        
        System.out.print("Masukkan Nomor Telepon: ");
        String telepon = scanner.nextLine();
        
        Penyewa penyewaBaru = new Penyewa(nik, nama, alamat, telepon);
        daftarPenyewa.add(penyewaBaru);
        
        System.out.println("\nPenyewa baru berhasil ditambahkan!");
        waitForEnter();
    }


    private static void createTransaksi() {
        int MAX_RENTAL_DAYS = 15;
        clearScreen();
        System.out.println("=== BUAT TRANSAKSI BARU ===");
        
        if (daftarPenyewa.isEmpty()) {
            System.out.println("Tidak dapat membuat transaksi. Tidak ada penyewa yang terdaftar.");
            waitForEnter();
            return;
        }
        
        System.out.println("Penyewa baru?[y/n] ");
        String penyewaBaru = scanner.next().toLowerCase();

        if (penyewaBaru.equals(penyewaBaru)) {
            addPenyewa();
        }

        System.out.println("\nPilih Penyewa:");
        for (int i = 0; i < daftarPenyewa.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPenyewa.get(i).getName() + " (NIK: " + daftarPenyewa.get(i).getIdPenyewa() + ")");
        }
        System.out.print("Pilihan (1-" + daftarPenyewa.size() + "): ");
        int penyewaChoice = getIntInput() - 1;
        
        if (penyewaChoice < 0 || penyewaChoice >= daftarPenyewa.size()) {
            System.out.println("Pilihan tidak valid!");
            waitForEnter();
            return;
        }
        
        Penyewa selectedPenyewa = daftarPenyewa.get(penyewaChoice);
        
        System.out.println("\nPilih jenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.print("Pilihan (1-2): ");
        int vehicleTypeChoice = getIntInput();
        
        if (vehicleTypeChoice != 1 && vehicleTypeChoice != 2) {
            System.out.println("Pilihan tidak valid!");
            waitForEnter();
            return;
        }
        
        Transaksi transaksi = null;
        
        if (vehicleTypeChoice == 1) {
            // Mobil
            ArrayList<Mobil> availableMobil = new ArrayList<>();
            for (Mobil m : daftarMobil) {
                if (!cekDisewa(m.getID_Plat())) {
                    availableMobil.add(m);
                }
            }
            
            if (availableMobil.isEmpty()) {
                System.out.println("Tidak ada mobil yang tersedia saat ini.");
                waitForEnter();
                return;
            }
            
            System.out.println("\nPilih Mobil:");
            for (int i = 0; i < availableMobil.size(); i++) {
                Mobil m = availableMobil.get(i);
                System.out.println((i + 1) + ". " + m.getNama() + " (" + m.getJenis() + ") - Plat: " + m.getID_Plat());
            }
            System.out.print("Pilihan (1-" + availableMobil.size() + "): ");
            int mobilChoice = getIntInput() - 1;
            
            if (mobilChoice < 0 || mobilChoice >= availableMobil.size()) {
                System.out.println("Pilihan tidak valid!");
                waitForEnter();
                return;
            }
            
            Mobil selectedMobil = availableMobil.get(mobilChoice);
            
            System.out.print("\nMasukkan durasi sewa kendaraan (hari, max " + MAX_RENTAL_DAYS + "): ");
            int durasiKendaraan = getIntInput();
            
            if (durasiKendaraan <= 0 || durasiKendaraan > MAX_RENTAL_DAYS) {
                System.out.println("Durasi sewa tidak valid! Maksimal " + MAX_RENTAL_DAYS + " hari.");
                waitForEnter();
                return;
            }
            
            System.out.print("\nApakah membutuhkan sopir? (y/n): ");
            String needSopir = scanner.next().toLowerCase();
            
            if (needSopir.equals("y")) {
                ArrayList<Sopir> availableSopir = new ArrayList<>();
                for (Sopir s : daftarSopir) {
                    if (!cekDisewa(s.getIdSopir())) {
                        availableSopir.add(s);
                    }
                }
                
                if (availableSopir.isEmpty()) {
                    System.out.println("Tidak ada sopir yang tersedia saat ini.");
                    System.out.println("Transaksi akan dibuat tanpa sopir.");
                    transaksi = new Transaksi(selectedPenyewa, selectedMobil, durasiKendaraan);
                } else {
                    System.out.println("\nPilih Sopir:");
                    for (int i = 0; i < availableSopir.size(); i++) {
                        Sopir s = availableSopir.get(i);
                        System.out.println((i + 1) + ". " + s.getName() + " - Telepon: " + s.getPhoneNumber());
                    }
                    System.out.print("Pilihan (1-" + availableSopir.size() + "): ");
                    int sopirChoice = getIntInput() - 1;
                    
                    if (sopirChoice < 0 || sopirChoice >= availableSopir.size()) {
                        System.out.println("Pilihan tidak valid!");
                        waitForEnter();
                        return;
                    }
                    
                    Sopir selectedSopir = availableSopir.get(sopirChoice);
                    
                    System.out.print("\nMasukkan durasi sewa sopir (hari, max " + durasiKendaraan + "): ");
                    int durasiSopir = getIntInput();
                    
                    if (durasiSopir <= 0 || durasiSopir > durasiKendaraan || durasiSopir > MAX_RENTAL_DAYS) {
                        System.out.println("Durasi sewa sopir tidak valid atau melebihi durasi sewa kendaraan!");
                        waitForEnter();
                        return;
                    }
                    
                    transaksi = new Transaksi(selectedPenyewa, selectedMobil, selectedSopir, durasiKendaraan, durasiSopir);
                }
            } else {
                transaksi = new Transaksi(selectedPenyewa, selectedMobil, durasiKendaraan);
            }
        } else if (vehicleTypeChoice == 2) {
            // Motor
            ArrayList<Motor> availableMotor = new ArrayList<>();
            for (Motor m : daftarMotor) {
                if (!cekDisewa(m.getID_Plat())) {
                    availableMotor.add(m);
                }
            }
            
            if (availableMotor.isEmpty()) {
                System.out.println("Tidak ada motor yang tersedia saat ini.");
                waitForEnter();
                return;
            }
            
            System.out.println("\nPilih Motor:");
            for (int i = 0; i < availableMotor.size(); i++) {
                Motor m = availableMotor.get(i);
                System.out.println((i + 1) + ". " + m.getNama() + " (" + m.getJenis() + ") - Plat: " + m.getID_Plat());
            }
            System.out.print("Pilihan (1-" + availableMotor.size() + "): ");
            int motorChoice = getIntInput() - 1;
            
            if (motorChoice < 0 || motorChoice >= availableMotor.size()) {
                System.out.println("Pilihan tidak valid!");
                waitForEnter();
                return;
            }
            
            Motor selectedMotor = availableMotor.get(motorChoice);
            
            System.out.print("\nMasukkan durasi sewa kendaraan (hari, max " + MAX_RENTAL_DAYS + "): ");
            int durasiKendaraan = getIntInput();
            
            if (durasiKendaraan <= 0 || durasiKendaraan > MAX_RENTAL_DAYS) {
                System.out.println("Durasi sewa tidak valid! Maksimal " + MAX_RENTAL_DAYS + " hari.");
                waitForEnter();
                return;
            }
            
            transaksi = new Transaksi(selectedPenyewa, selectedMotor, durasiKendaraan);
        }
        
        if (transaksi != null) {
            daftarTransaksi.add(transaksi);
            System.out.println("\nTransaksi berhasil dibuat!");
            transaksi.printInfo();
            
            System.out.print("\nProses pembayaran sekarang? (y/n): ");
            String processPayment = scanner.next().toLowerCase();
            
            if (processPayment.equals("y")) {
                System.out.println("\nPilih metode pembayaran:");
                System.out.println("1. Tunai");
                System.out.println("2. Non-Tunai");
                System.out.print("Pilihan (1-2): ");
                int paymentMethod = getIntInput();
                
                if (paymentMethod == 1) {
                    // Cash payment
                    System.out.println("Pembayaran tunai sebesar Rp " + String.format("%,.2f", transaksi.getPembayaran().getNominal()) + " diterima.");
                } else if (paymentMethod == 2) {
                    // Non-cash payment
                    System.out.print("Masukkan nomor resi bank: ");
                    scanner.nextLine(); // Clear buffer
                    String resiBank = scanner.nextLine();
                    
                    PembayaranNonTunai pembayaranNonTunai = new PembayaranNonTunai(transaksi.getPembayaran().getNominal(), resiBank);
                    transaksi.setPembayaran(pembayaranNonTunai);
                    
                    System.out.println("Pembayaran non-tunai berhasil diproses.");
                    pembayaranNonTunai.showIdPembayaran();
                } else {
                    System.out.println("Pilihan metode pembayaran tidak valid!");
                }
            }
        }
        
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
