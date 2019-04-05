package kumehesap;

public class KumeHesap {

    public static void main(String[] args) {
        double x1, y1, z1;
        double x2, y2, z2;
        double sonuc, sonuc1, sonuc2, sonuc3;

        x1 = 0.33;
        y1 = 0.0;
        z1 = 0.0;

        x2 = 0.26;
        y2 = 0.43;
        z2 = 0.07;

        sonuc1 = Math.pow((Math.abs(x2 - x1)), 2);
        sonuc2 = Math.pow((Math.abs(y2 - y1)), 2);
        sonuc3 = Math.pow((Math.abs(z2 - z1)), 2);

        sonuc = Math.sqrt(sonuc1 + sonuc2 + sonuc3);
        
        System.out.println("Uzaklik : "+sonuc);

    }

}
