package Vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControladorBaraja;
import Controller.ControladorBotones;
import Model.Baraja;
import Model.CartaUsada;

public class VentanaJugador extends JPanel {
    
    private JButton carta1, carta2, carta3, carta4, carta5, carta6, baraja;
    private JLabel etiqueta;
    private Baraja barajita;
    //private Carta c1,c2,c3,c4,c5,c6;
    private CartaUsada bote;

    public VentanaJugador() {
    	
    	barajita = new Baraja();
    	barajita.mezclar();
    	bote = new CartaUsada(barajita.robarCarta(), barajita.robarCarta(), barajita.robarCarta(), barajita.robarCarta(), barajita.robarCarta(), barajita.robarCarta());
    	
    	
    	
    	ImageIcon iconoInicial1 = new ImageIcon(bote.getC1().getImagen());
    	ImageIcon iconoInicial2 = new ImageIcon(bote.getC2().getImagen());
    	ImageIcon iconoInicial3 = new ImageIcon(bote.getC3().getImagen());
    	ImageIcon iconoInicial4 = new ImageIcon(bote.getC4().getImagen());
    	ImageIcon iconoInicial5 = new ImageIcon(bote.getC5().getImagen());
    	ImageIcon iconoInicial6 = new ImageIcon(bote.getC6().getImagen());
    	
    	baraja= new JButton("BARAJA");
    	

        // Redimensionar la imagen para que se ajuste al botón
        
        
        carta1 = new JButton(dimensionarImagen(iconoInicial1, 100, 200));
        carta2 = new JButton(dimensionarImagen(iconoInicial2, 100,200));
        carta3 = new JButton(dimensionarImagen(iconoInicial3, 100,200));
        carta4 = new JButton(dimensionarImagen(iconoInicial4, 100,200));
        carta5 = new JButton(dimensionarImagen(iconoInicial5, 100,200));
        carta6 = new JButton(dimensionarImagen(iconoInicial6, 100,200));
        
        try {
            //ImageIcon iconoInicial = new ImageIcon("src/ImagenesFondo/Persona2.gif");
            etiqueta = new JLabel("baraja");
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen inicial: " + e.getMessage());
            etiqueta = new JLabel("Error al cargar la imagen inicial");
        }
        
        setLayout(null);

		carta1.setBounds(120, 10, 100, 200);
		carta2.setBounds(230, 10, 100, 200);
		carta3.setBounds(340, 10, 100, 200);
		carta4.setBounds(450, 10, 100, 200);
		carta5.setBounds(560, 10, 100, 200);
		carta6.setBounds(670, 10, 100, 200);
		baraja.setBounds(340,300,250,150);

		etiqueta.setBounds(120, 300, 100, 200);
		baraja.setEnabled(false);
		
		
		 ControladorBotones control1 = new ControladorBotones(etiqueta,baraja,carta6, carta2, carta3, carta4, carta5,bote,barajita,1);
		 ControladorBotones control2 = new ControladorBotones(etiqueta,baraja,carta1, carta6, carta3, carta4, carta5,bote,barajita,2);
		 ControladorBotones control3 = new ControladorBotones(etiqueta,baraja,carta1, carta2, carta6, carta4, carta5,bote,barajita,3);
		 ControladorBotones control4 = new ControladorBotones(etiqueta,baraja,carta1, carta2, carta3, carta6, carta5,bote,barajita,4);
		 ControladorBotones control5 = new ControladorBotones(etiqueta,baraja,carta1, carta2, carta3, carta4, carta6,bote,barajita,5);
		 ControladorBotones control6 = new ControladorBotones(etiqueta,baraja,carta1, carta2, carta3, carta4, carta5,bote,barajita,6);
		 
		 
	        carta1.addActionListener(control1);
	        carta2.addActionListener(control2);
	        carta3.addActionListener(control3);
	        carta4.addActionListener(control4);
	        carta5.addActionListener(control5);
	        carta6.addActionListener(control6);
	        
	    ControladorBaraja cBara = new ControladorBaraja(carta1, carta2, carta3, carta4, carta5, carta6, barajita,bote);
	    baraja.addActionListener(cBara);


        // Añadir la etiqueta antes de los botones en el panel
        add(etiqueta);
        add(carta1);
        add(carta2);
        add(carta3);
        add(carta4);
        add(carta5);
        add(carta6);
        add(baraja);
    }
    
    public ImageIcon dimensionarImagen(ImageIcon a, int anchoBoton, int altoBoton) {
		// TODO Auto-generated method stub
    	
    	Image imagenRedimensionada = a.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
    	ImageIcon im = new ImageIcon(imagenRedimensionada);
    	
    	return im;

	}
    
}

