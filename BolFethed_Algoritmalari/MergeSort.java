package BolFethed_Algoritmalari;

import java.util.Arrays;

public class MergeSort {

    // Diziyi birleştirme
    private static void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Geçici diziler
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Verileri geçici dizilere kopyalama
        System.arraycopy(array, l + 0, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        // Geçici dizileri birleştirme
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Kalan elemanları kopyalama
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Birleştirmeli sıralama
    public static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6, 7 };
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}

