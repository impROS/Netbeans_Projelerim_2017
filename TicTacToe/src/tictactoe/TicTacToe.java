/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author impROS
 */
public class TicTacToe {
public static void main(String args[]) throws Exception
   {
      int board[][] = new int[3][3];
 
      int i, j, flag, row, col, r, c, player, countPlay;
 
      row = 3;
      col = 3;
 
      System.out.println("Oyuna basliyabilirsiniz...");
 
      //oyun tahtasi yazdiriliyor.
      for (i = 0; i < row; i = i + 1) {
         for (j = 0; j < col; j = j + 1) 
            System.out.print(board[i][j] + " ");
         System.out.println();
      }
 
      System.out.println();
 
      flag = 0;
      player = 1;
      countPlay = 0;
 
      while (flag == 0) {
 
         //oyuncu oynayacagi yeri giriyor.
         System.out.println(player + ". oyuncu oynayacak.");
         System.out.print("Satir numarasini giriniz : ");
         r = Keyboard.readInt();
 
         System.out.print("Sutun numarasini giriniz : ");
         c = Keyboard.readInt();
 
         //oyun tahtaya yerlestiriliyor.
         board[r][c] = player;
         countPlay = countPlay + 1;
 
         //oyun bitti mi kontrolu yapiliyor.
         //1. köşegene bakiliyor.
         if (board[0][0] != 0)
            if (board[0][0] == board[1][1])
               if (board[1][1] == board[2][2])
                  flag = 1;
         //2. köşegene bakiliyor.
         if (board[0][2] != 0)
            if (board[0][2] == board[1][1])
               if (board[1][1] == board[2][0])
                  flag = 1;
 
         // Oynanan satir kontrol ediliyor.
         if (board[r][0] == board[r][1])
            if (board[r][1] == board[r][2])
               flag = 1;
 
         // Oynanan sutun kontrol ediliyor.
         if (board[0][c] == board[1][c])
            if (board[1][c] == board[2][c])
               flag = 1;
 
         //oyun tahtasinin son durumu yaziliyor.
         for (i = 0; i < row; i = i + 1) {
            for (j = 0; j < col; j = j + 1) 
               System.out.print(board[i][j] + " ");
            System.out.println();
         }
 
         System.out.println();
         //oyun bittiyse kazanan yaziliyor.
         if (flag == 1)
            System.out.println(player + " nolu oyuncu kazandi.");
 
         //Oyuncu degistiriliyor
         if (player == 1)
            player = 2;
         else
            player = 1;
 
         //veya
         //player = countPlay % 2 + 1;
 
 
         //9 defa oynanmissa ve kazanan yok ise oyun biter.
         if (countPlay == 9)
            if (flag == 0) {
                flag = 1;
                System.out.println("Oyun berabere bitti.");
            }
      }
   }
}