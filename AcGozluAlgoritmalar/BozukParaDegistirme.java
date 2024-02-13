package AcGozluAlgoritmalar;

import java.util.Arrays;

public class BozukParaDegistirme {

    // Para üstünü en az sayıda bozuk para ile vermek için aç gözlü algoritma
    public static int[] paraUstuVer(int[] bozukParalar, int miktar) {
        // Bozuk paraları büyükten küçüğe doğru sırala
        Arrays.sort(bozukParalar);
        int n = bozukParalar.length;

        // Kullanılacak bozuk paraları saklamak için dizi
        int[] kullanilanBozukParalar = new int[n];

        // Aç gözlü algoritma ile bozuk paraları seç
        for (int i = n - 1; i >= 0; i--) {
            while (miktar >= bozukParalar[i]) {
                miktar -= bozukParalar[i]; // Miktarı güncelle
                kullanilanBozukParalar[i]++; // Bozuk para sayısını arttır
            }
        }

        // Eğer tam olarak para üstü verilemezse hata döndür
        if (miktar != 0) {
            throw new IllegalArgumentException("Verilen bozuk paralar ile miktar tam olarak oluşturulamıyor.");
        }

        // Kullanılan bozuk paraları döndür
        return kullanilanBozukParalar;
    }

    public static void main(String[] args) {
        // Bozuk para değerleri (örneğin Amerikan bozuk paraları: 1, 5, 10, 25 sent)
        int[] bozukParalar = {1, 5, 10, 25};

        // Para üstü verilecek miktar (örneğin 63 sent)
        int miktar = 63;

        try {
            int[] kullanilanBozukParalar = paraUstuVer(bozukParalar, miktar);
            System.out.println("Bozuk paraların kullanım sayıları:");
            for (int i = bozukParalar.length - 1; i >= 0; i--) {
                if (kullanilanBozukParalar[i] > 0) {
                    System.out.println(bozukParalar[i] + " sent: " + kullanilanBozukParalar[i] + " adet");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

