package com.project.Pieces;
import com.project.Board;

public class Pawn extends Piece{
    private Board chessBoard;
    private int deltaX;

    public Pawn(int x, int y, boolean white) {
        super(x, y, white);
        type = PieceType.Pawn;

        // Constants for white or black pieces
        deltaX = (isWhite()) ? 1 : -1;
    }

    @Override
    public Boolean movePiece() {
        chessBoard = Board.getInstance();
        StringBuilder move = new StringBuilder();

        // initial position
        move.append((char)(getYPos() + 'a'));
        move.append((char)(getXPos() + '0' + 1));

        // Possible moves:
        if (canMoveForwardWith2Pos()) {
            return moveForwardWith2Pos(move);
        }

        if (canMoveForward()) {
            return moveForward(move);
        }

        if (canEatPiece("left")) {
            return eatPiece(move, "left");
        }

        if (canEatPiece("right")) {
            return eatPiece(move, "right");
        }

        return false;
    }

    private boolean isOnBoard(final int x, final int y) {
        return (x >= 0 && x < 8 && y >= 0 && y < 8);
    }

    private boolean isFirstMove() {
        return isWhite() ? (getXPos() == 1) : (getXPos() == 6);
    }

    private boolean canMoveForward() {
        return isOnBoard(getXPos() + deltaX, getYPos())
                && chessBoard.isCellEmpty(getXPos() + deltaX, getYPos());
    }

    private boolean canMoveForwardWith2Pos() {
        return isFirstMove() && isOnBoard(getXPos() + (deltaX << 1), getYPos()) &&
                canMoveForward() && chessBoard.isCellEmpty(getXPos() + (deltaX << 1), getYPos());
    }

    private boolean canEatPiece(String direction) {
        int x = getXPos() + deltaX;
        int y = getYPos() + ((direction.equals("left")) ? -1 : 1);
        return isOnBoard(x, y) && !chessBoard.isCellEmpty(x, y) &&
                chessBoard.isOppositeColor(x, y, isWhite());
    }

    private boolean moveForwardWith2Pos(StringBuilder move) {
        move.append((char)(getYPos() + 'a'));
        move.append((char)(getXPos() + (deltaX << 1) + '0' + 1));
        executeMove(move);
        return true;
    }

    private boolean moveForward(StringBuilder move) {
        move.append((char)(getYPos() + 'a'));
        move.append((char)(getXPos() + deltaX + '0' + 1));
        executeMove(move);
        return true;
    }

    private boolean eatPiece(StringBuilder move, String direction) {
        int deltaY = (direction.equals("left")) ? -1 : 1;
        move.append((char)(getYPos() + deltaY + 'a'));
        move.append((char)(getXPos() + deltaX + '0' + 1));
        executeMove(move);
        return true;
    }

    private void executeMove(StringBuilder move) {
        System.out.println("move " + move.toString());
        chessBoard.executeMove(move.toString());
    }
}
