package view;
import javax.swing.*;
import java.awt.*;

public class Tablero extends JFrame {
    public Tablero() {
        super("Tablero del juego");
        
        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño del tablero
        setLocationRelativeTo(null); // Centrar el tablero

        // Layout del tablero
        setLayout(new BorderLayout());

        // Panel para el jugador 1
        JPanel panelJugador1 = new JPanel(new GridLayout(1, 6));
        panelJugador1.setBackground(Color.RED);
        for (int i = 0; i < 6; i++) {
            JLabel carta = new JLabel("Carta " + (i + 1));
            carta.setHorizontalAlignment(SwingConstants.CENTER);
            panelJugador1.add(carta);
        }
        add(panelJugador1, BorderLayout.NORTH);

        // Panel para el jugador 2
        JPanel panelJugador2 = new JPanel(new GridLayout(1, 6));
        panelJugador2.setBackground(Color.BLUE);
        for (int i = 0; i < 6; i++) {
            JLabel carta = new JLabel("Carta " + (i + 1));
            carta.setHorizontalAlignment(SwingConstants.CENTER);
            panelJugador2.add(carta);
        }
        add(panelJugador2, BorderLayout.SOUTH);

        // Panel para el tablero principal
        JPanel panelTablero = new JPanel(new GridLayout(4, 13)); // Ejemplo de un tablero de 52 cartas
        panelTablero.setBackground(Color.GREEN);
        for (int i = 0; i < 52; i++) {
            JLabel carta = new JLabel("Carta " + (i + 1));
            carta.setHorizontalAlignment(SwingConstants.CENTER);
            panelTablero.add(carta);
        }
        add(panelTablero, BorderLayout.CENTER);

        // Hacer visible el tablero
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear y mostrar el tablero
        SwingUtilities.invokeLater(() -> {
            new Tablero();
        });
    }
}
