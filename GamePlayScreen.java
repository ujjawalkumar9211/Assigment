import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinGame extends JFrame implements ActionListener {

    private JLabel[][] board;
    private int[][] boardState;
    private JButton resetButton;

    public GamePlayScreen() {
        setTitle("Coin Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        board = new JLabel[5][5];
        boardState = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = new JLabel();
                board[i][j].setOpaque(true);
                board[i][j].setBackground(Color.YELLOW);
                board[i][j].setHorizontalAlignment(JLabel.CENTER);
                boardState[i][j] = (i == 2 && j == 2) ? 1 : 0; 
                if (boardState[i][j] == 1) {
                    board[i][j].setIcon(new ImageIcon("coin.png"));
                }
                board[i][j].addActionListener(this);
                add(board[i][j]);
            }
        }

        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    boardState[i][j] = (i == 2 && j == 2) ? 1 : 0;
                    if (boardState[i][j] == 1) {
                        board[i][j].setIcon(new ImageIcon("coin.png"));
                    } else {
                        board[i][j].setIcon(null);
                    }
                }
            }
        } else {
            
            int row = -1, col = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == e.getSource()) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }

            
            if (canMove(row, col)) {
                moveCoin(row, col);
            }
        }
    }

    private boolean canMove(int row, int col) {
        
        if (row > 0 && boardState[row - 1][col] == 0) {
            return true;
        }
        if (row < 4 && boardState[row + 1][col] == 0) {
            return true;
        }
        if (col > 0 && boardState[row][col - 1] == 0) {
            return true;
        }
        if (col < 4 && boardState[row][col + 1] == 0) {
            return true;
        }
        return false;
    }

    private void moveCoin(int row, int col)