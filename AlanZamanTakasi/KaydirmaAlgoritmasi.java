package AlanZamanTakasi;

public class KaydirmaAlgoritmasi {
    static int[] kaydirmaTablosuOlustur(String pattern){
        int[] tablo=new int[256];
        int uzunluk=pattern.length();

        // Tüm karakterler için kaydırma değerlerini maksimum yap
        for (int i = 0; i < 256; i++) {
            tablo[i] = uzunluk;
        }
        // Pattern içindeki karakterler için kaydırma değerlerini güncelle
        for (int i = 0; i < uzunluk - 1; i++) {
            tablo[pattern.charAt(i)] = uzunluk - i - 1;
        }

        return tablo;
    }
    // Kaydırma algoritması ile arama yapan metod
    static void arama(String metin, String pattern) {
        int m = pattern.length();
        int n = metin.length();
        int[] tablo = kaydirmaTablosuOlustur(pattern);

        int i = 0; // Metindeki mevcut konum
        while (i <= n - m) {
            int j = m - 1;

            // Pattern'in sonundan başlayarak metin ile eşleşme kontrolü
            while (j >= 0 && pattern.charAt(j) == metin.charAt(i + j)) {
                j--;
            }

            if (j < 0) {
                System.out.println("Pattern bulundu: " + i);
                i += m; // Pattern bulunursa, metinde ilerle
            } else {
                // Eşleşmeyen karakter için kaydırma yap
                i += Math.max(1, tablo[metin.charAt(i + j)]);
            }
        }
    }

    public static void main(String[] args) {
        String metin = "Bu bir test metnidir.";
        String pattern = "t";
        arama(metin, pattern);
    }
}
