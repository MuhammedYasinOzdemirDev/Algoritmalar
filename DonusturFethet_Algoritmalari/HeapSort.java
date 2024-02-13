package DonusturFethet_Algoritmalari;

public class HeapSort {
    // Diziyi heap sort ile sırala
    public void sort(int[] dizi) {
        int n = dizi.length;
        Heap heap = new Heap();
        heap.buildHeap(dizi, n); // Diziyi heap haline getir

        // Heap'teki her elemanı al ve sırala
        for (int i = n - 1; i >= 0; i--) {
            int temp = dizi[0]; // Kökü al
            dizi[0] = dizi[i]; // Kök ile son elemanı değiştir
            dizi[i] = temp;

            heap.heapify(dizi, i, 0); // Heapify işlemi ile yeni kökü düzelt
        }
    }

    public static void main(String[] args) {
        int[] dizi = {12, 11, 13, 5, 6, 7};
        HeapSort hs = new HeapSort();
        hs.sort(dizi); // Heap sort uygula

        System.out.println("Sıralanmış Dizi: ");
        for (int eleman : dizi) {
            System.out.print(eleman + " ");
        }
    }
}

