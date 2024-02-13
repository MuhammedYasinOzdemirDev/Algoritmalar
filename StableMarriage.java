import java.util.*;

public class StableMarriage {
    // Sabit evlilik bulma algoritmasını uygulayan metod
    public static Map<String, String> sabitEvlilikBul(String[] erkekler, String[] kadinlar, Map<String, List<String>> erkekTercihleri, Map<String, List<String>> kadinTercihleri) {
        Map<String, String> bekârErkekler = new HashMap<>();
        for (String erkek : erkekler) {
            bekârErkekler.put(erkek, null); // Başlangıçta tüm erkekler bekâr
        }

        Map<String, String> nişanlar = new HashMap<>();
        Map<String, List<String>> kadinTercihleriTers = tercihleriTersCevir(kadinTercihleri);

        // Tüm bekâr erkekler bitene kadar döngü devam eder
        while (!bekârErkekler.isEmpty()) {
            String erkek = null;
            for (Map.Entry<String, String> giris : bekârErkekler.entrySet()) {
                if (giris.getValue() == null) {
                    erkek = giris.getKey();
                    break;
                }
            }

            List<String> tercihler = erkekTercihleri.get(erkek);
            for (String kadin : tercihler) {
                if (!nişanlar.containsKey(kadin)) {
                    nişanlar.put(kadin, erkek); // Kadın bekârsa nişanlanırlar
                    bekârErkekler.put(erkek, kadin);
                    break;
                } else {
                    String digerErkek = nişanlar.get(kadin);
                    if (kadinTercihleriTers.get(kadin).indexOf(erkek) < kadinTercihleriTers.get(kadin).indexOf(digerErkek)) {
                        bekârErkekler.put(digerErkek, null); // Kadın daha çok tercih ettiği erkekle nişanlanır
                        nişanlar.put(kadin, erkek);
                        bekârErkekler.put(erkek, kadin);
                        break;
                    }
                }
            }
            bekârErkekler.entrySet().removeIf(giris -> giris.getValue() != null); // Nişanlanan erkekler bekâr listesinden çıkarılır
        }

        return nişanlar;
    }

    // Kadın tercihlerinin sıralamasını tersine çeviren metod
    private static Map<String, List<String>> tercihleriTersCevir(Map<String, List<String>> tercihler) {
        Map<String, List<String>> tersTercihler = new HashMap<>();
        for (Map.Entry<String, List<String>> giris : tercihler.entrySet()) {
            List<String> tersListe = new ArrayList<>(giris.getValue());
            Collections.reverse(tersListe);
            tersTercihler.put(giris.getKey(), tersListe);
        }
        return tersTercihler;
    }

    // Nişanları konsola yazdıran metod
    public static void nişanlarıYazdır(Map<String, String> nişanlar) {
        for (Map.Entry<String, String> giris : nişanlar.entrySet()) {
            System.out.println("Kadın " + giris.getKey() + " Erkek " + giris.getValue() + " ile nişanlı.");
        }
    }

    public static void main(String[] args) {
        String[] erkekler = {"X", "Y", "Z"};
        String[] kadinlar = {"A", "B", "C"};

        // Erkek ve kadın tercihlerinin haritasını oluşturur
        Map<String, List<String>> erkekTercihleri = new HashMap<>();
        erkekTercihleri.put("X", Arrays.asList("A", "B", "C"));
        erkekTercihleri.put("Y", Arrays.asList("B", "A", "C"));
        erkekTercihleri.put("Z", Arrays.asList("A", "B", "C"));

        Map<String, List<String>> kadinTercihleri = new HashMap<>();
        kadinTercihleri.put("A", Arrays.asList("Y", "X", "Z"));
        kadinTercihleri.put("B", Arrays.asList("X", "Y", "Z"));
        kadinTercihleri.put("C", Arrays.asList("X", "Y", "Z"));

        // Sabit evlilik bulur
        Map<String, String> sabitEvlilik = sabitEvlilikBul(erkekler, kadinlar, erkekTercihleri, kadinTercihleri);

        // Nişanları konsola yazdırır
        nişanlarıYazdır(sabitEvlilik);
    }
    }


