package sprint3inlömningsuppgift;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private FifteenPuzzle pussel;

    public ButtonListener(FifteenPuzzle pussel) {
        this.pussel = pussel;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        JButton selectedKnapp = (JButton) e.getSource();
        String knappText = selectedKnapp.getText();

        // Om knappen är "New Game"-knappen
        if (knappText.equals("New Game")) {
            pussel.startNewGame();
        } else {
            // Hantera klickad pusselknapp
            int selectedIndex = pussel.getKnappar().indexOf(selectedKnapp);
            int tomIndex = pussel.getTomIndex();

            if (isNextTo(selectedIndex, tomIndex)) {
                pussel.getKnappar().get(tomIndex).setText(knappText);
                selectedKnapp.setText(""); // Gör den klickade knappen tom
                pussel.setTomIndex(selectedIndex);

                // Kontrollera om pusslet är löst
                pussel.checkWin(); // Hantering sker i pusselklassen
            }
        }
    }

    // Kontrollera om två knappar är bredvid varandra
    private boolean isNextTo(int index1, int index2) {
        return Math.abs(index1 - index2) == 1 || Math.abs(index1 - index2) == 4;
    }
}