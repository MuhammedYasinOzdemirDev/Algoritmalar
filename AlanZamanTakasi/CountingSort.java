package AlanZamanTakasi;

import java.util.Arrays;

public class CountingSort {
    public static int[] CountingSort(int[] dizi){
        int max= Arrays.stream(dizi).max().getAsInt();   // Dizinin en büyük elemanını buluyoruz.
        int min=Arrays.stream(dizi).min().getAsInt();    // Dizinin en kucuk elemanını buluyoruz.

        int aralik=max-min+1;   //Sayi araligini hesapliyoz
        int[] countArray=new int[aralik];

        for(int i=0;i< dizi.length;i++)
            countArray[dizi[i]-min]++;//Burada kac adet gectigini sayiyoz

        for(int i=1;i<aralik;i++)//Kumulatif toplam hesabi
            countArray[i]+=countArray[i-1];
        int[] sortedArray=new int[dizi.length];
        // Orijinal diziyi sondan başa doğru tarayarak sıralıyoruz.
        for (int i = dizi.length - 1; i >= 0; i--) {
            sortedArray[countArray[dizi[i] - min] - 1] = dizi[i];
            countArray[dizi[i] - min]--;
        }

        return sortedArray;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Orijinal Dizi: " + Arrays.toString(arr));

        arr=CountingSort(arr);

        System.out.println("Sıralanmış Dizi: " + Arrays.toString(arr));
    }
}
