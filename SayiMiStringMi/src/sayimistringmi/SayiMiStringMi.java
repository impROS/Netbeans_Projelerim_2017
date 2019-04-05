package sayimistringmi;

public class SayiMiStringMi {

    public static void main(String[] args) {
        String strTmp = "0O";
        for (char c : strTmp.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.println("Sayi");
            } else {
                System.out.println("String");
            }
        }
    }

}
