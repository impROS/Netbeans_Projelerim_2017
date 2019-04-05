package isimdegisfile;

import java.io.File;

public class IsimDegisFile {

    public static void main(String[] args) {
        String strPath = "aN";
        File file = new File(strPath);
        File[] arrFile = file.listFiles();
        for (int i = 0; i < arrFile.length; i++) {
            System.out.println(arrFile[i].getPath());
            arrFile[i].renameTo(new File(strPath+"\\"+i+".jpg"));
        }
    }

}
