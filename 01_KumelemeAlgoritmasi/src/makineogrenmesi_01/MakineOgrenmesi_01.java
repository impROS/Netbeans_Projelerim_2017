package makineogrenmesi_01;

import java.util.Scanner;

public class MakineOgrenmesi_01 {

    public static void main(String[] args) {
        String gender = "";
        int age = -1;
        Scanner input = new Scanner(System.in);

        while ((!gender.equalsIgnoreCase("E")) && !gender.equalsIgnoreCase("K")) {

            System.out.println("Cinsiyetinizi Giriniz E/K");
            gender = input.next();
            System.out.println("Gender : " + gender);
        }
        while (age <= 0 || age > 100) {
            System.out.println("Yasinizi Giriniz 0-100");
            age = input.nextInt();
            System.out.println("Age : " + age);
        }
        System.out.println("-------------------");
        if (age < 20) {
            System.out.println("Pokemon Go");
        } else {
            if (gender.equalsIgnoreCase("K")) {
                System.out.println("Whatsapp");
            } else if (gender.equalsIgnoreCase("E")) {
                System.out.println("Snapchat");
            }
        }
        main(null);
    }

}
