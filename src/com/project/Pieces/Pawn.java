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
        movement[0] = (char)(getX_pos() + 'a');
        movement[1] = (char)(getY_pos() + '0');

        String result;

        if (!isWhite()) {
            if (getX_pos() - 1 >= 0 && chessBoard.isCellEmpty(getX_pos() - 1, getY_pos())) {
                if (firstMove && getX_pos() - 2 >= 0 && chessBoard.isCellEmpty(getX_pos() - 2, getY_pos())) {
                    // generate the movement string
                    movement[2] = (char)((getX_pos() - 2) + 'a');
                    movement[3] = (char)(getY_pos() + '0');
                } else {
                    // generate the movement string
                    movement[2] = (char) ((getX_pos() - 1) + 'a');
                    movement[3] = (char) (getY_pos() + '0');
                }
            } else if (getX_pos() - 1 >= 0 && getY_pos() - 1 >= 0 &&
                    chessBoard.isCellEmpty(getX_pos() - 1, getY_pos() - 1)) {
                movement[2] = (char)((getX_pos() - 1) + 'a');
                movement[3] = (char)((getY_pos() - 1) + '0');
            } else if (getX_pos() - 1 >= 0 && getY_pos() + 1 < 8 &&
                    chessBoard.isCellEmpty(getX_pos() - 1, getY_pos() + 1)) {
                movement[2] = (char)((getX_pos() - 1) + 'a');
                movement[3] = (char)((getY_pos() + 1) + '0');
            } else {
                return false;
            }
        }

        result = new String(movement);
        System.out.println(result);
        chessBoard.executeMove(result);

        return true;
    }


}
