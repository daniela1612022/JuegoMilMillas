package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Usuario.Usuario; // Importa la clase Usuario del paquete Usuario

public class InterfazJuegoCartas extends JFrame {

    private List<Usuario> usuarios;

    public InterfazJuegoCartas() {
        super("Juego de Cartas");

        // Inicializar la lista de usuarios
        usuarios = new ArrayList<>();

        // Configurar los usuarios según el modo de juego seleccionado
        configurarUsuarios("individual");

        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear panel con la imagen de fondo
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("assets/Fondo_1.gif");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); // Espacio alrededor de la card

        // Crear card para el texto y los botones
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBackground(new Color(0, 0, 0, 200)); // Fondo negro transparente
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espacio dentro de la card

        // Crear mensaje de bienvenida centrado
        JLabel lblBienvenida = new JLabel(
                "<html><div style='text-align: center; font-size: 24pt; color: white;'>Bienvenido al juego Mil Millas</div></html>");

        // Crear pregunta centrada
        JLabel lblPregunta = new JLabel(
                "<html><div style='text-align: center; font-size: 18pt; color: white;'>¿Cómo deseas jugar?</div></html>");

        // Crear botones
        JButton btnJuegoIndividual = new JButton("Juego Individual");
        JButton btnJuegoParejas = new JButton("Juego en Parejas");

        // Establecer estilos para los botones
        btnJuegoIndividual.setForeground(Color.WHITE);
        btnJuegoIndividual.setBackground(new Color(0, 0, 0, 150)); // Fondo negro transparente
        btnJuegoIndividual.setFont(new Font("Poppins", Font.BOLD, 20)); // Tipo de letra Arial, negrita, tamaño 20

        btnJuegoParejas.setForeground(Color.WHITE);
        btnJuegoParejas.setBackground(new Color(0, 0, 0, 150)); // Fondo negro transparente
        btnJuegoParejas.setFont(new Font("Arial", Font.BOLD, 20)); // Tipo de letra Arial, negrita, tamaño 20

        // Agregar componentes a la card
        cardPanel.add(lblBienvenida, BorderLayout.NORTH);
        cardPanel.add(lblPregunta, BorderLayout.CENTER);

        // Crear panel para los botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 0)); // Usamos GridLayout para centrar los botones
                                                                       // horizontalmente
        panelBotones.setOpaque(false); // Hacer que el panel de botones sea transparente
        panelBotones.add(btnJuegoIndividual);
        panelBotones.add(btnJuegoParejas);
        cardPanel.add(panelBotones, BorderLayout.SOUTH);

        // Agregar la card al panel de fondo
        panelFondo.add(cardPanel, gbc);

        // Agregar el panel de fondo al frame
        add(panelFondo);
    }

    // Método para configurar los usuarios según el modo de juego
    private void configurarUsuarios(String modoJuego) {
        usuarios.clear(); // Limpiar lista de usuarios

        if (modoJuego.equals("individual")) {
            // Agregar usuarios para juego individual (2 o 3 jugadores)
            usuarios.add(new Usuario("Jugador 1"));
            usuarios.add(new Usuario("Jugador 2"));
            // Si es necesario, agregar más usuarios...
        } else if (modoJuego.equals("parejas")) {
            // Agregar usuarios para juego en parejas (4 o 6 jugadores)
            usuarios.add(new Usuario("Equipo 1 - Jugador 1"));
            usuarios.add(new Usuario("Equipo 1 - Jugador 2"));
            usuarios.add(new Usuario("Equipo 2 - Jugador 1"));
            usuarios.add(new Usuario("Equipo 2 - Jugador 2"));
            // Si es necesario, agregar más usuarios...
        }

        // Otros ajustes o configuraciones según el modo de juego...
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana de la interfaz
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InterfazJuegoCartas ventana = new InterfazJuegoCartas();
                ventana.setVisible(true);
            }
        });
    }
}