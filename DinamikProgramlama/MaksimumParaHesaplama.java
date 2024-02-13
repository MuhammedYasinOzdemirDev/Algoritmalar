package DinamikProgramlama;

public class MaksimumParaHesaplama {
    // Maksimum para toplamını bulan fonksiyon
    public static int maksimumParaTopla(int[] paralar) {
        int n = paralar.length;
        if (n == 0) return 0;
        if (n == 1) return paralar[0];

        // dinamik diziyi başlatma
        int[] dp = new int[n];

        // İlk iki eleman için maksimum değerleri hesaplama
        dp[0] = paralar[0];
        dp[1] = Math.max(paralar[0], paralar[1]);

        // Her eleman için maksimum toplamı bulma
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(paralar[i] + dp[i - 2], dp[i - 1]);//o para ile 2 önceki ve önceki sonucu karsilastiri
        }

        // Son eleman, maksimum toplamı temsil eder
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] paralar = {5, 1, 2, 10, 6, 2};
        System.out.println("Maksimum toplanabilecek para: " + maksimumParaTopla(paralar));
    }
}
