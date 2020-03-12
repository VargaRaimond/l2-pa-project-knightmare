import com.project.Board;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Engine {

    // prints a box on screen
    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true) {
            input = scanner.nextLine();
            String command[] = input.split(" ");
            switch (command[0]) {
                case "xboard" :
                    infoBox(input, "hai ca poti");
                    break;
                case "new" :
                    infoBox("a ajuns la new", "hai ca poti");
                    System.out.println("feature usermove=1");
                    Board chess = Board.getInstance();
                    break;
                case "go" :
                    infoBox(input, "hai ca poti");
                    break;
                case "usermove":
                    infoBox(command[0], "hai ca poti");
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
                    System.out.println("move e7e5\n");
                    break;
            }
        }
    }
}
