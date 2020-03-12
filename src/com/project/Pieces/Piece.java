package com.project.Pieces;

<<<<<<< HEAD
public abstract class Piece {
    private int x_pos;
    private int y_pos;
    Boolean isWhite;
=======
public class Piece {

    private int x_pos;
    private int y_pos;
>>>>>>> origin/master

    public Piece(final int x, final int y) {
        x_pos = x;
        y_pos = y;
<<<<<<< HEAD
        isWhite = false;
=======
>>>>>>> origin/master
    }

    public int getX_pos() {
        return x_pos;
    }

<<<<<<< HEAD
    public int getY_pos() {
        return y_pos;
    }

=======
>>>>>>> origin/master
    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

<<<<<<< HEAD
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
=======
    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public boolean movePiece() {
        return true;
    }
>>>>>>> origin/master
}
