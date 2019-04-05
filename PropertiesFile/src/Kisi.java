/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Kisi {

    private String ad, soyad,telNo,not;

    public Kisi(String ad, String soyad, String telNo, String not) {
        this.ad = ad;
        this.soyad = soyad;
        this.telNo = telNo;
        this.not = not;
    }


    public Kisi() {
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }


    @Override
    public String toString() {
        return ad + " " + soyad + " , " + telNo+" , "+not;
    }

    public String getInfo() {
        return ad + "#" + soyad + "#" + telNo+"#"+not;
    }

    public void putInfo(String strInfo) {
        String[] arrInfo = strInfo.split("#");

        this.setAd(arrInfo[0]);
        this.setSoyad(arrInfo[1]);
        this.setTelNo((arrInfo[2]));
        this.setNot(arrInfo[3]);
    }
}
