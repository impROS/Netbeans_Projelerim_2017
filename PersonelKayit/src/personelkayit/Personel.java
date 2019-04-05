package personelkayit;

public class Personel {

    private String ad;
    private double brutMaas, netMaas, kesintiMiktari;

    public double netMaasHesapla() {
        netMaas = brutMaas - kesintiMiktari;
        return netMaas;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
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

}
