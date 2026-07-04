package app;

import controller.KnowledgeController;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        KnowledgeController controller = new KnowledgeController();
        ConsoleView view = new ConsoleView();

        view.tampilkanPesan("Selamat datang di KMS Putusan Narkotika");

        int pilihan;
        do {
            pilihan = view.tampilkanMenu();
            switch (pilihan) {
                case 1:
                    String[] data = view.inputFormPutusan();
                    if (controller.tambahPutusan(data)) {
                        view.tampilkanPesan("Putusan berhasil ditambahkan!");
                    } else {
                        view.tampilkanPesan("Gagal menambahkan putusan. Periksa input.");
                    }
                    break;
                case 2:
                    view.tampilkanDaftarPutusan(controller.tampilkanSemua());
                    break;
                case 3:
                    System.out.print("Masukkan nomor perkara: ");
                    String nomor = view.getScanner().nextLine();
                    view.tampilkanDetail(controller.cariByNomor(nomor));
                    break;
                case 4:
                    view.tampilkanPesan("Fitur filter belum tersedia.");
                    break;
                case 5:
                    view.tampilkanStatistik(controller.getStatistik());
                    break;
                case 6:
                    System.out.print("Masukkan nomor perkara yang akan dihapus: ");
                    String hapusNomor = view.getScanner().nextLine();
                    if (controller.hapusPutusan(hapusNomor)) {
                        view.tampilkanPesan("Putusan berhasil dihapus.");
                    } else {
                        view.tampilkanPesan("Putusan tidak ditemukan.");
                    }
                    break;
                case 7:
                    view.tampilkanPesan("Terima kasih. Keluar.");
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak valid. Silakan pilih 1-7.");
            }
        } while (pilihan != 7);

        view.getScanner().close();
    }
}