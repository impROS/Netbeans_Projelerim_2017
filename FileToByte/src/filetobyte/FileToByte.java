package filetobyte;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author impROS
 */
public class FileToByte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\OpenCvDeneme\\yuz_ornekleri_db\\Deniz\\2.jpg");
        byte[] arrImage = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        System.out.println("Byte Max : " + Byte.MAX_VALUE);
        fis.read(arrImage);
        fis.close();
        int index = 0;
        for (byte b : arrImage) {
        //    System.out.print(b + " ");
            if (index % 100 == 0) {
              //  System.out.println();
            }
            index++;
        }
        System.out.println("Uzunluk : " + arrImage.length);
        System.out.println("---------------------");
        char[] arrHexImage = Hex.encodeHex(arrImage);
        int sayac1 = 0;
        for (int i = 0; i < arrImage.length; i++) {
            //String format = String.format("%02x", arrImage[i]);
            if(arrImage[i]>99){
            sayac1++;
            }
           // System.out.println(arrImage[i]+" "+format);
        }
        System.out.println("Sayac1 : "+sayac1);
    }

}
