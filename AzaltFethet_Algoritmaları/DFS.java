package AzaltFethet_Algoritmaları;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DFS {
    private final int V; // Düğüm sayısı
    private final ArrayList<ArrayList<Integer>> adj; // Kenar listesi

    // Constructor
    DFS(int v) {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Kenar eklemek için yardımcı metod
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Topolojik sıralamayı gerçekleştiren metod
    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        // Mevcut düğümü ziyaret edildi olarak işaretleme
        visited[v] = true;
        Integer i;

        // Komşu düğümleri ziyaret etme
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Tüm komşuları ziyaret edildikten sonra, stack'e ekleme
        stack.push(Integer.valueOf(v));
    }

    // Topolojik sıralamayı dışarıdan çağırmak için metod
    void topologicalSort() {
        Stack<Integer> stack = new Stack<Integer>();

        // Tüm düğümleri başlangıçta ziyaret edilmemiş olarak işaretleme
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // DFS kullanarak topolojik sıralama yapma
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        // Stack'teki elemanları sırayla çıkararak sıralama yapma
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        // Örnek graf ve topolojik sıralama
        DFS g = new DFS(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topolojik sıralama:");
        g.topologicalSort();
    }

}
