package controller;

import model.*;
import java.util.ArrayList;

public class KnowledgeController {
    private KnowledgeRepository repo;

    public KnowledgeController() {
        repo = new KnowledgeRepository();
        repo.simpan(new Putusan(
                "1001/Pid.Sus/2024/PN Sby", "Budi Santoso", "PN Surabaya",
                "2024-01-15", 30, "Sabu", 5.2, "Pasal 114(1)", "Pengguna",
                60, 2000000, "Hakim Andi"));
        repo.simpan(new Putusan(
                "1002/Pid.Sus/2024/PN Sby", "Ani Rahmawati", "PN Surabaya",
                "2024-02-20", 25, "Ganja", 200.0, "Pasal 111(1)", "Penyimpan",
                48, 1000000, "Hakim Budi"));
    }

    public ArrayList<Putusan> tampilkanSemua() {
        return repo.getDaftarSemua();
    }

    public StatistikPutusan getStatistik() {
        return new StatistikPutusan(repo.getDaftarSemua());
    }

    public boolean tambahPutusan(String[] data) {
        try {
            Putusan p = new Putusan(
                    data[0], data[1], data[2], data[3],
                    Integer.parseInt(data[4]), data[5],
                    Double.parseDouble(data[6]), data[7], data[8],
                    Integer.parseInt(data[9]), Double.parseDouble(data[10]), data[11]
            );
            repo.simpan(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Putusan cariByNomor(String nomor) {
        return repo.cariByNomor(nomor);
    }

    public boolean hapusPutusan(String nomor) {
        return repo.hapus(nomor);
    }
}