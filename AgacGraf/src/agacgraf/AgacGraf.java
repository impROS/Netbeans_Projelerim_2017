package agacgraf;

public class AgacGraf {

    static Node root = new Node();

    public static void main(String[] args) {

        root.setVeri(22);

        ekle(root, 33);
        ekle(root, 3);
        ekle(root, 44);
        ekle(root, 30);
        ekle(root, 29);
        ekle(root, 44);
        ekle(root, 41);
        ekle(root, 46);
        ekle(root, 32);
        ekle(root, 31);
        ekle(root, 42);

//        System.out.println("EnKucukNode = " + enKucukAltAgac(root).getVeri());
//        System.out.println("EnBuyukNode = " + enBuyukAltAgac(root).getVeri());
        agacBul(root, 22).nodeYazdir();
        System.out.println("------------------------");
        agacYazdir(root);
        System.out.println("------------------------");
        //agacBul(root, 44).nodeYazdir();
        sil(33);
        // sil(21);

//
        System.out.println("------------------------");
        agacYazdir(root);
        System.out.println("------------------------");
        sil(31);
        sil(30);

        System.out.println("------------------------");
        agacYazdir(root);
        System.out.println("------------------------");
        agacBul(root, 30).nodeYazdir();
        agacBul(root, 22).nodeYazdir();
    }

    public static void agacYazdir(Node root) {

        if (root != null) {
            System.out.println(root.getVeri());
            agacYazdir(root.getRigt());
            agacYazdir(root.getLeft());

        }

    }

    public static Node agacBul(Node root, int veri) {
        if (root == null) {
            System.out.println(veri + " Bulunamadi.");
            return null;
        }
        if (root.getVeri() == veri) {
            return root;
        } else if ((root.getVeri() > veri)) {
            if (root.getLeft() != null) {
                return agacBul(root.getLeft(), veri);
            }

        } else if ((root.getVeri() < veri)) {
            if (root.getRigt() != null) {
                return agacBul(root.getRigt(), veri);
            }

        }
        System.out.println(veri + " Bulunamadi.");
        return null;
    }

    public static void sil(int veri) {
        Node silNode = agacBul(root, veri);
        System.out.println("Aranan : " + root.getVeri());
        System.out.println("Bulunan: " + silNode.getVeri());
        if (silNode == null) {
        } else {

            //1.Durum ==> Cocugu yok
            if (silNode.getLeft() == null && silNode.getRigt() == null) {
                System.out.println("1.Durum ,Cocugu yok");
                System.out.println("SilNode: " + silNode.getVeri() + ",SilNodeRoot : " + silNode.getRoot().getVeri());
                //System.out.println("SilNodeRigh: "+silNode.getRigt().getVeri()+",SilNodeLeft : "+silNode.getLeft().getVeri());
                if (silNode.getRoot().getLeft() == silNode) {
                    silNode.getRoot().setLeft(null);
                    System.out.println("Sol Agactaki Silindi");
                } else if (silNode.getRoot().getRigt() == silNode) {
                    silNode.getRoot().setRigt(null);
                    System.out.println("Sag Agactaki Silindi");
                } else {
                    System.out.println("Hiçbiri");
                }
            } else if (silNode.getLeft() != null) {
                Node enBuyukNode = enBuyukAltAgac(silNode.getLeft());
                //2.Durum ==> Sol Cocuk var

                System.out.println("2.Durum ==> Sol Cocuk var");

                //a)solun alt agacin, sagi yok.Yani silNode un sol cocugu ile yer degisecek
                if (enBuyukNode.getRoot() == silNode) {
                    System.out.println("a)solun alt agacin sagi yok,yani silNode un sol cocugu ile yer degisecek");
                    enBuyukNode.setRigt(silNode.getRigt());//sagi esitle
                    enBuyukNode.setRoot(silNode.getRoot());//rootu esitle
                    silNode.getRigt().setRoot(enBuyukNode);//silinenin sagi,enbuyugu gostersin
                    if (silNode.getRoot().getLeft() == silNode) {
                        silNode.getRoot().setLeft(enBuyukNode);
                    } else if (silNode.getRoot().getRigt() == silNode) {
                        silNode.getRoot().setRigt(enBuyukNode);
                    }

                    silNode = null;
                } else {
                    if (enBuyukNode.getLeft() != null) {
                        System.out.println("b) sol agacın EnBuyugunun,sol agaci var");
                        enBuyukNode.setRigt(silNode.getRigt());//sag esitlendi
                        enBuyukNode.getRoot().setRigt(enBuyukNode.getLeft());//rootun sagi,enbuyugun solunu gostersin
                        enBuyukNode.getLeft().setRoot(enBuyukNode.getRoot());//enBuyugun solunun rootu,enBuyugunun rootu olsun 
                        enBuyukNode.setLeft(silNode.getLeft());//enbuyugunun solu,bi ustunun sagina esitlendi
                        silNode.getRigt().setRoot(enBuyukNode);
                        if (silNode.getRoot().getRigt() == silNode) {
                            silNode.getRoot().setRigt(enBuyukNode);
                        } else if (silNode.getRoot().getLeft() == silNode) {
                            silNode.getRoot().setLeft(enBuyukNode);
                        }
                    } else {
                        System.out.println("c) sol agacın EnBuyugunun,sol agaci yok");
                        enBuyukNode.setRigt(silNode.getRigt());//sag esitlendi
                        enBuyukNode.getRoot().setRigt(null);//enbuyugun rootun sagi, null gostersin
                        enBuyukNode.setLeft(silNode.getLeft());//sollar esitlendi
                        silNode.getRigt().setRoot(enBuyukNode);
                        if (silNode.getRoot().getRigt() == silNode) {
                            silNode.getRoot().setRigt(enBuyukNode);
                        } else if (silNode.getRoot().getLeft() == silNode) {
                            silNode.getRoot().setLeft(enBuyukNode);
                        }
                    }
                }
            }

        }

    }

