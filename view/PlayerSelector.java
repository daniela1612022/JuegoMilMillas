package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSelector {
    private JFrame frame;
    private JLabel label;
    private JButton twoPlayersButton;
    private JButton fourPlayersButton;
    private JButton cancelButton;

    public PlayerSelector() {
        createView();
    }

    private void createView() {
        frame = new JFrame("Player Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        label = new JLabel("Select the number of players:", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 18));
        label.setPreferredSize(new Dimension(300, 50));

        twoPlayersButton = new JButton("2 Players");
        twoPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle 2 players button click
                frame.dispose(); // Close the player selector window
                new Game(2); // Start a new game with 2 players
            }
        });

        fourPlayersButton = new JButton("4 Players");
        fourPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle 4 players button click
                frame.dispose(); // Close the player selector window
                new Game(4); // Start a new game with 4 players
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle cancel button click
                frame.dispose(); // Close the player selector window
            }
        });

        frame.getContentPane().setLayout(new GridLayout(3, 1));
        frame.getContentPane().add(label);
        frame.getContentPane().add(twoPlayersButton);
        frame.getContentPane().add(fourPlayersButton);
        frame.getContentPane().add(cancelButton);

        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true); // Show the window
    }

    public static void main(String[] args) {
        new PlayerSelector();
    }
}

class Game {
    private int numPlayers;

    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
        System.out.println("Starting a new game with " + numPlayers + " players.");
        // Initialize the game with the specified number of players
    }
}