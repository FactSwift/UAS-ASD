import java.util.*;
/// Masih ada beberapa yang kurang
///  diantaranya : Saat si pembunuh dibunuh, harusnya gamasuk list di output
///                Huruf depannya ganti Kapital
public class DaftarPencarianOrangKel5 {

    public static void main(String[] args) {
        // Inisialisasi HashMap untuk menyimpan data pembunuh dan korban
        HashMap<String, List<String>> pembunuhKorban = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println ("Masukkan data pembunuh dan korban (klik spasi untuk berhenti): ");

        int lineCount = 0;

        while (lineCount < 1000) {  // Loop dengan minimal 1 baris dan maksimal 1000 baris
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) { // Periksa jika inputan kosong
                if (lineCount >= 1) {
                    break;
                } else {
                    System.err.println ("Anda harus memasukkan input minimal satu baris data!");
                    continue;
                }
            }

            String[] data = line.split(" "); // Pisahkan data dengan spasi
            if (data.length != 2) { // Periksa format data
                System.err.println ("Format data salah! Contoh: PEMBUNUH KORBAN");
                continue;
            }

            String pembunuh = data[0];
            String korban = data[1];

            if (!pembunuh.equals(korban)) { // Kalo bunuh diri gaakan masuk list
                // Tambahkan data ke HashMap
                if (!pembunuhKorban.containsKey(pembunuh)) {
                    pembunuhKorban.put(pembunuh, new ArrayList<>());
                }
                pembunuhKorban.get(pembunuh).add(korban);
            }

            lineCount++;
        }

        // Ini kalo mau sort berdasarkan abjad
        List<String> pembunuhTerurut = new ArrayList<>(pembunuhKorban.keySet());
        Collections.sort(pembunuhTerurut);

        // Outputnya nich
        System.out.println("\nDAFTAR PENCARIAN ORANG KASUS PEMBUNUHAN");
        for (String pembunuh : pembunuhTerurut) {
            int jumlahKorban = pembunuhKorban.get(pembunuh).size();
            System.out.println(pembunuh + " " + jumlahKorban);
        }
    }
}