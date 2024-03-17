package com.veoow.game;

import com.veoow.player.Player;

import java.util.Scanner;

public class GameController {
    public static boolean hasWinner;

    Scanner sc = new Scanner(System.in);
    Board board = new Board();

    public void start() {
        System.out.print("Player 1 name: ");
        String playerOneName = sc.nextLine();
        Player player1 = new Player(playerOneName, "*");
        System.out.print("Player 2 name: ");
        String playerTwoName = sc.nextLine();
        Player player2 = new Player(playerTwoName, "+");

        System.out.printf("Hello %s and %s, have a nice game \n \n", player1.getPlayer(), player2.getPlayer());

        board.drawBoard();
        changeTurn(player1, player2);
    }
    public void changeTurn(Player player1, Player player2) {
        int lastTurnPlayer = 2;

        while (!hasWinner) {
            if (lastTurnPlayer == 1) {

                System.out.printf("Is it your turn %s: ", player2.getPlayer());
                String move = sc.nextLine();
                System.out.println();

                int x = Integer.parseInt(move.substring(0,1));
                int y = Integer.parseInt(move.substring(1,2));
                boolean moved = player2.movement(x, y);
                if (moved) {
                    board.drawBoard();
                    lastTurnPlayer = 2;
                };
            } else {
                System.out.printf("Is it your turn %s: ", player1.getPlayer());
                String move = sc.nextLine();
                System.out.println(move.substring(1,1));

                int x = Integer.parseInt(move.substring(0,1));
                int y = Integer.parseInt(move.substring(1,2));
                boolean moved = player1.movement(x, y);
                if (moved) {
                    board.drawBoard();
                    lastTurnPlayer = 1;
                };
            }
        }
    }
    public void endGame(String winner, Boolean draw) {
        sc.close();

        if (draw) {
            System.out.println("It looks like there was a draw!");
        } else {
            System.out.println("You win! " + winner);
        }
    }
}

