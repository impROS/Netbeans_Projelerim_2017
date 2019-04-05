package rastgelefonksiyon;

public class Engel_Yontemi {

    static double uN = 0.1356;
    static double uN1;

    public enum Para {
        Yazı,
        Tura
    }

    public static void main(String[] args) {
        Para para;
        //  for (int i = 0; i < 10; i++) {
        double olasilik = getRandom();
        if (olasilik < 0.7) {
            para = Para.Yazı;
        } else {
            para = Para.Tura;
        }
        System.out.println("Para :" + para);
        System.out.println("Saat:" + System.currentTimeMillis());
        //}

    }

    public static double getRandom() {
        int timeLenght = ("" + System.currentTimeMillis()).length();
        uN = Double.parseDouble("0." + (System.currentTimeMillis() + "").substring(timeLenght - 5, timeLenght-1));
        
        uN1 = Math.pow((uN + Math.PI), 8);

        int indexNokta = (uN1 + "").indexOf(".");
        int indexE = (uN1 + "").indexOf("E");
        if (indexE < 0) {
            indexE = (uN1 + "").length();
        }
        uN1 = Double.parseDouble("0" + (uN1 + "").substring(indexNokta, indexE));
        System.out.println(uN1);
        uN = uN1;

        return uN1;
    }

}
