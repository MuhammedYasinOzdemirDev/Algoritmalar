package Kaba_Kuvvet_Algoritmalari;

public class Siralama_Algoritmalari {
    public static void selectionSort(int[] dizi){
        int n =dizi.length;
        for(int i=0;i<n;i++){
            int min_indis=i;//minumum indis default belirleniyor i
            for(int j=i+1;j<n;j++){
                if(dizi[j]<dizi[min_indis])//o indisdeki en kucuk eleman bulunuyor
                    min_indis=j;
            }
            int temp =dizi[min_indis];//yer degistirme
            dizi[min_indis]=dizi[i];
            dizi[i]=temp;
        }
    }
    public static void bubbleSort(int[] dizi){
        int n=dizi.length;
        for(int i=0;i<n;i++){
            for (int j=0;j<n-i-1;j++){
                if(dizi[j]>dizi[j+1]){
                    int temp=dizi[j];
                    dizi[j]=dizi[j+1];
                    dizi[j+1]=temp;
                }
            }
        }
    }
    public static void Yazdir(int[] dizi){
        for(int i=0;i<dizi.length;i++)
            System.out.print(dizi[i]+"\t");
        System.out.println();
    }
    public static void main(String[] args){
        int[] dizi={4,8,2,85,2,11,45,24,12,101,10,1,65,14};
       selectionSort(dizi);
       Yazdir(dizi);
        int[] dizi2={4,8,2,85,2,11,45,24,12,101,10,1,65,14};
        bubbleSort(dizi2);
        Yazdir(dizi2);

    }
}
