package view;

import model.Putusan;
import model.StatistikPutusan;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

        public int tampilkanMenu() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("   KMS PUTUSAN PENGADILAN NARKOTIKA   ");
        System.out.println("═══════════════════════════════════════");
        System.out.println("[1] Tambah Putusan Baru");
        System.out.println("[2] Lihat Semua Putusan");
        System.out.println("[3] Cari Putusan");
        System.out.println("[4] Filter Putusan");
        System.out.println("[5] Tampilkan Statistik");
        System.out.println("[6] Hapus Putusan");
        System.out.println("[7] Keluar");
        System.out.print("Pilih menu (1-7): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

            public void tampilkanDaftarPutusan(ArrayList<Putusan> daftar) {
        if (daftar.isEmpty()) {
            System.out.println("\n>>> Belum ada data putusan. <<<");
            return;
        }
        System.out.println("\n--- DAFTAR PUTUSAN ---");
        String formatHeader = "%-4s %-30s %-22s %-10s %-15s%n";
        String formatRow    = "%-4d %-30s %-22s %-10d Rp%,-15.0f%n";
        String header = String.format(formatHeader, "No", "Nomor Perkara", "Nama Terdakwa", "Vonis(bln)", "Denda(Rp)");
        System.out.print(header);
        System.out.println("─".repeat(header.length()));  // garis bawah header
        int no = 1;
        for (Putusan p : daftar) {
            System.out.printf(formatRow, no++, p.getNomorPerkara(), p.getNamaTerdakwa(),
                    p.getVonisHukuman(), p.getVonisDenda());
        }
        System.out.println("Total: " + daftar.size() + " putusan\n");
    }

        public void tampilkanDetail(Putusan p) {
        tampilkanDetail(p, true);
    }

    public void tampilkanDetail(Putusan p, boolean detail) {
        if (p == null) {
            System.out.println(">>> Data tidak ditemukan. <<<");
            return;
        }
        System.out.println("\n===== DETAIL PUTUSAN =====");
        System.out.println("Nomor Perkara    : " + p.getNomorPerkara());
        System.out.println("Pengadilan       : " + p.getPengadilan());
        System.out.println("Tanggal Putusan  : " + p.getTanggalPutusan());
        System.out.println("Nama Terdakwa    : " + p.getNamaTerdakwa());
        System.out.println("Umur             : " + p.getUmurTerdakwa() + " tahun");
        System.out.println("Jenis Narkotika  : " + p.getJenisNarkotika());
        System.out.println("Berat Barang Bukti: " + p.getBeratBarangBukti() + " gram");
        System.out.println("Pasal Dilanggar  : " + p.getPasalDilanggar());
        System.out.println("Peran            : " + p.getPeranTerdakwa());
        System.out.println("Vonis Hukuman    : " + p.getVonisHukuman() + " bulan");
        System.out.println("Vonis Denda      : Rp " + String.format("%,.0f", p.getVonisDenda()));
        System.out.println("Hakim Ketua      : " + p.getNamaHakim());
        System.out.println("=============================\n");
    }

        public void tampilkanStatistik(StatistikPutusan stat) {
        System.out.println("\n======= STATISTIK PUTUSAN =======");
        System.out.println("Total Putusan          : " + stat.getTotalPutusan());
        System.out.println("Rata-rata Vonis        : " + String.format("%.2f", stat.getRataRataVonis()) + " bulan");
        System.out.println("Rata-rata Denda        : Rp " + String.format("%,.2f", stat.getRataRataDenda()));
        System.out.println("Narkotika Terbanyak    : " + stat.getJenisNarkotikaTerbanyak());
        System.out.println("Distribusi Peran       : ");
        for (String peran : stat.getDistribusiPeran()) {
            System.out.println("   - " + peran);
        }
        System.out.println("=================================\n");
    }

        public void tampilkanPesan(String pesan) {
        System.out.println("[INFO] " + pesan);
    }

        public String[] inputFormPutusan() {
        String[] data = new String[12];
        System.out.println("\n--- FORM INPUT PUTUSAN BARU ---");
        System.out.print("Nomor Perkara      : "); data[0] = scanner.nextLine();
        System.out.print("Nama Terdakwa      : "); data[1] = scanner.nextLine();
        System.out.print("Pengadilan         : "); data[2] = scanner.nextLine();
        System.out.print("Tanggal Putusan    : "); data[3] = scanner.nextLine();
        System.out.print("Umur Terdakwa      : "); data[4] = scanner.nextLine();
        System.out.print("Jenis Narkotika    : "); data[5] = scanner.nextLine();
        System.out.print("Berat (gram)       : "); data[6] = scanner.nextLine();
        System.out.print("Pasal Dilanggar    : "); data[7] = scanner.nextLine();
        System.out.print("Peran Terdakwa     : "); data[8] = scanner.nextLine();
        System.out.print("Vonis Hukuman (bln): "); data[9] = scanner.nextLine();
        System.out.print("Vonis Denda (Rp)   : "); data[10] = scanner.nextLine();
        System.out.print("Nama Hakim         : "); data[11] = scanner.nextLine();
        return data;
    }

    public Scanner getScanner() {
        return scanner;
    }
}