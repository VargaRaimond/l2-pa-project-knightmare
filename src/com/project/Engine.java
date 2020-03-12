package com.project;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Engine {

    // prints a box on screen
    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) throws IOException {

        System.out.println("feature usermove=1 sigint=0\n");

        Scanner scanner = new Scanner(System.in);
        String input;
        Board chessBoard = Board.getInstance();
        while(true) {
            input = scanner.nextLine();
            String command[] = input.split(" ");
            switch (command[0]) {
                case "xboard" :
                    infoBox(input, "hai ca poti");
                    break;
                case "new" :
                    infoBox("a ajuns la new", "hai ca poti");
                    break;
                case "go" :
                    infoBox(input, "hai ca poti");
                    break;
                case "usermove":
                    infoBox(command[0], "hai ca poti");
                    // execute command from xboard and the generate and execute bot move
                    chessBoard.executeMove(command[1]);
                    chessBoard.generateMove();
                    break;
                case "black" :
                    infoBox(input, "hai ca poti");
                    break;
                case "white" :
                    infoBox(input, "hai ca poti");
                    break;
                case "protover":
                    infoBox(command[0], "hai ca poti");
                    break;
                default:
                    infoBox(input, "hai ca poti");
                    break;
            }
        }
    }
}
