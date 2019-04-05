package somunvida;

public class SomunVida {

    public static void main(String[] args) {
        Integer[] arrCivata = {1, 4, 2, 5};
        Double[] arrSomun = {1.1, 4.4, 2.2, 5.5};

        arrCivata = diziSirala(arrCivata);
        //diziGoster(arrVida);

        arrSomun = diziSirala(arrSomun);
       // diziGoster(arrSomun);

        System.out.println("Eşleşme");
        System.out.println("Somun   Vida");
        for (int i = 0; i < arrSomun.length; i++) {
            System.out.println(arrCivata[i] + "          " + arrSomun[i]);

        }

    }
//Generic tipte bir dizi elemanlarini yazan metot tanimladik

    public static <T> void diziGoster(T[] arrTmp) {
        System.out.println("");
        for (T number : arrTmp) {
            System.out.print(number + " - ");
        }
        System.out.println("");
    }
//Yine generic tipte bir dizi siralama metodu tanimladik

    /*
    Bu metot sayilardan tureyen her seyi parametre olarak alabilir..
    ...ve siralayabilir
     */
    public static <T extends Number> T[] diziSirala(T[] arrTmp) {
        for (int i = 0; i < arrTmp.length; i++) {
            for (int j = 0; j < arrTmp.length; j++) {
                /*
                Burda generic tipleri karsilastiramadigimizdan önce Stringe,
                ardından double a cevirdim
                 */
                if (Double.parseDouble(arrTmp[i] + "") < Double.parseDouble(arrTmp[j] + "")) {
                    T tmpNumber = arrTmp[i];
                    arrTmp[i] = arrTmp[j];
                    arrTmp[j] = tmpNumber;
                }
            }
        }
        return arrTmp;
    }

}
