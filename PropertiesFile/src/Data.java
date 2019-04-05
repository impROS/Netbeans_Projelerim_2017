/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author impROS
 */
public class Data {

    private static Properties prop = null;
    private static OutputStream outputFile = null;
    private static InputStream inputFile = null;
    private static int ID = 0;
    private static String strDataPath;

    public static Properties getProp() {
        return prop;
    }

    public static void setProp(Properties prop) {
        Data.prop = prop;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Data.ID = ID;
    }

    public static String getStrDataPath() {
        return Data.strDataPath;
    }

    public static void setStrDataPath(String strDataPath) {
        Data.strDataPath = strDataPath;
    }

    public Data() {
    }

    public Data(String stringPathString) {
        setStrDataPath(stringPathString);
        createDatabase(stringPathString);
    }

    void createDatabase(String strPath) {

        if (prop == null) {
            System.out.println("Prop Null");
            try {
                prop = new Properties();

                System.out.println("333333333333333333333333333333");
                inputFile = new FileInputStream(strPath);
                prop.load(inputFile);
                System.out.println("555555555555555555555555555555555");

            } catch (FileNotFoundException ex) {
                System.err.println("Database Bulunamadi.Yeni Olusturulacak");
                //Hata(ex);
            } catch (IOException ex) {
                Hata(ex);
            } finally {

                try {
                    System.out.println("Hatagg");
                    outputFile = new FileOutputStream(strPath);
                    System.err.println("Yeni Database Basariyla Olusturuldu");
                } catch (FileNotFoundException ex) {
                    Hata(ex);
                }
            }
            try {

                System.out.println();
                setID(Integer.parseInt(getProp().getProperty("ID")));;
            } catch (Exception e) {
                setID(0);
                prop.setProperty("ID", ID + "");
            }
            System.out.println("ID basariyla atandi : " + getID());
        }
    }

    String get(int key) {
        return getProp().getProperty(key + "");
    }

    void remove(int value) {
        getProp().remove(value + "");

    }

    public ArrayList<String> listAll() {
        ArrayList<String> arrTmpData = new ArrayList<>();
        for (int i = 0; i < getID(); i++) {
            String strData = getProp().getProperty(("" + i));
            if (strData != null) {
                System.out.println(i + "." + strData);
                arrTmpData.add(strData);
            }

        }
        return arrTmpData;
    }

    public void add(String strData) {
        createDatabase(getStrDataPath());
        try {
            ArrayList<String> arrData = listAll();
            prop = new Properties();
            System.out.println("Data Yer : " + getStrDataPath());
            inputFile = new FileInputStream(getStrDataPath());
            prop.load(inputFile);
            for (int i = 0; i < arrData.size(); i++) {
                prop.setProperty((i + 1) + "", arrData.get(i));
            }
            setID(arrData.size());
            prop.setProperty((++ID) + "", strData);
            prop.setProperty("ID", ++ID + "");
            prop.store(outputFile, null);
            frmMain.lblDurum.setText("Kayit Basariyla Eklendi.");
            this.setProp(null);
            arrData.add(strData);
            frmMain.df.clear();

            for (String tmpData : arrData) {
                System.out.println("Data");
                String[] tmparrData = tmpData.split("#");
                if (tmparrData.length > 3) {
                    System.out.println("tmpdata : " + tmparrData.length);
                    String fixData = tmparrData[0] + " " + tmparrData[1] + ",Tel : " + tmparrData[2] + ",Not : " + tmparrData[3];
                    frmMain.df.addElement(fixData);
                }

            }
        } catch (IOException ex) {
            Hata(ex);

        }
    }

    public void getData() {

        ArrayList<String> arrData = listAll();
        System.out.println("Size : " + arrData.size());
        frmMain.df.clear();

        for (String tmpData : arrData) {
            System.out.println("Data : " + tmpData);
            String[] tmparrData = tmpData.split("#");
            if (tmparrData.length > 3) {
                System.out.println("tmpdata2 : " + tmparrData.length);
                String fixData = tmparrData[0] + " " + tmparrData[1] + ",Tel : " + tmparrData[2] + ",Not : " + tmparrData[3];
                frmMain.df.addElement(fixData);
            }
        }
    }

    private void Hata(Exception ex) {
        frmMain.lblDurum.setText("Hata : " + ex.getMessage()
                + "\n" + ex.getStackTrace()[0]
                + "\n" + ex.getStackTrace()[1]
                + "\n" + ex.getStackTrace()[2]
                + "\n" + ex.getStackTrace()[3]
                + "\n" + ex.getStackTrace()[4]
                + "\n" + ex.getStackTrace()[5]
                + "\n" + ex.getStackTrace()[6]);

        System.err.println("Hata : " + ex.getMessage()
                + "\n" + ex.getStackTrace()[0]
                + "\n" + ex.getStackTrace()[1]
                + "\n" + ex.getStackTrace()[2]
                + "\n" + ex.getStackTrace()[3]
                + "\n" + ex.getStackTrace()[4]
                + "\n" + ex.getStackTrace()[5]
                + "\n" + ex.getStackTrace()[6]);
    }
}
