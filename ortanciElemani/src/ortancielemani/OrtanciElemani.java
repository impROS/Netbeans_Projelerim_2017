/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortancielemani;

/**
 *
 * @author impROS
 */
public class OrtanciElemani {

    public static void main(String[] args) {
        double[] arrSayilar = {71, 23, 2, 2, 3, 4, 1, 1, 1, 4, 2, 2, 14};
        System.out.println("Benzersiz Eleman Sayisi : " + benzersizElemanSayisi(arrSayilar));
        double[] tmp = benzersizElemanBul(arrSayilar, benzersizElemanSayisi(arrSayilar));
        System.out.println("Benzersiz Elemanlar : ");
        tmp = shortArray(tmp);
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " , ");
        }
    }

    public static void ortanci(double[] arrTmp) {

    }

    public static boolean varMi(double[] arrTmp, double sayi) {
        for (int i = 0; i < arrTmp.length; i++) {
            if (arrTmp[i] == sayi) {
                return true;
            }
        }
        return false;
    }

    public static double[] shortArray(double[] arrTmp) {
        for (int i = 0; i < arrTmp.length; i++) {
            for (int j = 0; j < arrTmp.length; j++) {
                if (arrTmp[j] > arrTmp[i]) {
                    double tmp = arrTmp[i];
                    arrTmp[i] = arrTmp[j];
                    arrTmp[j] = tmp;
                }
            }
        }
        return arrTmp;
    }

    public static double[] benzersizElemanBul(double[] arrTmp, int diziBoyutu) {

        double[] arrBenzersiz = new double[diziBoyutu];
        for (int i = 0; i < arrTmp.length; i++) {
            if (!varMi(arrBenzersiz, arrTmp[i])) {
                System.out.println("Dizi Boyutu : " + (--diziBoyutu) + ",i : " + i);
                System.out.println("Eklenecek Sayi : " + arrTmp[i]);
                arrBenzersiz[diziBoyutu] = arrTmp[i];
            }
        }
        return arrBenzersiz;
    }

    public static int benzersizElemanSayisi(double[] arrTmp) {
        if (arrTmp.length == 0) {
            return 0;
        }
        if (arrTmp.length == 1) {
            return 1;
        }
        // System.out.println("Length: " + arrTmp.length);
        int sayac = 0;
        for (int i = 0; i < arrTmp.length; i++) {
            //System.out.println("for1");
            for (int j = i; j < arrTmp.length; j++) {
                // System.out.println("for2");
                if (i != j) {

                    if (arrTmp[i] != arrTmp[j]) {
                        if (j == arrTmp.length - 1) {
                            sayac++;
                            System.out.println("Karsilastirilan : " + arrTmp[i] + " , " + arrTmp[j] + " : " + (arrTmp[i] == arrTmp[j]));
                            System.out.println("Sayac Artti : " + sayac);
                        }
                    } else {

                        //   System.out.println("Break");
                        break;
                    }

                }
                if (arrTmp[i] == arrTmp[j]) {
                    if (j == arrTmp.length - 1) {
                        sayac++;
                    }
                }

            }
            //   System.out.println("-------------------");
        }
        return sayac;
    }

}
