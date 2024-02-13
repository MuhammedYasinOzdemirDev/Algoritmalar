package AzaltFethet_Algoritmaları;

public class Problemler {
    // Permutasyonları oluşturan metod
    //Buna Bak
    static void permutasyon(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permutasyon(ros, ans + ch);
        }
    }
    // Alt kümeleri oluşturan metod
    static void altKume(String str, int index, String curr) {
        int n = str.length();

        if (index == n) {
            System.out.println(curr);
            return;
        }

        altKume(str, index + 1, curr + str.charAt(index));
        altKume(str, index + 1, curr);
    }
    public static void main(String[] args) {
        String s = "ABC";
        permutasyon(s, "");
        altKume(s, 0, "");
    }
}
