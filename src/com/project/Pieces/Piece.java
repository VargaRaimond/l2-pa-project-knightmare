package com.project.Pieces;

public abstract class Piece {
    private int x_pos;
    private int y_pos;
    Boolean isWhite;

    public Piece(final int x, final int y) {
        x_pos = x;
        y_pos = y;
        isWhite = false;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }
    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public Boolean isWhite() {
        return isWhite;
    }

    public void setWhite(Boolean white) {
        isWhite = white;
    }

    public abstract Boolean movePiece();
}
