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
}