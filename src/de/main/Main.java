package de.main;

import java.util.Scanner;

import static de.main.TTT.gameOver;

public class Main {
   public static void main(String []args) {
       Scanner scan = new Scanner(System.in);
       de.main.TTT game = new de.main.TTT();
       game.initializeBoard();
       System.out.println("Tic-Tac-Toe!");
       do {
           System.out.println("Current Board Layout:");
           game.printBoard();
           int row;
           int col;
           do {
               System.out.println("Player " + game.getCurrentPlayerMark() + ", enter an empty row and column to place your mark!");
               row = scan.nextInt() - 1;
               col = scan.nextInt() - 1;
           }
           while (!game.placeMark(row, col));
           game.changePlayer();

       }
       while (!gameOver(game));
       if (game.isBoardFull() && !game.checkForWin()) {
           System.out.println("The game was a tie!");
       } else {
           System.out.println("Current Board layout:");
           game.printBoard();
           game.changePlayer();
           System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");
       }
   }
}
