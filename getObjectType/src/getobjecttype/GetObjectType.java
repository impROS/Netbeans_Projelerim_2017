package getobjecttype;

import java.util.ArrayList;

public class GetObjectType {

    public static void main(String[] args) {
        int a = 4;
        float b = 5.0f;
        double c = 5.3;
        String d = "impROS";
        boolean e = true;

        ArrayList<Object> arrObject = new ArrayList<>();

        arrObject.add(a);
        arrObject.add(b);
        arrObject.add(c);
        arrObject.add(d);
        arrObject.add(e);

        compType(arrObject);
    }

    public static void compType(ArrayList<Object> arrTmp) {
        for (Object object : arrTmp) {
            if (object instanceof Integer) {
                System.out.println("Integer");
            } else if (object instanceof String) {
                System.out.println("String");
            } else if (object instanceof Boolean) {
                System.out.println("Boolean");
            } else if (object instanceof Double) {
                System.out.println("Double");
            } else if (object instanceof Float) {
                System.out.println("Float");
            }
        }
    }
}
