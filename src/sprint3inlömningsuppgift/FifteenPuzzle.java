package sprint3inlömningsuppgift;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class FifteenPuzzle extends JFrame {

    private ArrayList<JButton> buttons = new ArrayList<>();
    private int tomIndex = 15; // Index för den tomma knappen

    public FifteenPuzzle() {
        JPanel panel = new JPanel(new GridLayout(4, 4));

        // Skapa knappar och lägg till i panelen
        for (int i = 1; i <= 15; i++) {
            JButton knapp = new JButton(String.valueOf(i));
            buttons.add(knapp);
            panel.add(knapp);
            knapp.addActionListener(new ButtonListener(this)); // Lägg till lyssnare
        }

        // Lägg till den tomma knappen
        JButton tomKnapp = new JButton("");
        buttons.add(tomKnapp);
        panel.add(tomKnapp);
        tomIndex = 15; // Tom knapp är sista
        tomKnapp.addActionListener(new ButtonListener(this)); // Lägg till lyssnare

        // Lägg till panelen i fönstret
        add(panel, BorderLayout.CENTER);

        // Lägg till "New Game"-knapp
        JButton nySpelKnapp = new JButton("New Game");
        nySpelKnapp.addActionListener(new ButtonListener(this));
        add(nySpelKnapp, BorderLayout.SOUTH);

        // Lägg till "Sortera"-knapp
        JButton sorteraKnapp = new JButton("Sortera Brickor");
        sorteraKnapp.addActionListener(e -> sortBoard());
        add(sorteraKnapp, BorderLayout.NORTH);

        setTitle("15-Pussel");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrera fönstret
        startNewGame(); // Starta nytt spel direkt
    }

    // Starta ett nytt spel och blanda brickorna
    public void startNewGame() {
        PuzzleShuffler.shuffleBoard(buttons); // Blanda brickor
        tomIndex = buttons.size() - 1; // Återställ tom index
    }

    // Ställ in brädet i sorterad ordning
    public void sortBoard() {
        for (int i = 0; i < 15; i++) {
            buttons.get(i).setText(String.valueOf(i + 1)); // Sortera brickor
        }
        buttons.get(15).setText(""); // Sätt sista knapp som tom
        tomIndex = 15; // Återställ tom index
    }

    public boolean checkWin() {
        // Kolla alla brickor (förutom den sista som ska vara tom)
        for (int i = 0; i < 15; i++) {
            if (!buttons.get(i).getText().equals(String.valueOf(i + 1))) {
                return false; // Om någon bricka inte är på rätt plats, har spelaren inte vunnit
            }
        }

        // Kontrollera sista knappen (som ska vara tom)
        if (buttons.get(15).getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Grattis! Du vann!"); // Visa vinstmeddelande
            return true; // Spelaren har vunnit
        }

        return false; // Om ingen av villkoren är uppfyllda, har spelaren inte vunnit
    }

    // Getter för knappar
    public ArrayList<JButton> getKnappar() {
        return buttons;
    }

    // Getter för tomIndex
    public int getTomIndex() {
        return tomIndex;
    }

    // Setter för tomIndex
    public void setTomIndex(int tomIndex) {
        this.tomIndex = tomIndex;
    }
public static void main(String[] args) {
    new FifteenPuzzle(); // Starta spelet
}}