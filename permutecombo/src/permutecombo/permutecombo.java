/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutecombo;

import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.Port;

public class permutecombo
{
  static void initiate(String s)
  {
  //  permute("", s);
  //  System.out.println("----------------------------------------- ");
    combo("", s);
    System.out.println("----------------------------------------- ");
  }

  static void combo(String prefix, String s)
  {
    int N = s.length();

    System.out.println(prefix);

    for (int i = 0 ; i < N ; i++)
      combo(prefix + s.charAt(i), s.substring(i+1));
  }
  static void permute(String prefix, String s)
  {
    int N = s.length();

    if (N == 0)
      System.out.println(" " + prefix);

    for (int i = 0 ; i < N ; i++)
      permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
  }
public static Port[][] combinations ( Port[] ports ) {

    List<Port[]> combinationList = new ArrayList<Port[]>();
    // Start i at 1, so that we do not include the empty set in the results
    for ( long i = 1; i < Math.pow(2, ports.length); i++ ) {
        List<Port> portList = new ArrayList<Port>();
        for ( int j = 0; j < ports.length; j++ ) {
            if ( (i & (long) Math.pow(2, j)) > 0 ) {
                // Include j in set
                portList.add(ports[j]);
            }
        }
        combinationList.add(portList.toArray(new Port[0]));
    }
    return combinationList.toArray(new Port[0][0]);
}
  public static void main(String[] args)
  {
//    String s = "abcd";
//    initiate(s);
      
      String a[] = {"ted", "williams", "golden", "voice", "radio"};
        ArrayList<String> result =new ArrayList<>();
        for(int i =0 ;i< a.length; i++){
            String s = "";
            for(int j =i ; j < a.length; j++){
                s += a[j] + " " ;
                result.add(s);
            }
        }
        for (String string : result) {
            System.out.println(string);
      }
  }
}