import java.util.*;

public class DaftarPencarianOrangKel5 {

    public static void main(String[] args) {
        // Inisialisasi HashMap untuk menyimpan data pembunuh dan korban
        HashMap<String, List<String>> pembunuhKorban = new HashMap<>();
        Set<String> korbanSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan data pembunuh dan korban (contoh: Pembunuh Korban)."); //Nambahin cara penggunaan
        System.out.println("Tekan Enter pada baris kosong setelah selesai memasukkan data.");

        int lineCount = 0;

        while (lineCount < 1000) {  // Loop dengan minimal 1 baris dan maksimal 1000 baris
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) { // Periksa jika inputan kosong
                if (lineCount >= 1) {
                    break;
                } else {
                    System.err.println("Anda harus memasukkan input minimal satu baris data!");
                    continue;
                }
            }

            String[] data = line.split(" "); // Pisahkan data dengan spasi
            if (data.length != 2) { // Periksa format data
                System.err.println("Format data salah! Contoh: Pembunuh Korban");
                continue;
            }

            String pembunuh = data[0].toLowerCase();
            String korban = data[1].toLowerCase();

            if (!pembunuh.equals(korban)) { // Kalo bunuh diri gaakan masuk list
                // Tambahkan data ke HashMap
                if (!pembunuhKorban.containsKey(pembunuh)) {
                    pembunuhKorban.put(pembunuh, new ArrayList<>());
                }
                pembunuhKorban.get(pembunuh).add(korban);
                korbanSet.add(korban);
            }

            lineCount++;
        }

        // Ini kalo mau sort berdasarkan abjad
        List<String> pembunuhTerurut = new ArrayList<>(pembunuhKorban.keySet());
        Collections.sort(pembunuhTerurut);

        // Outputnya nich
        System.out.println("\nDaftar Pencarian Orang Kasus Pembunuhan");
        for (String pembunuh : pembunuhTerurut) {
            if (!korbanSet.contains(pembunuh) && pembunuhKorban.get(pembunuh).size() > 0) { // Saat si pembunuhnya telah dibunuh atau tidak ada korban, gamasuk list di output
                int jumlahKorban = pembunuhKorban.get(pembunuh).size();
                // Buat huruf depannya kapital
                System.out.println(Character.toUpperCase(pembunuh.charAt(0)) + pembunuh.substring(1) + " " + jumlahKorban);
            }
        }
    }
}
