package agirlikligraf_cozum;

public class Node {
public static int id=0;
    Node gidilebilecekler;
    int ağırlık;

    public Node(Node gidilebilecekler, int ağırlık) {
        id++;
        this.gidilebilecekler = gidilebilecekler;
        this.ağırlık = ağırlık;
    }

}
