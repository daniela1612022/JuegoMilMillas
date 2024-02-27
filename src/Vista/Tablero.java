package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tablero extends JFrame {
    private BarraSuperior barraSuperior; // Barra de herramientas superior
    private VentanaJugador ventanaJugador; // Ventana del jugador

    public Tablero() {
        super("Tablero del juego");

        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño del tablero
        setLocationRelativeTo(null); // Centrar el tablero

        // Layout del tablero
        setLayout(new BorderLayout());

        // Crear la barra de herramientas superior
        barraSuperior = new BarraSuperior();
        add(barraSuperior, BorderLayout.NORTH);

        // Crear la ventana del jugador
        ventanaJugador = new VentanaJugador();
        add(ventanaJugador, BorderLayout.CENTER);

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

// Clase para la barra de herramientas superior
class BarraSuperior extends JPanel {
    public BarraSuperior() {
        // Panel para la parte superior (puntos, rondas y objetivo)
        setLayout(new GridLayout(3, 1)); // Ahora tenemos 3 filas

        // Mostrar cuadro de diálogo para ingresar el objetivo del juego
        int objetivoTotal = obtenerObjetivo();
        int objetivoRonda = objetivoTotal / 3;

        // Panel para los objetivos
        JPanel panelObjetivos = new JPanel(new GridLayout(1, 2));
        JLabel labelObjetivoTotal = new JLabel("Objetivo total: " + objetivoTotal + " millas");
        labelObjetivoTotal.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel labelObjetivoRonda = new JLabel("Objetivo de la ronda 1: " + objetivoRonda + " millas");
        labelObjetivoRonda.setHorizontalAlignment(SwingConstants.CENTER);
        panelObjetivos.add(labelObjetivoTotal);
        panelObjetivos.add(labelObjetivoRonda);
        add(panelObjetivos);

        // Panel para puntos y rondas
        JPanel panelPuntosRondas = new JPanel(new GridLayout(1, 3));
        JLabel labelPuntos = new JLabel("Puntos: 0");
        labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel labelRondas = new JLabel("Ronda: 1");
        labelRondas.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel labelTurno = new JLabel("Turno del jugador: 1");
        labelTurno.setHorizontalAlignment(SwingConstants.CENTER);
        panelPuntosRondas.add(labelPuntos);
        panelPuntosRondas.add(labelRondas);
        panelPuntosRondas.add(labelTurno);
        add(panelPuntosRondas);

        // Botón para cambiar de turno
        JButton btnCambiarTurno = new JButton("Cambiar Turno");
        btnCambiarTurno.addActionListener(e -> cambiarTurno()); // Acción al hacer clic en el botón
        add(btnCambiarTurno);
    }

    private static int obtenerObjetivo() {
        int objetivo = 0;
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, "Ingrese el objetivo del juego en millas (entre 1000 y 5000):", "Objetivo del juego", JOptionPane.QUESTION_MESSAGE);
            try {
                objetivo = Integer.parseInt(entrada);
                if (objetivo >= 1000 && objetivo <= 5000) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido entre 1000 y 5000.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido entre 1000 y 5000.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return objetivo;
    }

    private void cambiarTurno() {
        JOptionPane.showMessageDialog(null, "Cambiar turno"); // Aquí puedes agregar lógica para cambiar el turno
    }
}

// Clase para la ventana del jugador
class VentanaJugador extends JPanel {
    public VentanaJugador() {
        setBackground(Color.BLACK); // Fondo negro
        setLayout(new BorderLayout()); // Usamos BorderLayout para colocar las cartas en capas

        // Panel para las cartas centrales
        JLayeredPane panelCartas = new JLayeredPane();
        panelCartas.setPreferredSize(new Dimension(800, 450)); // Tamaño del panel de las cartas

        // Calcular el espacio horizontal entre las cartas
        int espacioHorizontal = (panelCartas.getWidth() - 100 * 6) / 7;

        // Calcular el espacio vertical entre las filas de cartas
        int espacioVertical = (panelCartas.getHeight() - 150 * 4) / 5;

        // Añadir las cartas en tres filas
        for (int fila = 0; fila < 4; fila++) {
            for (int i = 0; i < 6; i++) {
                JLabel carta = new JLabel(new ImageIcon(getResizedImage("assets/Carta_Prueba.png", 100, 150)));
                int x = (100 + espacioHorizontal) * i + espacioHorizontal;
                int y = (150 + espacioVertical) * fila + espacioVertical;
                carta.setBounds(x, y, 100, 150);
                panelCartas.add(carta, new Integer(fila * 6 + i));
            }
        }

        add(panelCartas, BorderLayout.CENTER); // Agregar el panel de cartas a la ventana del jugador
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
}

