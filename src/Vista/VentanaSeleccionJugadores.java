package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaSeleccionJugadores extends JPanel{
	
	private Image fondo;
	private JButton boton1, boton2;
	private JLabel labelSuperior;
	
	public VentanaSeleccionJugadores() {
		// TODO Auto-generated constructor stub
		setBackground(Color.white);
		labelSuperior = new JLabel("¿Como quieres jugar?", SwingConstants.CENTER);
	    add(labelSuperior, BorderLayout.CENTER);
	    labelSuperior.setBackground(Color.YELLOW);
        labelSuperior.setOpaque(true);
		boton1 = new JButton("Indivitual");
		boton2 = new JButton("Pareja");
		boton1.setBackground(Color.GREEN);
        boton2.setBackground(Color.BLUE);
        Dimension botonSize = new Dimension(100, 200);
        boton1.setPreferredSize(botonSize);
        boton2.setPreferredSize(botonSize);
		add(boton1);
		add(boton2);
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		fondo= new ImageIcon(getClass().getResource("/ImagenesFondo/Fondo.gif")).getImage();
		g.drawImage(fondo, 0, 0, 800, 600, this);
		setOpaque(false);
		super.paint(g);
		
	}
    /*@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		 g.setColor(Color.GRAY);
	     g.fillRect(100, 200, 500, 200);
	}
*/
}
