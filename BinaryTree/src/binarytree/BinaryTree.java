
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class BinaryTree extends JApplet {

    Dugum kok;
    int i = 0;
    int bul = 0;

    //agac olusturuluyor
    public void init() {
        kok = new Dugum(27);
        ekle(kok, 26);
        ekle(kok, 13);
        ekle(kok, 35);
        ekle(kok, 8);
        ekle(kok, 6);
        ekle(kok, 5);
        ekle(kok, 9);
        ekle(kok, 23);
        ekle(kok, 40);
        ekle(kok, 24);
        ekle(kok, 2);
        ekle(kok, 45);
        ekle(kok, 78);
        ekle(kok, 39);
        ekle(kok, 42);
        ekle(kok, 142);
        ekle(kok, 150);
        setSize(500, 500);

    }

    public void ekle(Dugum dugum, int deger) {
        if (deger < dugum.deger) {
            if (dugum.sol != null) {
                ekle(dugum.sol, deger);
            } else {
                System.out.println(dugum.deger + " soluna " + deger
                        + " eklendi");
                dugum.sol = new Dugum(deger);
            }
        } else if (deger > dugum.deger) {
            if (dugum.sag != null) {
                ekle(dugum.sag, deger);
            } else {
                System.out.println(dugum.deger + " sagina " + deger
                        + " eklendi");
                dugum.sag = new Dugum(deger);
            }
        }
    }

    static class Dugum {

        Dugum sol;
        Dugum sag;
        int deger;

        public Dugum(int deger) {
            this.deger = deger;
        }
    }

    //agacı cızılıyor
    public void paint(Graphics g) {
        // once agac olusturulan agac kırmızı olarak cızılıyor
        agaciCiz(g, kok, 220, 100);

        /*agac boyandıktan sonra sımdı bızım aradıgımız
                eleman ıcın sarı ıle boyama yapılacak ve bulunan dugun yesıl olacak*/
        gezilenAgaciCiz(g, kok, 220, 100, 39);

    }

    public void agaciCiz(Graphics g, Dugum kok, int x, int y) {
        if (kok != null) {

            if (kok.sag != null) {

                dogruCiz(g, x, y, x + 20, y + 40);
            }

            agaciCiz(g, kok.sol, x - 20, y + 40);

            if (kok.sol != null) {

                dogruCiz(g, x, y, x - 20, y + 40);

            }

            gezilmemisDugum(g, String.valueOf(kok.deger), x, y);

            agaciCiz(g, kok.sag, x + 20, y + 40);
        }
    }
// sayı degıskenıne bızım aradıgımız dugumun degerı gırılecek

    public void gezilenAgaciCiz(Graphics g, Dugum kok, int x, int y, int sayi) {
                       if (i != 2) {

                    gezilenDugum(g, String.valueOf(kok.deger), x, y);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    gezilenAgaciCiz(g, kok.sol, x - 20, y + 40, sayi);

                    gezilenDugum(g, String.valueOf(kok.deger), x, y);
                }
                if (i != 2) {
                    gezilenAgaciCiz(g, kok.sag, x + 20, y + 40, sayi);
                }
        if (sayi < kok.deger) {
            if (kok.sol != null) {
                gezilenAgaciCiz(g, kok.sol, x, y, sayi);
            }
        } else if (sayi > kok.deger) {
            if (kok.sag != null) {
                gezilenAgaciCiz(g, kok.sag, x, y, sayi);
            }
        }
            if (kok != null) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (sayi == kok.deger) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    bulunaniBoya(g, String.valueOf(kok.deger), x, y);
                   i = 2;
                }

 
            }
        }
        //agacın tum dugumlerını kırmızıya boyama
    public void gezilmemisDugum(Graphics g, String str, int x, int y) {

        g.setColor(Color.RED);
        g.fillOval(x, y, 26, 26);
        g.setColor(Color.WHITE);
        g.drawString(str, x + 6, y + 17);

    }

    // agacın gezılen dugumunu sarıya boyar
    public void gezilenDugum(Graphics g, String str, int x, int y) {

        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 26, 26);
        g.setColor(Color.RED);
        g.drawString(str, x + 6, y + 17);

    }

    //aradıgımız dugumu bulunca yesıle boyar
    public void bulunaniBoya(Graphics g, String str, int x, int y) {

        g.setColor(Color.GREEN);
        g.fillOval(x, y, 26, 26);
        g.setColor(Color.BLACK);
        g.drawString(str, x + 6, y + 17);

    }

    //dugumler arasında dogru cızer
    public void dogruCiz(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(Color.red);
        g.drawLine(x1 + 15, y1 + 15, x2 + 15, y2 + 15);
    }

}
