package com.veoow.game;

import com.veoow.player.Coordinate;

import java.util.Objects;

public class Board {
    private static final String[][] board = new String[3][3];
    public static int movements = 0;

    public void drawBoard() {
        for (String[] row : board) {
            for (String value : row) {
                if (value == null) {
                    System.out.print("  " + " |");
                } else {
                    System.out.print(" " + value + " |");
                }
            }
            System.out.println();
        }
    }
    public static boolean updateBoard(Coordinate coordinate, String player, String playerName) {
        if (board[coordinate.x][coordinate.y] == null) {
            board[coordinate.x][coordinate.y] = player;

            movements++;
            verifyBoard(playerName, player, coordinate.x, coordinate.y);

            return true;
        } else {
            System.out.println("Sorry but this position already marked! Please choose another one");
        }

        return false;
    }

    private static void verifyBoard (String playerName, String player, int x, int y) {
        int row = 0;
        int col = 0;
        int diag = 0;
        int rdiag = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[x][i], player)) {
                col++;
            }

            if (Objects.equals(board[i][y], player)) {
                row++;
            }

            if (Objects.equals(board[i][i], player)) {
                diag++;
            }

            if (Objects.equals(board[i][3 - i - 1], player)) {
                rdiag++;
            }
        }

        if (movements == 9) {
            GameController gameController = new GameController();
            GameController.hasWinner = true;
            gameController.endGame(playerName, true);
        }

        if (row == 3 || col == 3 || diag == 3 || rdiag == 3) {
            GameController gameController = new GameController();
            GameController.hasWinner = true;
            gameController.endGame(playerName, false);
        }
    }
}
