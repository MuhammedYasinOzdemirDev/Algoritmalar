package AzaltFethet_Algoritmaları;

public class InsertionSort {
    public static void InsertionSort(int[] dizi){
        for(int i=1;i<dizi.length;i++){
            int mevcut =dizi[i];//dizi siralama işlemi ikinci eleman ile birinci eleman karşılaştırma olarak baslar
            int j=i-1;// ilk eleman j de tanımlanır
            //sonraki donguler de mevcut diger indislere bakılarak j üzeinden ilk elemana kadar dongu olusturlur
            while (j>=0 && dizi[j]>mevcut){// ilk elemana gelmiş mi ve o anci mevcut elemandan buyuk varsa devam eder
                //egerki kucuk varsa dongu biter yer degistirme yapilir
                dizi[j+1]=dizi[j];//eleman kucuk oldugu icin sola kaydırlır
                j--;
            }
            dizi[j+1]=mevcut;//kaybolan deger yazilir
        }
    }
    public static void main(String[] args){
        int[] ornekDizi = {12, 11, 13, 5, 6};
        InsertionSort(ornekDizi);
        for (int eleman : ornekDizi) {
            System.out.print(eleman + " ");
        }
    }
}
