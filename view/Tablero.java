package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tablero extends JFrame {
    private int objetivoTotal;
    private int objetivoRonda;
    private int rondaActual;
    private int jugadorActual; // Variable para rastrear el jugador actual
    private JLabel labelObjetivoTotal;
    private JLabel labelObjetivoRonda;
    private JLabel labelTurno; // Mostrar el turno del jugador actual

    public Tablero() {
        super("Tablero del juego");

        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño del tablero
        setLocationRelativeTo(null); // Centrar el tablero

        // Layout del tablero
        setLayout(new BorderLayout());

        // Mostrar cuadro de diálogo para ingresar el objetivo del juego
        objetivoTotal = obtenerObjetivo();

        // Calcular el objetivo de cada ronda
        objetivoRonda = objetivoTotal / 3;
        rondaActual = 1;
        jugadorActual = 1; // Comenzar con el jugador 1

        // Panel para la parte superior (puntos, rondas y objetivo)
        JPanel panelSuperior = new JPanel(new GridLayout(3, 1)); // Ahora tenemos 3 filas
        JPanel panelObjetivos = new JPanel(new GridLayout(1, 2));
        labelObjetivoTotal = new JLabel("Objetivo total: " + objetivoTotal + " millas");
        labelObjetivoTotal.setHorizontalAlignment(SwingConstants.CENTER);
        labelObjetivoRonda = new JLabel("Objetivo de la ronda " + rondaActual + ": " + objetivoRonda + " millas");
        labelObjetivoRonda.setHorizontalAlignment(SwingConstants.CENTER);
        panelObjetivos.add(labelObjetivoTotal);
        panelObjetivos.add(labelObjetivoRonda);
        panelSuperior.add(panelObjetivos);

        JPanel panelPuntosRondas = new JPanel(new GridLayout(1, 3)); // Ahora tenemos 3 columnas
        JLabel labelPuntos = new JLabel("Puntos: 0");
        labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel labelRondas = new JLabel("Ronda: " + rondaActual);
        labelRondas.setHorizontalAlignment(SwingConstants.CENTER);
        labelTurno = new JLabel("Turno del jugador: " + jugadorActual); // Mostrar el turno del jugador actual
        labelTurno.setHorizontalAlignment(SwingConstants.CENTER);
        panelPuntosRondas.add(labelPuntos);
        panelPuntosRondas.add(labelRondas);
        panelPuntosRondas.add(labelTurno); // Agregar la etiqueta de turno
        panelSuperior.add(panelPuntosRondas);

        // Botón para cambiar de turno
        JButton btnCambiarTurno = new JButton("Cambiar Turno");
        btnCambiarTurno.addActionListener(e -> cambiarTurno()); // Acción al hacer clic en el botón
        panelSuperior.add(btnCambiarTurno); // Agregar botón al panel superior

        add(panelSuperior, BorderLayout.NORTH);

        // Resto del código sigue igual...

        // Hacer visible el tablero
        setVisible(true);
    }

    private void cambiarTurno() {
        cambiarJugador(); // Cambiar el jugador actual
        // Aquí puedes agregar lógica adicional relacionada con el cambio de turno si es necesario
    }

    private int obtenerObjetivo() {
        int objetivo = 0;
        while (true) {
            String entrada = JOptionPane.showInputDialog(this, "Ingrese el objetivo del juego en millas (entre 1000 y 5000):", "Objetivo del juego", JOptionPane.QUESTION_MESSAGE);
            try {
                objetivo = Integer.parseInt(entrada);
                if (objetivo >= 1000 && objetivo <= 5000) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido entre 1000 y 5000.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido entre 1000 y 5000.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return objetivo;
    }

    private BufferedImage getResizedImage(String filename, int width, int height) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
            Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resizedImg.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
            return resizedImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para cambiar el jugador actual
    private void cambiarJugador() {
        jugadorActual = (jugadorActual == 1) ? 2 : 1; // Alternar entre jugadores 1 y 2
        labelTurno.setText("Turno del jugador: " + jugadorActual); // Actualizar la etiqueta de turno
    }

    public static void main(String[] args) {
        // Crear y mostrar el tablero
        SwingUtilities.invokeLater(() -> {
            new Tablero();
        });
    }
}
