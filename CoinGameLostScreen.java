import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinGameLostScreen extends JFrame implements ActionListener {

    private JLabel resultLabel;
    private JTextArea historyArea;
    private JButton playAgainButton;

    public CoinGameLostScreen(int currentGameMoves, int[] pastGameMoves) {
        setTitle("Coin Game - You Lost!");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
        resultLabel = new JLabel("You lost! You made " + currentGameMoves + " moves in this game.");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        add(resultLabel, BorderLayout.NORTH);

       
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        for (int i = 0; i < pastGameMoves.length; i++) {
            historyArea.append("Game " + (i + 1) + ": " + pastGameMoves[i] + " moves\n");
        }
        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.CENTER);

        
        playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(this);
        add(playAgainButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgainButton) {
            // Start a new game by creating a new instance of the CoinGame class
            new CoinGame();
            dispose();
        }
    }
}