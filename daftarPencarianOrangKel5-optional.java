import java.io.*;
import java.util.*;

public class daftarPencarianOrangKel5 {

    public static void main(String[] args) {
        
        HashMap<String, Integer> pembunuhKorbanCount = new HashMap<>();
        Set<String> korbanSet = new HashSet<>();

        // File or Console!
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan 'file' untuk membaca dari file atau 'console' untuk membaca dari konsol:");
        String inputSource = scanner.nextLine().trim().toLowerCase();

        BufferedReader reader = null;

        try {
            if (inputSource.equals("file")) {
                System.out.println("Masukkan nama file:");
                String fileName = scanner.nextLine().trim();
                reader = new BufferedReader(new FileReader(fileName));
            } else if (inputSource.equals("console")) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Masukkan data pembunuh dan korban (contoh: Pembunuh Korban).");
                System.out.println("Tekan Enter pada baris kosong setelah selesai memasukkan data.");
            } else {
                System.err.println("Pilihan tidak valid. Harap masukkan 'file' atau 'console'.");
                return;
            }

            int lineCount = 0;
            while (lineCount < 1000) {
                String line = reader.readLine();
                if (line == null || line.trim().isEmpty()) {
                    if (lineCount >= 1) {
                        break;
                    } else {
                        System.err.println("Anda harus memasukkan input minimal satu baris data!");
                        continue;
                    }
                }

                String[] data = line.split(" ");
                if (data.length != 2) {
                    System.err.println("Format data salah! Contoh: Pembunuh Korban");
                    continue;
                }

                String pembunuh = data[0];
                String korban = data[1];

                if (!pembunuh.equals(korban)) {
                    // add set
                    korbanSet.add(korban);

                    // update
                    pembunuhKorbanCount.put(pembunuh, pembunuhKorbanCount.getOrDefault(pembunuh, 0) + 1);
                }

                lineCount++;
            }

            // Sortir pembunuh berdasarkan abjad
            List<String> pembunuhTerurut = new ArrayList<>(pembunuhKorbanCount.keySet());
            Collections.sort(pembunuhTerurut);

            // Output hasil
            System.out.println("\nDAFTAR PENCARIAN ORANG KASUS PEMBUNUHAN");
            for (String pembunuh : pembunuhTerurut) {
                if (!korbanSet.contains(pembunuh) && pembunuhKorbanCount.get(pembunuh) > 0) {
                    int jumlahKorban = pembunuhKorbanCount.get(pembunuh);
                    System.out.println(pembunuh + " " + jumlahKorban);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
