import java.util.*;

/*
Muhammed Yasin Özdemir
Bu sorunun çözümünde Bellman-Ford algoritması kullanılmıştır.

Bu algoritmanın amacı, bir graf üzerindeki, bir kaynaktan bir hedefe giden en kısa yolu bulmaktır.
Algoritma ağırlıklı graflar üzerinde çalışır ve bir anlamda Dijkstra algoritmasının iyileştirilmişi olarak düşünülebilir.

Algoritma aslında Dijkstra algoritmasından daha kötü bir performansa sahiptir ancak graftaki ağırlıkların eksi olması durumunda Dijkstra’nın tersine başarılı çalışır.
*/

public class Main {

    static class Edge {
        char source, destination;
        int weight;

        Edge(char source, char destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        List<Edge> edges;
        Set<Character> vertices;

        Graph() {
            edges = new ArrayList<>();
            vertices = new HashSet<>();
        }

        void addEdge(char source, char destination, int weight) {
            edges.add(new Edge(source, destination, weight));
            vertices.add(source);
            vertices.add(destination);
        }
    }

    static void bellmanFord(Graph graph, char source) {
        Map<Character, Integer> distance = new HashMap<>();

        for (char vertex : graph.vertices) {
            distance.put(vertex, Integer.MAX_VALUE);
        }

        distance.put(source, 0);

        for (int i = 0; i < graph.vertices.size() - 1; i++) {
            for (Edge edge : graph.edges) {
                if (distance.get(edge.source) != Integer.MAX_VALUE &&
                        distance.get(edge.source) + edge.weight < distance.get(edge.destination)) {
                    distance.put(edge.destination, distance.get(edge.source) + edge.weight);
                }
            }
        }


        System.out.println("\n\n\nEn kısa yollar:");
        for (char vertex : graph.vertices) {
            System.out.println("Guzergah " + source + " - " + vertex + ": " + distance.get(vertex));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        setEdge(graph);
        char sourceVertex = 'A';

        System.out.println("Bellman-Ford Algoritması ile En Kısa Yol Hesaplama:");
        System.out.println("Graf:");
        for (Edge edge : graph.edges) {
            System.out.println(edge.source + " -> " + edge.destination + ": " + edge.weight);
        }

        bellmanFord(graph, sourceVertex);
    }

    static void setEdge(Graph graph)
    {
        graph.addEdge('A', 'B', -270);
        graph.addEdge('A', 'C', 250);
        graph.addEdge('A', 'D', 2000);

        graph.addEdge('B', 'I', 1800);

        graph.addEdge('C', 'B', 0);
        graph.addEdge('C', 'H', 290);
        graph.addEdge('C', 'I', 2000);

        graph.addEdge('D', 'C', -750);
        graph.addEdge('D', 'E', 2700);

        graph.addEdge('E', 'C', -450);
        graph.addEdge('E', 'F', 1200);

        graph.addEdge('F', 'G', 7000);
        graph.addEdge('F', 'L', 500);

        graph.addEdge('G', 'H', -1300);

        graph.addEdge('H', 'I', 2500);
        graph.addEdge('H', 'J', 2500);

        graph.addEdge('I', 'J', 2000);

        graph.addEdge('J', 'O', -270);

        graph.addEdge('K', 'H', 500);
        graph.addEdge('K', 'J', -2200);
        graph.addEdge('K', 'M', 900);

        graph.addEdge('L', 'G', 350);
        graph.addEdge('L', 'K', 10000);
        graph.addEdge('L', 'M', 1500);
        graph.addEdge('L', 'Q', 400);

        graph.addEdge('M', 'N', 0);
        graph.addEdge('M', 'P', 450);

        graph.addEdge('N', 'J', 2200);
        graph.addEdge('N', 'O', 3200);

        graph.addEdge('O', 'T', -3200);

        graph.addEdge('P', 'O', 2600);
        graph.addEdge('P', 'S', 180);

        graph.addEdge('Q', 'M', -550);
        graph.addEdge('Q', 'P', 1000);
        graph.addEdge('Q', 'R', -700);

        graph.addEdge('R', 'S', -400);
        graph.addEdge('R', 'U', 550);

        graph.addEdge('S', 'T', 480);
        graph.addEdge('S', 'U', 500);

        graph.addEdge('U', 'T', -270);
    }
}