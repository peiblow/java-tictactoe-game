package com.veoow.player;

import com.veoow.game.Board;

public class Player {
    private final String name;
    public String identifier;

    public Player (String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    public String getPlayer() {
        return this.name;
    }

    public boolean movement(Integer x, Integer y) {
        if (insideBoard(x, y)) {
            Coordinate movement = new Coordinate(x, y);
            return Board.updateBoard(movement, this.identifier, this.name);
        }

        return false;
    }

    private boolean insideBoard(Integer x, Integer y) {
        if (x >= 3 || y >= 3) {
            System.out.println("Sorry, but it is a invalid coordinate");
            return  false;
        }

        return  true;
    }
}
