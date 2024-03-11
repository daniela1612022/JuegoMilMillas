package Cartas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartaSolucionFactory implements CartaFactory {
    private List<String> imagenes;

    public CartaSolucionFactory() {
        imagenes = new ArrayList<>();
        imagenes.add("/Milmillas/src/Imagenes/Siga.png");
        imagenes.add("/Milmillas/src/Imagenes/Fin Velocidad Maxima.png");
        imagenes.add("/Milmillas/src/Imagenes/Combustible Extra.png");
        imagenes.add("/Milmillas/src/Imagenes/Taller.png");
        imagenes.add("/Milmillas/src/Imagenes/Rueda de Auxilio.png");
        
        
    }
      

	@Override
	public Carta crearcarta() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int indice = rand.nextInt(imagenes.size());
		return new CartaSolucion(imagenes.get(indice));
	}

	@Override
	public void mostarCartaEnVista(JPanel panel) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int indice = rand.nextInt(imagenes.size());
		JLabel label = new JLabel(new String(imagenes.get(indice)));
		panel.add(label);
		
	}

}
