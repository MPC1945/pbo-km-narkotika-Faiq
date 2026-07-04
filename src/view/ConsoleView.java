package view;

import model.Putusan;
import model.StatistikPutusan;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ConsoleView – lapisan tampilan (View) dalam arsitektur MVC.
 * Bertanggung jawab menampilkan data kepada pengguna dan menerima input.
 * Tidak mengandung logika bisnis. Semua data diperoleh melalui Controller.
 *
 * @author Nama : Muhammad Razan Daffa Majid Nim : 202510370110021 – GUI Designer
 * @version 1.0
 */

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Menampilkan menu utama dan mengembalikan pilihan pengguna (1–7).
     * @return pilihan menu, -1 jika input tidak valid
     */
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
        System.out.println("[7] Ekspor Statistik ke .txt");
        System.out.println("[8] Keluar");
        System.out.print("Pilih menu (1-8): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Menampilkan daftar semua putusan dalam format tabel.
     * @param daftar ArrayList berisi objek Putusan yang akan ditampilkan
     */
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

    /**
     * Menampilkan detail satu putusan secara lengkap.
     * @param p objek Putusan yang akan ditampilkan detailnya
     */
        public void tampilkanDetail(Putusan p) {
        tampilkanDetail(p, true);
    }

    /**
     * Menampilkan detail satu putusan.
     * @param p objek Putusan
     * @param detail jika true, tampilkan seluruh atribut
     */
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

    /**
     * Menampilkan ringkasan statistik dari objek StatistikPutusan.
     * @param stat objek StatistikPutusan yang berisi hasil perhitungan
     */
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

    /**
     * Menampilkan pesan informatif ke konsol.
     * @param pesan teks yang akan ditampilkan
     */
        public void tampilkanPesan(String pesan) {
        System.out.println("[INFO] " + pesan);
    }

    /**
     * Membaca seluruh data putusan baru dari keyboard.
     * @return array String[12] berisi data mentah untuk dikirim ke Controller
     */
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

    /**
     * Mengembalikan objek Scanner yang digunakan oleh View.
     * @return Scanner
     */
    public Scanner getScanner() {
        return scanner;
    }
}