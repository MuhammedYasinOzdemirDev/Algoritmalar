package Kaba_Kuvvet_Algoritmalari;

public class Temel_Ornekler {
    public static int usAl(int taban,int us){
        int sonuc=1;
        for(int i=0;i<us;i++)
            sonuc*=taban;   //Tabani girilen us kadar kere carp
        return  sonuc;
    }
    public static int faktoriyel1(int n){  //Normal Çözüm
        int sonuc=1;
        if(n<=1)
            return 1;
        for (int i=2;i< n ;i++)
            sonuc*=i;
        return sonuc;
    }
    public static int faktoriyel2(int n){
        if(n<=1)
            return 1;
        return n*faktoriyel2(n-1);
    }
    public int siraliarma(int[] dizi, int aranan){
        for(int i=0;i<dizi.length;i++){
            if(dizi[i]==aranan)
                return i;
        }
        return -1;
    }
    public static int stringEslesme(String metin,String aranan){
        int m=metin.length();
        int n=aranan.length();
        for(int i=0;i<m-n+1;i++){// string aranan degerin farkı ile baslatılıp sag dogru arama yapilir
            int j;
            for(j=0;j<n;j++){
                if(metin.charAt(i+j)!=aranan.charAt(j))//aranan ve metin kontrol edilir
                    break;
            }
            if(j==n)// j aranan uzunlugu kadar artmissa eslesmis kabul edilir
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(usAl(4,3));
        System.out.println(faktoriyel1(4));
        System.out.println(faktoriyel2(4));
        System.out.println(stringEslesme("Merhaba Benim Adim Yasin","Yasin"));
    }
}
