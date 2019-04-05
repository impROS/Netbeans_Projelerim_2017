package enummanav;

public class EnumManav {
    
    public enum Meyve {
        Elma,
        Armut,
        Kayısı
    }
    
    public static void main(String[] args) {
        // faturaYaz(0);
        // boolean isMove =yürüyor;
        faturaYaz(Meyve.Elma);
    }
    
    public static void faturaYaz(Meyve meyveSecim) {
        if (meyveSecim == Meyve.Elma) {
            System.out.println("Elma : 5 Tl");
        } else if (meyveSecim == Meyve.Armut) {
            System.out.println("Armut : 7 Tl");
        } else if (meyveSecim == Meyve.Kayısı) {
            System.out.println("Kayısı: 9 Tl");
        }
    }
    /*
    public static void faturaYaz(int meyveSecim) {
        if (meyveSecim == 1) {
            System.out.println("Elma : 5 Tl");
        } else if (meyveSecim == 2) {
      
        } else if (meyveSecim == 3) {
            System.out.println("Kayısı: 9 Tl");
        }
    }
     */
}
