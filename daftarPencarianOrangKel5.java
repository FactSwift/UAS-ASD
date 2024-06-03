import java.util.*;
//coba cek gini bukan?

public class DaftarPencarianOrangKel5 {

    public static void main(String[] args) {
        HashMap<String, List<String>> pembunuhKorban = new HashMap<>();
        Set<String> korbanSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        int lineCount = 0;

        while (lineCount < 1000) {
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
                System.err.println("Format data salah! Contoh: PEMBUNUH KORBAN");
                continue;
            }

            String pembunuh = data[0].toLowerCase();
            String korban = data[1].toLowerCase();

            if (!pembunuh.equals(korban)) {
                if (!pembunuhKorban.containsKey(pembunuh)) {
                    pembunuhKorban.put(pembunuh, new ArrayList<>());
                }
                pembunuhKorban.get(pembunuh).add(korban);
                korbanSet.add(korban);
            }

            lineCount++;
        }

        List<String> pembunuhTerurut = new ArrayList<>(pembunuhKorban.keySet());
        Collections.sort(pembunuhTerurut);

        System.out.println("\nDaftar Pencarian Orang Kasus Pembunuhan");
        for (String pembunuh : pembunuhTerurut) {
            if (!korbanSet.contains(pembunuh)) {
                int jumlahKorban = pembunuhKorban.get(pembunuh).size();
                System.out.println(Character.toUpperCase(pembunuh.charAt(0)) + pembunuh.substring(1) + " " + jumlahKorban);
            }
        }
    }
}