    public static void NodeVeriAktar(Node kaynakNode, Node hedefNode) {

    }

    public static Node enKucukAltAgac(Node root) {
        if (root.getLeft() == null) {
            return root;
        } else {
            return enKucukAltAgac(root.getLeft());
        }

    }

    public static Node enBuyukAltAgac(Node root) {
        if (root == null) {
            System.out.println("Bu işte bir yanlışlık var");
            return null;
        }
        if (root.getRigt() == null) {
            return root;
        } else {
            return enBuyukAltAgac(root.getRigt());
        }

    }

    public static void ekle(Node root, int veri) {
        if (veri < root.getVeri()) {
            if (root.getLeft() != null) {
                // System.out.println(root.getVeri() + "\'nin Solu Dolu,tekrar aranıyor..");
                ekle(root.getLeft(), veri);
            } else {
                Node tmp = new Node();
                tmp.setVeri(veri);
                tmp.setRoot(root);
                root.setLeft(tmp);
                // System.out.println(root.getVeri() + "\'nin Soluna  Eklendi : " + root.getLeft().getVeri());

            }
        } else if (veri > root.getVeri()) {
            if (root.getRigt() != null) {
                // System.out.println(root.getVeri() + "\'nin Sagı Dolu,tekrar aranıyor..");
                ekle(root.getRigt(), veri);

            } else {
                Node tmp = new Node();
                tmp.setVeri(veri);
                tmp.setRoot(root);
                root.setRigt(tmp);
                // System.out.println(root.getVeri() + "\'nin Sagına Eklendi : " + root.getRigt().getVeri());

            }
        }
    }

}

class Node {

    private Node left;
    private Node rigt;
    private Node root;
    private int veri;

    public void nodeYazdir() {

        System.out.println("Node Yazdir");
        System.out.print("Veri : " + getVeri());
        if (left != null) {
            System.out.print(", Sol : " + left.getVeri());
        }

        if (rigt != null) {
            System.out.print(", Sag : " + rigt.getVeri());
        }
        if (root != null) {
            System.out.print(", Root : " + root.getVeri());
        }
        System.out.println("");
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRigt() {
        return rigt;
    }

    public void setRigt(Node rigt) {
        this.rigt = rigt;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getVeri() {
        return veri;
    }

    public void setVeri(int veri) {
        this.veri = veri;
    }

}
