package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan {
    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiPeran;

    public StatistikPutusan(ArrayList<Putusan> daftar) {
        this.totalPutusan = daftar.size();
        hitungSemua(daftar);
    }

    public void hitungSemua(ArrayList<Putusan> daftar) {
        if (daftar.isEmpty()) return;

        double totalVonis = 0;
        double totalDenda = 0;
        Map<String, Integer> jenisCount = new HashMap<>();
        Map<String, Integer> peranCount = new HashMap<>();

        for (Putusan p : daftar) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            jenisCount.put(p.getJenisNarkotika(),
                jenisCount.getOrDefault(p.getJenisNarkotika(), 0) + 1);
            peranCount.put(p.getPeranTerdakwa(),
                peranCount.getOrDefault(p.getPeranTerdakwa(), 0) + 1);
        }

        this.rataRataVonis = totalVonis / daftar.size();
        this.rataRataDenda = totalDenda / daftar.size();

        this.jenisNarkotikaTerbanyak = jenisCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey).orElse("-");

        this.distribusiPeran = peranCount.entrySet().stream()
            .map(e -> e.getKey() + ": " + e.getValue())
            .toArray(String[]::new);
    }

    public void hitungSemua() {}

    public int getTotalPutusan() { return totalPutusan; }
    public double getRataRataVonis() { return rataRataVonis; }
    public double getRataRataDenda() { return rataRataDenda; }
    public String getJenisNarkotikaTerbanyak() { return jenisNarkotikaTerbanyak; }
    public String[] getDistribusiPeran() { return distribusiPeran; }
}