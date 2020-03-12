package com.project.Pieces;
import com.project.Board;

public class Pawn extends Piece{
    Boolean firstMove;

    public Pawn(int x, int y) {
        super(x, y);
        firstMove = true;
    }

    @Override
    public Boolean movePiece() {
        Board chessBoard = Board.getInstance();

        char[] movement = new char[4];
        // initial pos
        movement[0] = (char)(getYPos() + 'a');
        movement[1] = (char)(getXPos() + '0' + 1);
        String result;
        if (!isWhite()) {
            if (getXPos() - 1 >= 0 && chessBoard.isCellEmpty(getXPos() - 1, getYPos())) {
                if (firstMove && getXPos() - 2 >= 0 && chessBoard.isCellEmpty(getXPos() - 2, getYPos())) {
                    // generate the movement string
                    movement[2] = (char)(getYPos() + 'a');
                    movement[3] = (char)(getXPos() - 2 + '0' + 1);

                } else {
                    // generate the movement string
                    movement[2] = (char) (getYPos() + 'a');
                    movement[3] = (char) (getXPos() - 1 + '0' + 1);
                }
                // TODO stop pawns from eating their own color
            } else if (getXPos() - 1 >= 0 && getYPos() - 1 >= 0 &&
                    !chessBoard.isCellEmpty(getXPos() - 1, getYPos() - 1)) {
                movement[2] = (char)(getYPos() - 1 + 'a');
                movement[3] = (char)(getXPos() - 1 + '0' + 1);
            } else if (getXPos() - 1 >= 0 && getYPos() + 1 < 8 &&
                    !chessBoard.isCellEmpty(getXPos() - 1, getYPos() + 1)) {
                movement[2] = (char)(getYPos() + 1 + 'a');
                movement[3] = (char)(getXPos() - 1 + '0' + 1);
            } else {
                return false;
            }
        }

        firstMove = false;
        result = new String(movement);
        System.out.println("move " + result);
        chessBoard.executeMove(result);

        return true;
    }
}


