package DonusturFethet_Algoritmalari;

public class Heap {
    public void heapify(int[] dizi,int n ,int i){//dugumu uygun konuma yerlestirmeye yariyor
        int enBuyuk=i;//baslangicda en buyuk eleman mevcut dügum kabul ediyoz
        int sol=2*i+1;//sol cocugun indisi mesela 0 ise 1 1 ise 3
        int sag=2*i+2;//sag cocugun indisi

        if(sol<n && dizi[sol]>dizi[enBuyuk])
            enBuyuk=sol;//sol cocuk mevcutsa ve mevcut dugumden buyjsej enbuyuk sol yapilir
        // Sağ çocuk mevcutsa ve mevcut düğümden büyükse, en büyük olarak güncelle
        if (sag < n && dizi[sag] > dizi[enBuyuk])
            enBuyuk = sag;
        //Eğer en büyük eleman mevcut düğüm değilse, yerlerini değiştir
        if (enBuyuk != i) {
            int swap = dizi[i];
            dizi[i] = dizi[enBuyuk];
            dizi[enBuyuk] = swap;

            // Alt ağacı tekrar heapify yap
            heapify(dizi, n, enBuyuk);//bu sekilde en buyuk koke alnır yukardan asga devarm eder
        }
    }

    // Verilen diziyi heap haline getir
    public void buildHeap(int[] dizi, int n) {
        int baslangicIndexi = (n / 2) - 1; // Son ebeveyn düğümün indeksi

        // Son ebeveyn düğümden başlayarak heapify uygula
        for (int i = baslangicIndexi; i >= 0; i--) {
            heapify(dizi, n, i);
        }
    }
    public void deleteRoot(int[] dizi, int n) {//koku siler tekrar kok belirler
        int sonEleman = dizi[n - 1]; // Dizinin son elemanını al
        dizi[0] = sonEleman; // Kökü son eleman ile değiştir
        n = n - 1; // Heap boyutunu azalt

        heapify(dizi, n, 0); // Yeniden heapify uygula
    }
}
