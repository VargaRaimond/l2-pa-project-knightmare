package com.project.Pieces;

public class Knight extends Piece {

    public Knight(int x, int y, boolean white) {
        super(x, y, white);
        type = PieceType.Knight;
    }

    @Override
    public Boolean movePiece() {
        return false;
    }
}
