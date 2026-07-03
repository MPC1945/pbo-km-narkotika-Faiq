package kms_java.util;

import java.util.Scanner;

/**
 * Utility class untuk validasi input pengguna.
 * Semua method bersifat static — tidak perlu instansiasi.
 *
 * @author MPC
 */
public class InputHandler {

    /**
     * Meminta input String yang tidak boleh kosong.
     *
     * @param prompt Pesan yang ditampilkan ke pengguna
     * @param sc     Scanner yang digunakan
     * @return String yang valid (tidak kosong)
     */
    public static String validasiString(String prompt, Scanner sc) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("  [!] Input tidak boleh kosong. Coba lagi.");
            }
        }
        return input.trim();
    }

    /**
     * Meminta input integer, menolak nilai non-angka.
     *
     * @param prompt Pesan yang ditampilkan ke pengguna
     * @param sc     Scanner yang digunakan
     * @return int yang valid
     */
    public static int validasiInt(String prompt, Scanner sc) {
        while (true) {
            try {
                System.out.print(prompt);
                int nilai = Integer.parseInt(sc.nextLine().trim());
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka bulat. Coba lagi.");
            }
        }
    }

    /**
     * Meminta input integer dengan batas minimum nilai.
     * Overloading dari validasiInt(String, Scanner).
     *
     * @param prompt   Pesan yang ditampilkan ke pengguna
     * @param minNilai Nilai minimum yang diizinkan
     * @param sc       Scanner yang digunakan
     * @return int yang valid dan >= minNilai
     */
    public static int validasiInt(String prompt, int minNilai, Scanner sc) {
        while (true) {
            try {
                System.out.print(prompt);
                int nilai = Integer.parseInt(sc.nextLine().trim());
                if (nilai < minNilai) {
                    System.out.println("  [!] Nilai tidak boleh kurang dari " + minNilai + ".");
                } else {
                    return nilai;
                }
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka bulat. Coba lagi.");
            }
        }
    }

    /**
     * Meminta input double, menolak nilai non-angka.
     *
     * @param prompt Pesan yang ditampilkan ke pengguna
     * @param sc     Scanner yang digunakan
     * @return double yang valid
     */
    public static double validasiDouble(String prompt, Scanner sc) {
        while (true) {
            try {
                System.out.print(prompt);
                double nilai = Double.parseDouble(sc.nextLine().trim());
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka desimal. Coba lagi.");
            }
        }
    }

    /**
     * Meminta input double dengan batas minimum nilai.
     * Overloading dari validasiDouble(String, Scanner).
     *
     * @param prompt   Pesan yang ditampilkan ke pengguna
     * @param minNilai Nilai minimum yang diizinkan
     * @param sc       Scanner yang digunakan
     * @return double yang valid dan >= minNilai
     */
    public static double validasiDouble(String prompt, double minNilai, Scanner sc) {
        while (true) {
            try {
                System.out.print(prompt);
                double nilai = Double.parseDouble(sc.nextLine().trim());
                if (nilai < minNilai) {
                    System.out.println("  [!] Nilai tidak boleh kurang dari " + minNilai + ".");
                } else {
                    return nilai;
                }
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka desimal. Coba lagi.");
            }
        }
    }

    /**
     * Meminta input pilihan menu dalam rentang min-max.
     *
     * @param prompt Pesan yang ditampilkan ke pengguna
     * @param min    Nilai minimum pilihan
     * @param max    Nilai maksimum pilihan
     * @param sc     Scanner yang digunakan
     * @return int pilihan yang valid
     */
    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
        while (true) {
            try {
                System.out.print(prompt);
                int pilihan = Integer.parseInt(sc.nextLine().trim());
                if (pilihan < min || pilihan > max) {
                    System.out.println("  [!] Pilihan harus antara " + min + " dan " + max + ".");
                } else {
                    return pilihan;
                }
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka. Coba lagi.");
            }
        }
    }
}
