package DinamikProgramlama;

public class RobotToplamaHaritasi {

    public static int[][] maksimumToplamaHaritasiOlustur(int[][] ızgara) {
    int satir=ızgara.length;
    int sutun=ızgara[0].length;
    int[][] dp=new int[satir][sutun];
    for(int i=0;i<satir;i++){
        for (int j=0;j<sutun;j++){
            // Eğer ilk hücredeysek, başlangıç değerini sadece ızgara üzerinden alıyoruz.
            if(i==0 && j==0){
                dp[i][j]=ızgara[i][j];
                continue; // Döngünün sonraki adımına geçiyoruz.
            }
            // Sol hücrenin değerini kontrol ediyoruz.
            int solHucresi = 0;
            if(j>0)
                solHucresi=dp[i][j-1];// Sol hücredeki maksimum toplam değerini alıyoruz.
            // Üst hücrenin değerini kontrol ediyoruz.
            int ustHucresi = 0;
            if (i > 0)
                ustHucresi = dp[i - 1][j]; // Üst hücredeki maksimum toplam değerini alıyoruz.
    // Şu anki hücrede bir nesne var mı, yok mu ona bakıyoruz.
            int suAnkiHucresi = ızgara[i][j]; // Şu anki hücredeki değeri alıyoruz.

            // Şimdi maksimum toplama değerini bulmak için, sol ve üst hücrelerin değerlerine bakıyoruz.
            int maksimumDeger = solHucresi;
            if (ustHucresi > solHucresi) {
                maksimumDeger = ustHucresi; // Eğer üst hücredeki değer daha büyükse, o değeri kullanıyoruz.
            }
            dp[i][j] = maksimumDeger + suAnkiHucresi; // Şu anki hücredeki değeri ekleyerek toplamı buluyoruz.
        }

    }
        // Hesaplanan maksimum toplama haritasını geri döndürüyoruz.
        return dp;
    }


    public static void main(String[] args) {
        int[][] ızgara = {
                {0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 0}
        };

        int[][] harita = maksimumToplamaHaritasiOlustur(ızgara);

        for (int[] satir : harita) {
            for (int deger : satir) {
                System.out.print(deger + " ");
            }
            System.out.println();
        }
    }
}
