/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odevsev;

import java.util.Arrays;
import java.util.Scanner;

public class Personel {

    private int personelNo;
    private String isim;
    private double brutMaas;
    private double kesintiMiktari;
    private double maasHesapla;

    Scanner klavye = new Scanner(System.in);

    public Personel() {
        isim = "";
        personelNo = 0;
        brutMaas = 0;
        kesintiMiktari = 0;
        maasHesapla = 0;
    }

    public Personel(int per, String ad) {
        personelNo = per;
        isim = ad;
    }

    public int getPersonelNo() {
        return personelNo;
    }

    public void setPersonelNo(int personelNo) {
        this.personelNo = personelNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getBrutMaas() {
        return brutMaas;
    }

    public void setBrutMaas(double brutMaas) {
        this.brutMaas = brutMaas;
    }

    public double getKesintiMiktari() {
        return kesintiMiktari;
    }

    public void setKesintiMiktari(double kesintiMiktari) {
        this.kesintiMiktari = kesintiMiktari;
    }

    public double getMaasHesapla() {
        return maasHesapla;
    }

    public void setMaasHesapla(double maasHesapla) {
        this.maasHesapla = maasHesapla;
    }

    public Scanner getKlavye() {
        return klavye;
    }

    public void setKlavye(Scanner klavye) {
        this.klavye = klavye;
    }

    public void bilgiOku() {
        System.out.println("Personel numaranızı giriniz:");
        personelNo = klavye.nextInt();
        System.out.println("isminizi giriniz:");
        isim = klavye.next();
        System.out.println("Brüt maaşınızı giriniz:");
        brutMaas = klavye.nextDouble();
        System.out.println("Maaş kesinti miktarını giriniz:");
        kesintiMiktari = klavye.nextDouble();

    }

    public void bilgiYaz() {
        System.out.println("Personel numarası=" + personelNo);
        System.out.println("personel ismi=" + isim);
        maasHesapla = brutMaas - kesintiMiktari;
        System.out.println("Total=" + maasHesapla);

    }
}
