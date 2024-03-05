import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Model.*;

public class Usuario {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        CartaUsada bote = new CartaUsada(null, null, null, null, null, null);
        JFrame frame = new JFrame("Modo de juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, baraja, bote);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, Baraja baraja, CartaUsada bote) {
        panel.setLayout(null);

        JLabel modoLabel = new JLabel("Selecciona el modo de juego:");
        modoLabel.setBounds(10, 20, 200, 25);
        panel.add(modoLabel);

        JRadioButton individualButton = new JRadioButton("Individual");
        individualButton.setBounds(20, 50, 100, 25);
        panel.add(individualButton);

        JRadioButton grupoButton = new JRadioButton("En Grupo");
        grupoButton.setBounds(20, 80, 100, 25);
        panel.add(grupoButton);

        ButtonGroup group = new ButtonGroup();
        group.add(individualButton);
        group.add(grupoButton);

        JButton startButton = new JButton("Comenzar Juego");
        startButton.setBounds(20, 120, 150, 25);
        panel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (individualButton.isSelected()) {
                    // Iniciar juego en modo individual
                    System.out.println("Juego en modo individual iniciado.");
                    JFrame individualFrame = new JFrame("Juego Individual");
                    individualFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    individualFrame.setSize(600, 400);

                    JPanel individualPanel = new JPanel();
                    individualFrame.add(individualPanel);
                    placeIndividualComponents(individualPanel, baraja, bote);

                    individualFrame.setVisible(true);
                } else if (grupoButton.isSelected()) {
                    // Iniciar juego en modo de grupo
                    System.out.println("Juego en modo de grupo iniciado.");
                    JFrame groupFrame = new JFrame("Juego en Grupo");
                    groupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    groupFrame.setSize(600, 400);

                    JPanel groupPanel = new JPanel();
                    groupFrame.add(groupPanel);
                    placeGroupComponents(groupPanel, baraja, bote);

                    groupFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un modo de juego", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private static void placeIndividualComponents(JPanel panel, Baraja baraja, CartaUsada bote) {
        panel.setLayout(new GridLayout(2, 1));

        JButton[] buttons = new JButton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton("Carta " + (i + 1));
            panel.add(buttons[i]);
        }

        for (int i = 0; i < 6; i++) {
            int index = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Carta carta = baraja.robarCarta();
                    System.out.println("Carta " + (index + 1) + " robada: " + carta.getNombre());
                    buttons[index].setEnabled(false);
                    buttons[index].setText(carta.getNombre());
                }
            });
        }
    }

    private static void placeGroupComponents(JPanel panel, Baraja baraja, CartaUsada bote) {
        panel.setLayout(new GridLayout(2, 1));

        JButton[] buttons = new JButton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton("Carta " + (i + 1));
            panel.add(buttons[i]);
        }

        for (int i = 0; i < 6; i++) {
            int index = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Carta carta = baraja.robarCarta();
                    System.out.println("Carta " + (index + 1) + " robada: " + carta.getNombre());
                    buttons[index].setEnabled(false);
                    buttons[index].setText(carta.getNombre());
                }
            });
        }
    }
}
