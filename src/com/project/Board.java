package com.project;

import com.project.Pieces.Pawn;
import com.project.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public final class Board {
    private List<List<Piece>> board;
    private static Board instance;
    private List<Piece> botPieces;

    private Board() {
        board = new ArrayList<>();
        botPieces = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < 8; ++j) {
                board.get(i).add(null);
            }
        }

        for(int i = 0; i < 8; i++) {
            // add pawns
            board.get(1).set(i, new Pawn(1, i));
            board.get(6).set(i, new Pawn(6, i));

            board.get(0).set(i, new Pawn(0, i));
            board.get(7).set(i, new Pawn(7, i));
        }
        botPieces.addAll(board.get(6));
       // botPieces.addAll(board.get(7));
    }

    public boolean isCellEmpty(final int x, final int y) {
        return board.get(x).get(y) == null;
    }

    public static Board getInstance() {
        if(instance == null) {
            instance = new Board();
        }
        return instance;
    }

    // banal function to iterate through pawns and move them
    public void generateMove() {
        for(Piece piece : botPieces) {
            if (piece.movePiece()) {
                return;
            }
        }
        // if for ended we couldn't move anything so we resign
        System.out.println("resign");
    }

    // move a piece on our internal board
    public void executeMove(String move) {
        int current_x = Integer.parseInt(String.valueOf(move.charAt(1))) - 1;
        int current_y = move.charAt(0) - 'a';
        int next_x = Integer.parseInt(String.valueOf(move.charAt(3))) - 1;
        int next_y = move.charAt(2) -'a';

        Piece piece = board.get(current_x).get(current_y);
        board.get(next_x).set(next_y, piece);
        board.get(current_x).set(current_y, null);
        piece.setXPos(next_x);
        piece.setYPos(next_y);
    }
}
