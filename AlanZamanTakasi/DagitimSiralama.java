package AlanZamanTakasi;

import java.util.Arrays;

public class DagitimSiralama {

    public static void dagitimSiralama(int[] dizi) {
        int n = dizi.length;

        // Dizideki en büyük ve en küçük değerleri bul
        int max = dizi[0], min = dizi[0];
        for (int i = 1; i < n; i++) {
            if (dizi[i] > max) {
                max = dizi[i];
            }
            if (dizi[i] < min) {
                min = dizi[i];
            }
        }

        int aralik = max - min + 1;
        int[] sayac = new int[aralik];

        // Elemanların frekansını say
        for (int i = 0; i < n; i++) {
            sayac[dizi[i] - min]++;
        }

        // Sıralanmış diziyi oluştur
        int index = 0;
        for (int i = 0; i < aralik; i++) {
            while (sayac[i] > 0) {
                dizi[index++] = i + min;
                sayac[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] dizi = {4, 2, 2, 8, 3, 3, 1};
        dagitimSiralama(dizi);
        System.out.println("Sıralanmış Dizi: " + Arrays.toString(dizi));
    }
}

