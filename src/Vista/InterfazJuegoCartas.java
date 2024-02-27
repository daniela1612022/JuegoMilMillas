package Vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazJuegoCartas extends JFrame {
    public InterfazJuegoCartas() {
        super("Juego de Cartas");

        // Configuración del frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear panel con la imagen de fondo
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("src/ImagenesFondo/Fondo.gif");
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
        Color cardColor = new Color(173, 216, 230, 220); // Fondo azul claro con opacidad
        cardPanel.setBackground(cardColor);
        cardPanel.setBorder(new CompoundBorder(new EmptyBorder(20, 20, 20, 20), new RoundedBorder(20))); // Borde redondeado

        // Crear mensaje de bienvenida centrado
        JLabel lblBienvenida = new JLabel("<html><div style='text-align: center; font-size: 24pt; color: white;'>Bienvenido al juego Mil Millas</div></html>");

        // Crear pregunta centrada y justificada
        JLabel lblPregunta = new JLabel("<html><div style='text-align: justify; text-align: center; font-size: 18pt; color: white;'>¿Cómo deseas jugar?</div></html>");

        // Crear botones
        JButton btnJuegoIndividual = new JButton("Juego Individual");
        JButton btnJuegoParejas = new JButton("Juego en Parejas");

        // Establecer estilos para los botones
        Color btnColor = cardColor; // Mismo color que la tarjeta
        btnJuegoIndividual.setForeground(Color.WHITE);
        btnJuegoIndividual.setBackground(btnColor);
        btnJuegoIndividual.setFont(new Font("Arial", Font.BOLD, 20)); // Tipo de letra Arial, negrita, tamaño 20
        btnJuegoIndividual.setBorder(new RoundedBorder(20)); // Borde redondeado
        btnJuegoIndividual.setMargin(new Insets(20, 20, 20, 20)); // Ajustar los márgenes

        btnJuegoParejas.setForeground(Color.WHITE);
        btnJuegoParejas.setBackground(btnColor);
        btnJuegoParejas.setFont(new Font("Arial", Font.BOLD, 20)); // Tipo de letra Arial, negrita, tamaño 20
        btnJuegoParejas.setBorder(new RoundedBorder(20)); // Borde redondeado
        btnJuegoParejas.setMargin(new Insets(20, 20, 20, 20)); // Ajustar los márgenes

        // Agregar ActionListener al botón "Juego Individual"
        btnJuegoIndividual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un JOptionPane con un JComboBox para seleccionar el número de jugadores
                String[] options = {"2 jugadores", "3 jugadores"}; // Opciones disponibles
                String selectedOption = (String) JOptionPane.showInputDialog(
                        InterfazJuegoCartas.this, 
                        "Selecciona el número de jugadores:",
                        "Número de jugadores",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]); // Opción seleccionada por defecto
                if (selectedOption != null) {
                    if (selectedOption.equals("2 jugadores")) {
                    	Tablero tablero = new Tablero();
                        tablero.setVisible(true);
                    }
                    // Aquí puedes realizar alguna acción según la opción seleccionada
                    System.out.println("Seleccionaste: " + selectedOption);
                }
            }
        });

        // Agregar ActionListener al botón "Juego en Parejas"
        btnJuegoParejas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un JOptionPane con un JComboBox para seleccionar el número de jugadores
                String[] options = {"4 jugadores", "6 jugadores"}; // Opciones disponibles
                String selectedOption = (String) JOptionPane.showInputDialog(
                        InterfazJuegoCartas.this, 
                        "Selecciona el número de jugadores:",
                        "Número de jugadores",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]); // Opción seleccionada por defecto
                if (selectedOption != null) {
                    // Aquí puedes realizar alguna acción según la opción seleccionada
                    System.out.println("Seleccionaste: " + selectedOption);
                }
            }
        });

        // Agregar componentes a la card
        cardPanel.add(lblBienvenida, BorderLayout.NORTH);
        cardPanel.add(lblPregunta, BorderLayout.CENTER);

        // Crear panel para los botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 0)); // Usamos GridLayout para centrar los botones horizontalmente
        panelBotones.setOpaque(false); // Hacer que el panel de botones sea transparente
        panelBotones.setBorder(new EmptyBorder(20, 0, 0, 0)); // Agregar espacio en la parte superior
        panelBotones.add(btnJuegoIndividual);
        panelBotones.add(btnJuegoParejas);
        cardPanel.add(panelBotones, BorderLayout.SOUTH);

        // Agregar la card al panel de fondo
        panelFondo.add(cardPanel, gbc);

        // Agregar el panel de fondo al frame
        add(panelFondo);
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

class RoundedBorder implements Border {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.WHITE); // Puedes cambiar este color si deseas un borde de un color diferente
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
