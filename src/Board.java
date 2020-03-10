import java.util.ArrayList;
import java.util.List;

public final class Board {
    private static List<List<String>> board;
    private static Board instance;

    private Board() {
        board = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            board.add(new ArrayList<>(8));
        }

    }

    public static Board getInstance() {
        if(instance == null) {
            instance = new Board();
        }
        return instance;
    }
}
