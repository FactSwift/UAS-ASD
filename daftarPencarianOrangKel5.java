import java.util.*;

/// Masih ada beberapa yang kurang
///  diantaranya : Saat si pembunuh dibunuh, harusnya gamasuk list di output
///                biar ga infinite, Ganti while dengan min 1 baris dan max 1000 baris
///                Huruf depannya ganti Kapital

public class daftarPencarianOrangKel5 {

    public static void main(String[] args) {
        // Inisialisasi HashMap untuk menyimpan data pembunuh dan korban
        HashMap<String, List<String>> pembunuhKorban = new HashMap<>();

       
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan data pembunuh dan korban (masukkan spasi untuk berhenti): ");

        while (scanner.hasNextLine()) { // Loop Terus ( ini harus diganti jadi min 1 dan max 1000)
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) { // Periksa jika inputan kosong
                break;
            }

            String[] data = line.split(" "); // Pisahkan data dengan spasi
            if (data.length != 2) { // Periksa format data
                System.err.println("Format data salah! Contoh: PEMBUNUH KORBAN");
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
        }

        // Ini kalo mau sort berdasarkan abjad
        List<String> pembunuhTerurut = new ArrayList<>(pembunuhKorban.keySet());
        Collections.sort(pembunuhTerurut);

        // Outputnya nich
        System.out.println("\nDAFTAR PENCARIAN ORANG KASUS PEMBUNUHAN");
        for (String pembunuh : pembunuhTerurut) {
            int jumlahKorban = pembunuhKorban.get(pembunuh).size();
            System.out.println(pembunuh + " " + jumlahKorban );
        }
    }
}
