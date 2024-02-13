package DinamikProgramlama;

public class BozukParaRobot {

    // Robotun toplayabileceği maksimum para miktarını hesaplayan fonksiyon
    public static int maksimumParaTopla(int[][] ızgara) {
        int satir = ızgara.length;
        int sutun = ızgara[0].length;

        // dp dizisi, her hücre için maksimum toplanabilecek para miktarını tutar
        int[][] dp = new int[satir][sutun];

        // İlk hücreye başlangıç değeri atama
        dp[0][0] = ızgara[0][0];

        // İlk satırı doldur
        for (int j = 1; j < sutun; j++) {
            dp[0][j] = dp[0][j - 1] + ızgara[0][j];
        }

        // İlk sütunu doldur
        for (int i = 1; i < satir; i++) {
            dp[i][0] = dp[i - 1][0] + ızgara[i][0];
        }

        // Geri kalan hücreleri doldur
        for (int i = 1; i < satir; i++) {
            for (int j = 1; j < sutun; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + ızgara[i][j];
            }
        }

        // Sağ alt köşedeki hücre, maksimum toplanabilecek para miktarını temsil eder
        return dp[satir - 1][sutun - 1];
    }

    public static void main(String[] args) {
        int[][] ızgara = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Maksimum toplanabilecek para: " + maksimumParaTopla(ızgara));
    }
}
