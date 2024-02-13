package Kaba_Kuvvet_Algoritmalari;

public class EnYakinCift_Problemi {
    public static class Nokta{
        Double x,y;
        public Nokta(Double x,Double y){
            this.x=x;
            this.y=y;
        }
    }
    public static Double EnYakinMesafeBul(Nokta a1,Nokta a2){
        return Math.sqrt(Math.pow((a1.x-a2.x),2)+Math.pow(a1.y-a2.y,2));
    }
    public static Double EnYakinCiftiBul(Nokta[] noktalar){
        Double minMesafe=Double.MAX_VALUE;
        for(int i=0;i<noktalar.length;i++){
            for(int j=i+1;j<noktalar.length;j++)
            {
                double mesafe=EnYakinMesafeBul(noktalar[i],noktalar[j]);
                if(mesafe<minMesafe)
                    minMesafe=mesafe;
            }
        }
        return minMesafe;
    }
    public  static void main(String[] args){
        Nokta[] noktalar = {new Nokta(1.0, 2.0), new Nokta(3.0, 4.0), new Nokta(5.0, 6.0), new Nokta(7.0, 8.0)};
        double minMesafe = EnYakinCiftiBul(noktalar);
        System.out.println("En yakın nokta çiftinin mesafesi: " + minMesafe);
    }
    }

