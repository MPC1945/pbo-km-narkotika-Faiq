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
    }

    public void tampilkanDetail(Putusan p) {
    }

    public void tampilkanDetail(Putusan p, boolean detail) {
    }

    public void tampilkanStatistik(StatistikPutusan stat) {
    }

        public void tampilkanPesan(String pesan) {
        System.out.println("[INFO] " + pesan);
    }

    public String[] inputFormPutusan() {
        return new String[12];
    }

    public Scanner getScanner() {
        return scanner;
    }
}