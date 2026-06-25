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
        return 0;
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
    }

    public String[] inputFormPutusan() {
        return new String[12];
    }

    public Scanner getScanner() {
        return scanner;
    }
}