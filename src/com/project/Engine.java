package com.project;

import java.io.IOException;
import java.util.Scanner;

public class Engine {

    public static void main(String[] args) throws IOException {

        Board chessBoard = Board.getInstance();
        System.out.println("feature usermove=1 sigint=0");
        boolean force = false;

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            String[] command = input.split(" ");
            switch (command[0]) {
                case "xboard":
                    break;

                case "new":
                    chessBoard = Board.getNewInstance();
                    force = false;
                    break;

                case "force":
                    force = true;
                    break;

                case "go":
                    force = false;
                    break;

                case "usermove":
                    // execute command from xboard and the generate and execute bot move
                    chessBoard.executeMove(command[1]);
                    if (!force)
                        chessBoard.generateMove();
                    break;

                case "black":
                    while (!input.equals("white")) {
                        input = scanner.nextLine();
                    }
                    // change bot on white
                    chessBoard.changeColor(true);
                    chessBoard.generateMove();
                    break;

                case "white":
                    while (!input.equals("black")) {
                        input = scanner.nextLine();
                    }
                    // change bot on black
                    chessBoard.changeColor(false);
                    chessBoard.generateMove();
                    break;
                case "quit":
                    return;
                default:
                    break;
            }
        }
    }
}
