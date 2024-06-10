import java.util.*;

public class daftarPencarianOrangKel5 {

    public static void main(String[] args) {
        // Inisialisasi Map untuk menyimpan data pembunuh dan korban
        Map<String, Integer> pembunuhKorban = new HashMap<>();
        Set<String> korbanSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan data pembunuh dan korban (contoh: 'Pembunuh' 'Korban').");
        System.out.println("Tekan Enter pada baris kosong setelah selesai memasukkan data.");

        int lineCount = 0;
        int maxLines = 1000;

        while (lineCount < maxLines + 1) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                if (lineCount >= 1) {
                    break;
                } else {
                    System.err.println("Anda harus memasukkan input minimal satu baris data!");
                    continue;
                }
            }

            String[] data = line.split(" ");
            if (data.length != 2) {
                System.err.println("Format data salah! Contoh: 'Pembunuh' 'Korban'");
                continue;
            }

            String pembunuh = data[0];
            String korban = data[1];

            if (pembunuh.length() > 10 || korban.length() > 10) {
                System.err.println("Nama pembunuh dan korban harus memiliki panjang maksimal 10 karakter!");
                continue;
            }

            if (!pembunuh.equals(korban)) {
                pembunuhKorban.put(pembunuh, pembunuhKorban.getOrDefault(pembunuh, 0) + 1);
                korbanSet.add(korban);
            }

            lineCount++;

            if (lineCount == maxLines + 1) {
                System.out.println("\nPeringatan: Anda telah mencapai batas maksimal input.");
                continue;
            }
        }

        // Output
        System.out.println("\nDAFTAR PENCARIAN ORANG KASUS PEMBUNUHAN");
        TreeSet<String> pembunuhTerurut = new TreeSet<>(pembunuhKorban.keySet());
        for (String pembunuh : pembunuhTerurut) {
            if (!korbanSet.contains(pembunuh) && pembunuhKorban.get(pembunuh) > 0) {
                int jumlahKorban = pembunuhKorban.get(pembunuh);
                System.out.println(pembunuh + " " + jumlahKorban);
            }
        }
    }
}
