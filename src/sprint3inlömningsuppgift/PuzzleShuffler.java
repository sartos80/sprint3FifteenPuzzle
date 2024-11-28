package sprint3inlömningsuppgift;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleShuffler {

    // Slumpa om brickorna
    public static void shuffleBoard(ArrayList<JButton> buttons) {
        ArrayList<String> nummer = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            nummer.add(String.valueOf(i));
        }
        Collections.shuffle(nummer);

        for (int i = 0; i < 15; i++) {
            buttons.get(i).setText(nummer.get(i));
        }
        buttons.get(15).setText(""); // Sista knappen ska vara tom
    }
}