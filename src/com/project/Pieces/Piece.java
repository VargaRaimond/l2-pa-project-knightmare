package com.project.Pieces;

public abstract class Piece {
    private int XPos;
    private int YPos;
    Boolean isWhite;

    public Piece(final int x, final int y) {
        XPos = x;
        YPos = y;
        isWhite = false; // Pieces are black by default
    }

    public int getXPos() {
        return XPos;
    }

    public int getYPos() {
        return YPos;
    }

    public void setXPos(int XPos) {
        this.XPos = XPos;
    }

    public void setYPos(int YPos) {
        this.YPos = YPos;
    }

    public Boolean isWhite() {
        return isWhite;
    }

    public void setWhite(Boolean white) {
        isWhite = white;
    }

    public abstract Boolean movePiece();
}
