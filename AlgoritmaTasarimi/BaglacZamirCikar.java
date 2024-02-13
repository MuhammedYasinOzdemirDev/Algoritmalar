package AlgoritmaTasarimi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaglacZamirCikar {
    public static void baglacZamirCikar(String metin){
        Set<String> baglacZamirler=new HashSet<>(Arrays.asList("ile","ve", "ama", "veya", "ile", "bu", "şu", "o"));
        String[] kelimeler=metin.split("\\s+");//metni kelimelere ayirir
        StringBuilder sonuc=new StringBuilder();//metin olusturmak icin builder olusturlur

        for(String kelime:kelimeler){
            if(!baglacZamirler.contains(kelime))//baglac olmayanlar eklenir
                sonuc.append(kelime).append(" ");//kelime ve bosluk eklenir
        }
        System.out.println(sonuc.toString().trim());
    }
    public static void kisaKelimeleriCikar(String metin,int max){
        String[] kelimeler=metin.split("\\s+");
        StringBuilder sonuc=new StringBuilder();
        for(String kelime:kelimeler){
            if(kelime.length()>max)//baglac olmayanlar eklenir
                sonuc.append(kelime).append(" ");//kelime ve bosluk eklenir
        }
        System.out.println(sonuc.toString().trim());
    }
    public static void main(String args[]){
        String metin="Merhaba ile ve Muhammed";
        baglacZamirCikar(metin);
        kisaKelimeleriCikar(metin,2);
    }
}
