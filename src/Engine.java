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
            switch (input) {
                case "xboard" :
                    break;
                case "new" :
                    Board chess = Board.getInstance();
            }
            infoBox(input, "hai ca poti");
            break;
        }
    }
}
