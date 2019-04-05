package agac;

import java.util.Random;

public class BinaryTree {

    static int solIndex = 0, sagIndex = 0, aramaMaliyet = 0;

    public static void main(String[] args) {
        Random rnd = new Random();
        Tree root = new Tree(5);
        int sagAgacSayisi = 6;
        int solAgacSayisi = 4;
        for (int i = 6; i < 100; i += 3) {
            //int randomValue = rnd.nextInt(10000000);

            ekle(root, sagAgacSayisi++);
            ekle(root, solAgacSayisi--);
            ekle(root, i);
        }
        System.out.println("Saga Eklenenlerin Sayisi  = " + sagIndex);
        System.out.println("Sola Eklenenlerin Sayisi  = " + solIndex);

        System.out.println("0 arama sonucu = " + search(root, 0));
        System.out.println("1 arama sonucu = " + search(root, 1));
        System.out.println("100 arama sonucu = " + search(root, 100));
        System.out.println("200 arama sonucu = " + search(root, 200));
        System.out.println("400 arama sonucu = " + search(root, 400));
    }

    public static void ekle(Tree node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                ekle(node.left, value);
            } else {
                Tree tmp = new Tree(value);
                node.left = tmp;
                System.out.println(value + " Sol Agaca Eklendi");
                solIndex++;
            }
        } else if (value > node.value) {
            if (node.right != null) {
                ekle(node.right, value);
            } else {
                Tree tmp = new Tree(value);
                node.right = tmp;
                System.out.println(value + " Sag Agaca Eklendi");
                sagIndex++;
            }
        }
    }

    public static boolean search(Tree node, int value) {
        aramaMaliyet = 0;
        boolean sonuc = ara(node, value);
        System.out.println("------------");
        System.out.println("Arama Maliyeti =" + aramaMaliyet);

        return sonuc;
    }

    public static boolean ara(Tree node, int value) {
  
        aramaMaliyet++;
        if (node.value == value) {
            return true;
        } else if (value < node.value) {
            if (node.left == null) {
                return false;
            }
            return ara(node.left, value);
        } else if (value > node.value) {
            if (node.right == null) {
                return false;
            }
            return ara(node.right, value);
        }

        return true;
    }

}
