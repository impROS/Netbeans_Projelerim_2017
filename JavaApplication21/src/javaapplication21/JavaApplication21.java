package javaapplication21;

public class JavaApplication21 {

    public static void main(String[] args) {
        int[] arrCivata = {1, 2, 5, 6};
        int[] arrSomun = {6, 2, 1, 5};

        arrCivata = diziSırala(arrCivata);
        arrSomun = diziSırala(arrSomun);
        for (int i = 0; i < arrCivata.length; i++) {
            System.out.println("Somun : " + arrSomun[i] + " - Civata : " + arrCivata[i]);
        }
    }

    public static int[] diziSırala(int[] arrtTmp) {
        for (int i = 0; i < arrtTmp.length; i++) {
            for (int j = 0; j < arrtTmp.length; j++) {
                if (arrtTmp[i] < arrtTmp[j]) {
                    int tmp = arrtTmp[i];
                    arrtTmp[i] = arrtTmp[j];
                    arrtTmp[j] = tmp;
                }
            }
        }
        return arrtTmp;
    }

}
