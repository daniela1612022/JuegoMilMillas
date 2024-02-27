package view;
import javax.swing.*;
import java.awt.*;

public class CardGameInterface {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel player1Label;
    private JLabel player2Label;
    private JTextField player1TextField;
    private JTextField player2TextField;
    private JLabel discardPileLabel;
    private JLabel drawPileLabel;
    private JLabel logLabel;

    public CardGameInterface() {
        // Create the main window
        frame = new JFrame("Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        frame.add(mainPanel);

        // Create the title label
        titleLabel = new JLabel("Card Game");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel);

        // Create the player labels and text fields
        player1Label = new JLabel("JUGADOR 1:");
        player1Label.setFont(new Font("Serif", Font.BOLD, 24));
        player1TextField = new JTextField("5", 10);
        player1TextField.setFont(new Font("Serif", Font.BOLD, 24));
        player1TextField.setHorizontalAlignment(JTextField.CENTER);
        player2Label = new JLabel("JUGADOR 2:");
        player2Label.setFont(new Font("Serif", Font.BOLD, 24));
        player2TextField = new JTextField("5", 10);
        player2TextField.setFont(new Font("Serif", Font.BOLD, 24));
        player2TextField.setHorizontalAlignment(JTextField.CENTER);
        mainPanel.add(player1Label);
        mainPanel.add(player1TextField);
        mainPanel.add(player2Label);
        mainPanel.add(player2TextField);

        // Create the discard pile label
        discardPileLabel = new JLabel("Discard Pile:");
        discardPileLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(discardPileLabel);

        // Create the draw pile label
        drawPileLabel = new JLabel("Draw Pile:");
        drawPileLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(drawPileLabel);

        // Create the log label
        logLabel = new JLabel("Log:");
        logLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(logLabel);

        // Add sample text to the log label
        logLabel.setText("<html>" +
                "04<br>" +
                "+29 4 6 4 6 8<br>" +
                "8 5<br>" +
                "JUGADOR 1<br>" +
                "сл<br>" +
                "JUGADOR 2<br>" +
                "5<br>" +
                "СЛ<br>" +
                "</html>");

        // Make the window visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CardGameInterface();
    }
}