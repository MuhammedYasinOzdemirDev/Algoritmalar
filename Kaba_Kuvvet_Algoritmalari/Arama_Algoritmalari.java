package Kaba_Kuvvet_Algoritmalari;

public class Arama_Algoritmalari {
    public static int binarySearch(int[] dizi,int aranan){
        int sol=0,sag= dizi.length-1;
        while (sol<=sag){
            int orta=(sag+sol)/2;
            if(dizi[orta]==aranan)
                return orta;
            if(dizi[orta]>aranan)
                sag-=orta-1;
            else
                sol+=1+orta;
        }
        return -1;
    }
    public static int linearSearch(int[] dizi, int aranan) {
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] == aranan) {
                return i; // Aranan elemanın indisi
            }
        }
        return -1; // Eleman bulunamazsa -1 döndür
    }
    public static void main(String[] args){
        int[] dizi={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(dizi,4));
        System.out.println(linearSearch(dizi,4));
    }
}
