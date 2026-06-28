package kms_java.controller;

import kms_java.model.KnowledgeRepository;
import kms_java.model.Putusan;
import kms_java.model.StatistikPutusan;
import kms_java.util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * KnowledgeController — lapisan Controller dalam arsitektur MVC.
 * Menjembatani Model dan View, memvalidasi input,
 * dan mengorkestrasi alur data antar layer.
 * Tidak menyimpan data secara langsung — semua data dikelola oleh Model.
 *
 * @author MPC
 * @version 1.0
 */
public class KnowledgeController {

    private KnowledgeRepository repo;
    private Scanner scanner;

    /**
     * Constructor — inisialisasi repository dan scanner.
     */
    public KnowledgeController() {
        this.repo = new KnowledgeRepository();
        this.scanner = new Scanner(System.in);
        initDataSample();
    }

    /**
     * Inisialisasi data sample minimal untuk demo.
     */
    private void initDataSample() {
        repo.simpan(new Putusan(
                "1001/Pid.Sus/2024/PN Sby", "Budi Santoso", "PN Surabaya",
                "2024-01-15", 30, "Sabu-sabu", 5.2,
                "Pasal 114 Ayat (1)", "Pengguna", 60, 2000000, "Hakim Andi"));
        repo.simpan(new Putusan(
                "1002/Pid.Sus/2024/PN Sby", "Ani Rahmawati", "PN Surabaya",
                "2024-02-20", 25, "Ganja", 200.0,
                "Pasal 111 Ayat (1)", "Penyimpan", 48, 1000000, "Hakim Budi"));
        repo.simpan(new Putusan(
                "1003/Pid.Sus/2024/PN Sby", "Candra Wijaya", "PN Surabaya",
                "2024-03-10", 35, "Sabu-sabu", 10.5,
                "Pasal 112 Ayat (2)", "Bandar", 120, 5000000, "Hakim Citra"));
        repo.simpan(new Putusan(
                "1004/Pid.Sus/2024/PN Sby", "Dewi Lestari", "PN Surabaya",
                "2024-03-25", 28, "Ekstasi", 50.0,
                "Pasal 114 Ayat (2)", "Kurir", 72, 3000000, "Hakim Dedi"));
        repo.simpan(new Putusan(
                "1005/Pid.Sus/2024/PN Sby", "Eko Prasetyo", "PN Surabaya",
                "2024-04-05", 40, "Heroin", 2.3,
                "Pasal 111 Ayat (2)", "Pengguna", 36, 800000, "Hakim Eko"));
    }

    /**
     * Menambah putusan baru dari data mentah String[].
     * Memvalidasi setiap field sebelum menyimpan ke repository.
     *
     * @param data array String[12] berisi data mentah dari View
     * @return true jika berhasil, false jika gagal
     */
    public boolean tambahPutusan(String[] data) {
        try {
            if (data == null || data.length < 12) return false;
            for (String d : data) {
                if (d == null || d.trim().isEmpty()) return false;
            }
            int umur = Integer.parseInt(data[4]);
            double berat = Double.parseDouble(data[6]);
            int vonis = Integer.parseInt(data[9]);
            double denda = Double.parseDouble(data[10]);

            if (umur <= 0 || berat <= 0 || vonis <= 0 || denda < 0) return false;

            Putusan p = new Putusan(
                    data[0], data[1], data[2], data[3],
                    umur, data[5], berat, data[7], data[8],
                    vonis, denda, data[11]
            );
            repo.simpan(p);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("  [!] Format angka tidak valid: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("  [!] Terjadi kesalahan: " + e.getMessage());
            return false;
        }
    }

    /**
     * Mencari putusan berdasarkan keyword dan mode pencarian.
     *
     * @param keyword kata kunci pencarian
     * @param mode    "nomor" untuk cari by nomor, "nama" untuk cari by nama
     * @return ArrayList hasil pencarian
     */
    public ArrayList<Putusan> cariPutusan(String keyword, String mode) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (mode.equalsIgnoreCase("nomor")) {
            Putusan p = repo.cariByNomor(keyword);
            if (p != null) hasil.add(p);
        } else if (mode.equalsIgnoreCase("nama")) {
            hasil = repo.cariByNama(keyword);
        }
        return hasil;
    }

    /**
     * Mencari putusan by nomor perkara langsung.
     *
     * @param nomor nomor perkara
     * @return objek Putusan atau null
     */
    public Putusan cariByNomor(String nomor) {
        return repo.cariByNomor(nomor);
    }

    /**
     * Filter putusan berdasarkan kriteria tertentu.
     *
     * @param kriteria "jenis" untuk filter by jenis narkotika,
     *                 "pengadilan" untuk filter by pengadilan
     * @param nilai    nilai yang dicari
     * @return ArrayList hasil filter
     */
    public ArrayList<Putusan> filterPutusan(String kriteria, String nilai) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : repo.getDaftarSemua()) {
            if (kriteria.equalsIgnoreCase("jenis")) {
                if (p.getJenisNarkotika().equalsIgnoreCase(nilai)) {
                    hasil.add(p);
                }
            } else if (kriteria.equalsIgnoreCase("pengadilan")) {
                if (p.getPengadilan().equalsIgnoreCase(nilai)) {
                    hasil.add(p);
                }
            }
        }
        return hasil;
    }

    /**
     * Menghapus putusan berdasarkan nomor perkara.
     *
     * @param nomor nomor perkara yang akan dihapus
     * @return true jika berhasil dihapus, false jika tidak ditemukan
     */
    public boolean hapusPutusan(String nomor) {
        return repo.hapus(nomor);
    }

    /**
     * Mengambil statistik dari seluruh data putusan.
     *
     * @return objek StatistikPutusan
     */
    public StatistikPutusan getStatistik() {
        StatistikPutusan stat = new StatistikPutusan(repo.getDaftarSemua());
        stat.hitungSemua();
        return stat;
    }

    /**
     * Mengambil seluruh daftar putusan dari repository.
     *
     * @return ArrayList semua putusan
     */
    public ArrayList<Putusan> tampilkanSemua() {
        return repo.getDaftarSemua();
    }

    /**
     * Mengembalikan Scanner yang digunakan Controller.
     *
     * @return Scanner
     */
    public Scanner getScanner() {
        return scanner;
    }
}