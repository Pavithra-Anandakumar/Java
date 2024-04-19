import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons;
    private char currentPlayer;
    private boolean gameOver;
    private JLabel resultLabel;

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        currentPlayer = 'X';
        gameOver = false;

        initializeBoard(gamePanel);
        add(gamePanel, BorderLayout.CENTER);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(resultLabel, BorderLayout.NORTH);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        add(restartButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initializeBoard(JPanel gamePanel) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                buttons[i][j] = button;
                gamePanel.add(button);

                final int row = i;
                final int col = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!gameOver && buttons[row][col].getText().isEmpty()) {
                            buttons[row][col].setText(String.valueOf(currentPlayer));
                            buttons[row][col].setForeground(currentPlayer == 'X' ? Color.BLUE : Color.RED);
                            if (checkForWin()) {
                                gameOver = true;
                                showResult("Player " + currentPlayer + " wins!");
                                strikeOutWinner();
                            } else if (isBoardFull()) {
                                gameOver = true;
                                showResult("It's a draw!");
                            } else {
                                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            }
                        }
                    }
                });
            }
        }
    }

    private void restartGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setForeground(Color.BLACK);
            }
        }
        currentPlayer = 'X';
        gameOver = false;
        resultLabel.setText("");
    }

    private boolean checkForWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(buttons[i][0].getText(), buttons[i][1].getText(), buttons[i][2].getText())) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(buttons[0][i].getText(), buttons[1][i].getText(), buttons[2][i].getText())) {
                return true;
            }
        }
        // Check diagonals
        if (checkRowCol(buttons[0][0].getText(), buttons[1][1].getText(), buttons[2][2].getText()) ||
                checkRowCol(buttons[0][2].getText(), buttons[1][1].getText(), buttons[2][0].getText())) {
            return true;
        }
        return false;
    }

    private boolean checkRowCol(String s1, String s2, String s3) {
        return (!s1.isEmpty() && s1.equals(s2) && s2.equals(s3));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showResult(String message) {
        resultLabel.setText(message);
    }

    private void strikeOutWinner() {
        // Strike out the winning row
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(buttons[i][0].getText(), buttons[i][1].getText(), buttons[i][2].getText())) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
                    buttons[i][j].setText("<html><strike>" + buttons[i][j].getText() + "</strike></html>");
                }
                return;
            }
        }
        // Strike out the winning column
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(buttons[0][i].getText(), buttons[1][i].getText(), buttons[2][i].getText())) {
                for (int j = 0; j < 3; j++) {
                    buttons[j][i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
                    buttons[j][i].setText("<html><strike>" + buttons[j][i].getText() + "</strike></html>");
                }
                return;
            }
        }
        // Strike out the winning diagonal (if any)
        if (checkRowCol(buttons[0][0].getText(), buttons[1][1].getText(), buttons[2][2].getText())) {
            for (int i = 0; i < 3; i++) {
                buttons[i][i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
                buttons[i][i].setText("<html><strike>" + buttons[i][i].getText() + "</strike></html>");
            }
        } else if (checkRowCol(buttons[0][2].getText(), buttons[1][1].getText(), buttons[2][0].getText())) {
            for (int i = 0; i < 3; i++) {
                buttons[i][2 - i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
                buttons[i][2 - i].setText("<html><strike>" + buttons[i][2 - i].getText() + "</strike></html>");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}

