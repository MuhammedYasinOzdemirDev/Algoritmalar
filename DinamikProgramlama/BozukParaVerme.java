package DinamikProgramlama;

import java.util.Arrays;

public class BozukParaVerme {
    public static int minumumBozukPara(int[] bozukParalar,int miktar){
        // Miktar + 1 ile bir dizi oluşturulur ve maksimum değerlerle doldurulur
        int MAX = miktar + 1;
        int[] dp = new int[MAX];
        Arrays.fill(dp, MAX);
        dp[0] = 0; // 0 miktar için 0 bozuk para gerekir
        // Her bir miktar için minimum bozuk para sayısını hesapla
        for(int i=1;i<=miktar;i++){
            for(int j=0;j<bozukParalar.length;j++){
                if(bozukParalar[j]<=i){
                    dp[i] = Math.min(dp[i], dp[i - bozukParalar[j]] + 1);
                }
            }
        }
        // Eğer son değer maksimumsa, bu miktar verilen bozuk paralarla oluşturulamaz
        return dp[miktar] > miktar ? -1 : dp[miktar];
    }
    public static void main(String[] args) {
        int[] bozukParalar = {1, 3, 4};
        int miktar = 6;
        System.out.println("Minimum bozuk para sayısı: " + minumumBozukPara(bozukParalar, miktar));
    }
}
