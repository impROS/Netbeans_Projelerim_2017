package dizinlisteler;

import java.io.File;

public class DizinListele {

    public static void main(String[] args) {
       //String strFilePath = "D:\\Okul Arşiv\\Programlar";
       String strFilePath = "D:\\Okul Arşiv\\Eğitim Setleri";
        File file = new File(strFilePath);
        File[] arrFiles = file.listFiles();

        for (int i = 0; i < arrFiles.length; i++) {
            System.out.println((i + 1) + "." + arrFiles[i].getName());
        }
    }

}
