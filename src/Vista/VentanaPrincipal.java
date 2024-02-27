package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VentanaPrincipal extends JPanel{
	
	private Image fondo;
	
	public VentanaPrincipal() {
		
		setBackground(Color.white);
		InterfazJuegoCartas vent1 = new InterfazJuegoCartas();
		VentanaJugador vent2 = new VentanaJugador();
		
		vent2.setBackground(Color.BLUE);
        vent2.setPreferredSize(new Dimension(800, 600));
        add(Box.createRigidArea(new Dimension(0, 650)));
		add(vent2,BorderLayout.CENTER);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		fondo= new ImageIcon(getClass().getResource("/ImagenesFondo/Fondo_1.gif")).getImage();
		g.drawImage(fondo, 0, 0, 1000, 700, this);
		setOpaque(false);
		super.paint(g);
		
	}
	


}
