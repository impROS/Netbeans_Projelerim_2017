package ozyinelemedizi;

public class OzyinelemeDizi {

    public static void main(String[] args) {
        int[] arrTmp = {1, 24, 55, 2, 23, 1, 1, 11, 3};
        diziGoster(arrTmp);
    }

    public static int[] diziGoster(int[] arrTmp) {
        if (arrTmp.length == 0) {
            System.out.println("");
            return null;
        }
        System.out.print(arrTmp[0]+" ");
        int[] arrTmp2 = new int[arrTmp.length - 1];
        for (int i = 1; i < arrTmp.length; i++) {
            arrTmp2[i - 1] = arrTmp[i];
        }
        return diziGoster(arrTmp2);
    }
}
