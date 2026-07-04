package app;

import controller.KnowledgeController;
import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entry point aplikasi KMS Putusan Pengadilan Narkotika.
 * Menginisialisasi komponen MVC dan menjalankan loop menu utama.
 * Tidak mengandung logika bisnis — hanya orkestrasi alur program.
 *
 * @author MPC
 * @version 1.0
 */
public class Main {

    /**
     * Method utama yang menjalankan aplikasi KMS.
     * Menginisialisasi Controller dan View, lalu menjalankan loop menu.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        KnowledgeController controller = new KnowledgeController();
        ConsoleView view = new ConsoleView();
        Scanner sc = controller.getScanner();

        view.tampilkanPesan("Selamat datang di KMS Putusan Pengadilan Narkotika!");

        int pilihan;
        do {
            pilihan = view.tampilkanMenu();

            switch (pilihan) {
                case 1:
                    String[] data = view.inputFormPutusan();
                    if (controller.tambahPutusan(data)) {
                        view.tampilkanPesan("Putusan berhasil ditambahkan!");
                    } else {
                        view.tampilkanPesan("Gagal menambahkan. Periksa input Anda.");
                    }
                    break;
                case 2:
                    ArrayList<Putusan> semua = controller.tampilkanSemua();
                    view.tampilkanDaftarPutusan(semua);
                    break;
                case 3:
                    String keyword = InputHandler.validasiString(
                            "Masukkan nomor perkara atau nama terdakwa: ", sc);
                    String mode = InputHandler.validasiString(
                            "Cari by (nomor/nama): ", sc);
                    ArrayList<Putusan> hasil = controller.cariPutusan(keyword, mode);
                    view.tampilkanDaftarPutusan(hasil);
                    break;
                case 4:
                    String kriteria = InputHandler.validasiString(
                            "Filter by (jenis/pengadilan): ", sc);
                    String nilai = InputHandler.validasiString(
                            "Masukkan nilai filter: ", sc);
                    ArrayList<Putusan> filtered = controller.filterPutusan(kriteria, nilai);
                    view.tampilkanDaftarPutusan(filtered);
                    break;
                case 5:
                    StatistikPutusan stat = controller.getStatistik();
                    view.tampilkanStatistik(stat);
                    break;
                case 6:
                    String nomor = InputHandler.validasiString(
                            "Masukkan nomor perkara yang akan dihapus: ", sc);
                    if (controller.hapusPutusan(nomor)) {
                        view.tampilkanPesan("Putusan berhasil dihapus.");
                    } else {
                        view.tampilkanPesan("Putusan tidak ditemukan.");
                    }
                    break;
                case 7:
                    controller.eksporStatistik("statistik.txt");
                    break;
                case 8:
                    view.tampilkanPesan("Terima kasih. Sampai jumpa!");
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak valid.");
            }
        } while (pilihan != 8);

        sc.close();
    }
}
