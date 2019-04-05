package breakdeneme;

public class BreakDeneme {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                 System.out.println(j);
                if (j % 4 == 2) {
   
                    break;
                }
                System.out.println("xxxx");
            }
            System.out.println("ic bitti");
            System.out.println("---------------");
            System.out.println("");
        }
    }

}
