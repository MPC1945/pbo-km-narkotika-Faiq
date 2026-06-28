package model;

public class PutusanNarkotika extends Putusan {
    // Menggunakan constructor dari parent
    public PutusanNarkotika() {
        super();
    }

    public PutusanNarkotika(String nomorPerkara, String pengadilan, String tanggalPutusan, String namaTerdakwa,
                            int umurTerdakwa, String jenisNarkotika, double beratBarangBukti, String pasalDilanggar,
                            String peranTerdakwa, int vonisHukuman, double vonisDenda, String namaHakim) {
        super(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa, umurTerdakwa, jenisNarkotika, 
              beratBarangBukti, pasalDilanggar, peranTerdakwa, vonisHukuman, vonisDenda, namaHakim);
    }
    
    // Contoh Overriding tambahan
    @Override
    public String getKategoriHukuman() {
        return "Narkotika - " + super.getKategoriHukuman();
    }
}