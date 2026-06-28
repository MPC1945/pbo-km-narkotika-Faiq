package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan {
    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiPeran; // Array primitif string untuk memenuhi kriteria penilaian

    public StatistikPutusan(ArrayList<Putusan> daftar) {
        this.totalPutusan = daftar.size();
        hitungSemua(daftar);
    }

    public void hitungSemua(ArrayList<Putusan> daftar) {
        if (daftar.isEmpty()) {
            this.rataRataVonis = 0;
            this.rataRataDenda = 0;
            this.jenisNarkotikaTerbanyak = "Tidak ada data";
            this.distribusiPeran = new String[]{"Belum ada data"};
            return;
        }

        double totalVonis = 0;
        double totalDenda = 0;

        HashMap<String, Integer> mapNarkotika = new HashMap<>();
        HashMap<String, Integer> mapPeran = new HashMap<>();

        for (Putusan p : daftar) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            // Hitung frekuensi jenis narkotika
            String jenis = p.getJenisNarkotika().toLowerCase();
            mapNarkotika.put(jenis, mapNarkotika.getOrDefault(jenis, 0) + 1);

            // Hitung frekuensi peran
            String peran = p.getPeranTerdakwa().toLowerCase();
            mapPeran.put(peran, mapPeran.getOrDefault(peran, 0) + 1);
        }

        this.rataRataVonis = totalVonis / totalPutusan;
        this.rataRataDenda = totalDenda / totalPutusan;

        // Cari jenis narkotika terbanyak
        String terbanyak = "Tidak diketahui";
        int maxCount = -1;
        for (Map.Entry<String, Integer> entry : mapNarkotika.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                terbanyak = entry.getKey();
            }
        }
        this.jenisNarkotikaTerbanyak = terbanyak;

        // Mengisi array primitif distribusi peran
        this.distribusiPeran = new String[mapPeran.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : mapPeran.entrySet()) {
            this.distribusiPeran[idx] = entry.getKey() + ": " + entry.getValue() + " orang";
            idx++;
        }
    }

    public void tampilkanLaporan() {
        System.out.println("========== LAPORAN STATISTIK ==========");
        System.out.println("Total Putusan            : " + totalPutusan);
        System.out.println("Rata-rata Vonis (Bulan)  : " + String.format("%.2f", rataRataVonis));
        System.out.println("Rata-rata Denda (Rupiah) : Rp" + String.format("%.2f", rataRataDenda));
        System.out.println("Jenis Narkotika Terbanyak: " + jenisNarkotikaTerbanyak);
        System.out.println("Distribusi Peran Terdakwa:");
        for (String peran : distribusiPeran) {
            System.out.println("  - " + peran);
        }
        System.out.println("=======================================");
    }

    // Getters
    public int getTotalPutusan() { return totalPutusan; }
    public double getRataRataVonis() { return rataRataVonis; }
    public double getRataRataDenda() { return rataRataDenda; }
    public String getJenisNarkotikaTerbanyak() { return jenisNarkotikaTerbanyak; }
    public String[] getDistribusiPeran() { return distribusiPeran; }
}