package DonusturFethet_Algoritmalari;

public class Horner {
    public static int horner(int[] polinom,int n,int x){
        int sonuc=polinom[0];
        for (int i=0;i<n;i++)
            sonuc=sonuc*x+polinom[i];
        return sonuc;
    }
    public static void main(String[] args) {
        int[] poly = {2, -6, 2, -1}; // 2x^3 - 6x^2 + 2x - 1
        int x = 3;
        int n = poly.length;

        System.out.println("Polinomun değeri: " + horner(poly, n, x));
    }
}
