package com.project.Pieces;
import com.project.Board;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    private Boolean firstMove;
    private List<Integer> deltaX;

    public Pawn(int x, int y, boolean white) {
        super(x, y, white);
        firstMove = true;
        type = PieceType.Pawn;
        deltaX = new ArrayList<>();
        // constants for black pieces
        if (isWhite()) {
            deltaX.add(1);
            deltaX.add(2);
        } else {
            deltaX.add(-1);
            deltaX.add(-2);
        }
    }

    @Override
    public Boolean movePiece() {
        Board chessBoard = Board.getInstance();
        StringBuilder move = new StringBuilder();

        // initial pos
        move.append((char)(getYPos() + 'a'));
        move.append((char)(getXPos() + '0' + 1));

        if (getXPos() + deltaX.get(0) >= 0 && getXPos() + deltaX.get(0) < 8
                && chessBoard.isCellEmpty(getXPos() + deltaX.get(0), getYPos())) {

            if (firstMove && getXPos() + deltaX.get(1) >= 0 && deltaX.get(1) < 8 &&
                    chessBoard.isCellEmpty(getXPos() + deltaX.get(1), getYPos())) {

                // generate the movement string
                move.append((char)(getYPos() + 'a'));
                move.append((char)(getXPos() + deltaX.get(1) + '0' + 1));

            } else {
                // generate the movement string
                move.append((char)(getYPos() + 'a'));
                move.append((char)(getXPos() + deltaX.get(0) + '0' + 1));
            }

        } else if (getXPos() + deltaX.get(0) >= 0 && getXPos() + deltaX.get(0) < 8 && getYPos() - 1 >= 0 &&
                !chessBoard.isCellEmpty(getXPos() + deltaX.get(0), getYPos() - 1) &&
                chessBoard.isOppositeColor(getXPos() + deltaX.get(0), getYPos() - 1, isWhite())) {

            move.append((char)(getYPos() - 1 + 'a'));
            move.append((char)(getXPos() + deltaX.get(0) + '0' + 1));

        } else if (getXPos() + deltaX.get(0) >= 0 && getXPos() + deltaX.get(0) < 8 && getYPos() + 1 < 8 &&
                !chessBoard.isCellEmpty(getXPos()+ deltaX.get(0), getYPos() + 1) &&
                chessBoard.isOppositeColor(getXPos() + deltaX.get(0), getYPos() + 1, isWhite())) {

            move.append((char)(getYPos() + 1 + 'a'));
            move.append((char)(getXPos() + deltaX.get(0) + '0' + 1));

        } else {
            return false;
        }

        firstMove = false;
        System.out.println("move " + move.toString());
        chessBoard.executeMove(move.toString());
        return true;
    }
}


