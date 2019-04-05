package pkg8_vezir;

public class Main {

    public static void main(String[] args) {
        String[][] arrTahta = new String[4][4];
        System.out.println(arrTahta.length);
        System.out.println(arrTahta[0].length);
        hazirla(arrTahta);
        goster(arrTahta);
        hamleSinirla(arrTahta, "0,0");
        goster(arrTahta);
    }

    public static void hazirla(String[][] arrTahta) {
        for (int i = 0; i < arrTahta.length; i++) {
            for (int j = 0; j < arrTahta[0].length; j++) {
                arrTahta[i][j] = "0";
            }

        }
    }

    public static void hamleSinirla(String[][] arrTahta, String strHamle
    ) {
        int noktaIndex = strHamle.indexOf(",");
        int satir = Integer.parseInt(strHamle.substring(0, noktaIndex));
        System.out.println("Satir : " + satir);

        int sutun = Integer.parseInt(strHamle.substring(noktaIndex + 1, strHamle.length()));
        System.out.println("Sutun : " + sutun);

        for (int i = 0; i < arrTahta.length; i++) {
            arrTahta[satir][i] = "1";
        }
        /*
        1,2
        
        1,1
        2,1
        2,3
        0,3
        
        
        */
        for (int i = 0; i < arrTahta[0].length; i++) {
            arrTahta[i][sutun] = "1";
        }
        int solCapraz = satir;
        for (int i = 0; i < arrTahta.length; i++) {
            for (int j = 0; j < arrTahta[0].length; j++) {
//                arrTahta[satir+]
            }
        }
    }

    public static void goster(String[][] arrTahta) {
        for (int i = 0; i < arrTahta.length; i++) {
            for (int j = 0; j < arrTahta[0].length; j++) {
                System.out.print(arrTahta[i][j] + "  ");
            }
            System.out.println("");

        }
    }
}
