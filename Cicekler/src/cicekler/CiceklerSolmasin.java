package cicekler;

public class CiceklerSolmasin {

    public static void main(String[] args) {
        boolean maviLive = false;
        boolean sariLive = false;
        boolean kirmiziLive = false;
        for (int i = 1; i < 1000; i++) {
            if (i % 4 == 0) {
                kirmiziLive = true;
                System.out.println("Kirmizi Yasiyor");
            } else {
                kirmiziLive = false;
                System.out.println("Kirmizi Oldu");
            }

            if (i % 7 == 0) {
                maviLive = true;
                System.out.println("Mavi Yasiyor");
            } else {
                maviLive = false;
                System.out.println("Mavi Oldu");
            }

            if (i % 13 == 0) {
                sariLive = true;
                System.out.println("Sari Yasiyor");
            } else {
                sariLive = false;
                System.out.println("Sari Oldu");
            }

            if (sariLive && maviLive && kirmiziLive) {
                System.out.println(i + ".Gunde Gel");
                break;
            }
        }
    }
}
