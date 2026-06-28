package model;

public class Putusan implements Comparable<Putusan> {
    // Attributes (Private - Enkapsulasi)
    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman; // dalam bulan
    private double vonisDenda;
    private String namaHakim;

    // Static Field (Counter)
    private static int jumlahDibuat = 0;

    // 1. No-arg Constructor
    public Putusan() {
        jumlahDibuat++;
    }

    // 2. Parameterized Constructor
    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan, String namaTerdakwa,
                   int umurTerdakwa, String jenisNarkotika, double beratBarangBukti, String pasalDilanggar,
                   String peranTerdakwa, int vonisHukuman, double vonisDenda, String namaHakim) {
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;
        jumlahDibuat++;
    }

    // Static Method
    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    // Logic Method: Kategori Hukuman
    public String getKategoriHukuman() {
        if (this.vonisHukuman < 48) { // di bawah 4 tahun
            return "Ringan";
        } else if (this.vonisHukuman <= 120) { // 4 - 10 tahun
            return "Sedang";
        } else {
            return "Berat";
        }
    }

    // Method Overloading 1: Tanpa Parameter
    public void tampilkan() {
        System.out.println(toString());
    }

    // Method Overloading 2: Dengan Parameter Boolean
    public void tampilkan(boolean detail) {
        if (detail) {
            System.out.println("=== DETAIL PUTUSAN ===");
            System.out.println("Nomor Perkara : " + nomorPerkara);
            System.out.println("Terdakwa      : " + namaTerdakwa + " (" + umurTerdakwa + " tahun)");
            System.out.println("Narkotika     : " + jenisNarkotika + " (" + beratBarangBukti + " gram)");
            System.out.println("Vonis Penjara : " + vonisHukuman + " bulan");
            System.out.println("Kategori      : " + getKategoriHukuman());
            System.out.println("======================");
        } else {
            tampilkan();
        }
    }

    // Method Overriding from Comparable (Bonus Fitur Sorting)
    @Override
    public int compareTo(Putusan o) {
        return Integer.compare(this.vonisHukuman, o.vonisHukuman);
    }

    // Method Overriding toString()
    @Override
    public String toString() {
        return nomorPerkara + " | " + namaTerdakwa + " | Hukuman: " + vonisHukuman + " bulan";
    }

    // Getters and Setters
    public String getNomorPerkara() { return nomorPerkara; }
    public void setNomorPerkara(String nomorPerkara) { this.nomorPerkara = nomorPerkara; }

    public String getPengadilan() { return pengadilan; }
    public void setPengadilan(String pengadilan) { this.pengadilan = pengadilan; }

    public String getTanggalPutusan() { return tanggalPutusan; }
    public void setTanggalPutusan(String tanggalPutusan) { this.tanggalPutusan = tanggalPutusan; }

    public String getNamaTerdakwa() { return namaTerdakwa; }
    public void setNamaTerdakwa(String namaTerdakwa) { this.namaTerdakwa = namaTerdakwa; }

    public int getUmurTerdakwa() { return umurTerdakwa; }
    public void setUmurTerdakwa(int umurTerdakwa) { this.umurTerdakwa = umurTerdakwa; }

    public String getJenisNarkotika() { return jenisNarkotika; }
    public void setJenisNarkotika(String jenisNarkotika) { this.jenisNarkotika = jenisNarkotika; }

    public double getBeratBarangBukti() { return beratBarangBukti; }
    public void setBeratBarangBukti(double beratBarangBukti) { this.beratBarangBukti = beratBarangBukti; }

    public String getPasalDilanggar() { return pasalDilanggar; }
    public void setPasalDilanggar(String pasalDilanggar) { this.pasalDilanggar = pasalDilanggar; }

    public String getPeranTerdakwa() { return peranTerdakwa; }
    public void setPeranTerdakwa(String peranTerdakwa) { this.peranTerdakwa = peranTerdakwa; }

    public int getVonisHukuman() { return vonisHukuman; }
    public void setVonisHukuman(int vonisHukuman) { this.vonisHukuman = vonisHukuman; }

    public double getVonisDenda() { return vonisDenda; }
    public void setVonisDenda(double vonisDenda) { this.vonisDenda = vonisDenda; }

    public String getNamaHakim() { return namaHakim; }
    public void setNamaHakim(String namaHakim) { this.namaHakim = namaHakim; }
}