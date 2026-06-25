package model;

import java.util.ArrayList;

public class StatistikPutusan {
    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiPeran;

    public StatistikPutusan(ArrayList<Putusan> daftar) {
        this.totalPutusan = daftar.size();
        this.rataRataVonis = 0.0;
        this.rataRataDenda = 0.0;
        this.jenisNarkotikaTerbanyak = "-";
        this.distribusiPeran = new String[]{"belum dihitung"};
    }

    public int getTotalPutusan() { return totalPutusan; }
    public double getRataRataVonis() { return rataRataVonis; }
    public double getRataRataDenda() { return rataRataDenda; }
    public String getJenisNarkotikaTerbanyak() { return jenisNarkotikaTerbanyak; }
    public String[] getDistribusiPeran() { return distribusiPeran; }
}