package com.project.Pieces;

public abstract class Piece {
    private int XPos;
    private int YPos;
    private Boolean isWhite;
    public PieceType type;

    Piece(final int x, final int y, final boolean white) {
        XPos = x;
        YPos = y;
        isWhite = white;
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

    public abstract Boolean movePiece();
}
