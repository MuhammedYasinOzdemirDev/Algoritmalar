import java.util.ArrayList;
import java.util.List;

public class ConvexHull{

    // Nokta sınıfı x ve y koordinatlarını tutmak için tanımlanıyor.
    static class Nokta {
        int x, y;

        Nokta(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Convex hull'u hesaplayan ana metod
    public static List<Nokta> convexHull(Nokta[] noktalar) {
        List<Nokta> hull = new ArrayList<>();

        int n = noktalar.length;
        // Eğer nokta sayısı 3'ten az ise convex hull oluşturulamaz.
        if (n < 3) return hull;

        // En sol noktayı bulmak için l'yi başlangıçta ilk nokta olarak ayarlıyoruz.
        int l = 0;
        for (int i = 1; i < n; i++)
            if (noktalar[i].x < noktalar[l].x)
                l = i;

        // Convex hull'u oluşturmak için döngü başlıyor.
        int p = l, q;
        do {
            hull.add(noktalar[p]); // Bulunan noktayı hull listesine ekliyoruz.
            q = (p + 1) % n; // q'yu p'nin bir sonraki noktasına ayarlıyoruz.

            // Tüm noktaları dolaşarak en dış noktayı buluyoruz.
            for (int i = 0; i < n; i++) {
                if (yoneBak(noktalar[p], noktalar[i], noktalar[q]) == 2)
                    q = i;
            }
            p = q; // p'yi q'ya ayarlayarak bir sonraki adıma geçiyoruz.
        } while (p != l); // Başladığımız noktaya dönene kadar döngüyü sürdürüyoruz.

        return hull; // Elde edilen convex hull'u döndürüyoruz.
    }

    // Üç noktanın birbirine göre yönünü belirleyen yardımcı metod
    public static int yoneBak(Nokta p, Nokta q, Nokta r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        // Eğer val 0 ise, üç nokta aynı doğru üzerindedir.
        if (val == 0) return 0;
        // val pozitif ise, yön saat yönünün tersine; negatifse saat yönündedir.
        return (val > 0) ? 1 : 2;
    }

    public static void main(String[] args) {
        // Test için birkaç nokta tanımlıyoruz.
        Nokta[] noktalar = {new Nokta(0, 3), new Nokta(2, 2), new Nokta(1, 1), new Nokta(2, 1), new Nokta(3, 0), new Nokta(0, 0), new Nokta(3, 3)};
        List<Nokta> hull = convexHull(noktalar); // Convex hull hesaplanıyor.
        for (Nokta n : hull)
            System.out.println("(" + n.x + ", " + n.y + ")"); // Convex hull noktaları yazdırılıyor.
    }
}
