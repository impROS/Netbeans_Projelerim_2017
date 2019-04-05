/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odometer;
import javax.swing.JFrame;
   public class Driver04
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Odometer");
         frame.setSize(400, 400);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Odometer());
         frame.setVisible(true);
      }
   }