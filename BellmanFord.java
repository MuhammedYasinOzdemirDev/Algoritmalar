import java.util.Arrays;

// Edge sınıfı bir kenarı temsil eder
class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

// BellmanFord sınıfı algoritmanın uygulanmasını sağlar
public class BellmanFord {
    int vertices;
    Edge[] edges;

    public BellmanFord(int vertices, Edge[] edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void findShortestPaths(int source) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Relax all edges |V| - 1 times.
        for (int i = 1; i < vertices; ++i) {
            for (Edge edge : edges) {
                if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.destination]) {
                    distances[edge.destination] = distances[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative-weight cycles.
        for (Edge edge : edges) {
            if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.destination]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        printSolution(distances, source);
    }


    public void printSolution(int[] distances, int source) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertices; i++)
            System.out.println(indexToChar(i) + "\t\t" + (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
    }

    // Bu fonksiyon sayısal indisleri karakterlere çevirir
    private char indexToChar(int index) {
        return (char) ('A' + index);
    }

    public static void main(String[] args) {
        // Düğüm ve kenarları burada tanımlayın
        int vertices = 21; // 'A' dan 'U' ya kadar toplam 21 düğüm
        Edge[] edges = {
                new Edge(0, 1, -270),
                new Edge(0, 2, 250),
                new Edge(0, 3, 2000),
                new Edge(1, 8, 1800),
                new Edge(2, 1, 0),
                new Edge(2, 7, 290),
                new Edge(2, 8, 2000),
                new Edge(3, 2, -750),
                new Edge(3, 4, 2700),
                new Edge(4, 2, -450),
                new Edge(4, 5, 1200),
                new Edge(5, 6, 7000),
                new Edge(5, 11, 500),
                new Edge(6, 7, -1300),
                new Edge(7, 8, 2500),
                new Edge(7, 9, 2500),
                new Edge(8, 9, 2000),
                new Edge(9, 14, -270),
                new Edge(10, 7, 500),
                new Edge(10, 9, -2200),
                new Edge(10, 12, 900),
                new Edge(11, 6, 350),
                new Edge(11, 10, 10000),
                new Edge(11, 12, 1500),
                new Edge(11, 16, 400),
                new Edge(12, 13, 0),
                new Edge(12, 15, 450),
                new Edge(13, 9, 2200),
                new Edge(13, 14, 3200),
                new Edge(14, 19, -3200),
                new Edge(15, 14, 2600),
                new Edge(15, 18, 180),
                new Edge(16, 12, -550),
                new Edge(16, 15, 1000),
                new Edge(16, 17, -700),
                new Edge(17, 18, -400),
                new Edge(17, 20, 550),
                new Edge(18, 19, 480),
                new Edge(18, 20, 500),
                new Edge(20, 19, -270),
        };

        BellmanFord graph = new BellmanFord(vertices, edges);
        graph.findShortestPaths(0); // 0 numaralı düğümden (A) başlayarak en kısa yolları bul
    }
}
