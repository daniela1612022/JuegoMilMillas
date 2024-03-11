package Cartas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartaProblemaFactory implements CartaFactory {
    private List<String> imagenes;

    public CartaProblemaFactory() {
        imagenes = new ArrayList<>();
        imagenes.add("/Milmillas/src/Imagenes/STOP.png");
        imagenes.add("/Milmillas/src/Imagenes/Velocidad Maxima.png");
        imagenes.add("/Milmillas/src/Imagenes/Falta de Combustible.png");
        imagenes.add("/Milmillas/src/Imagenes/Choque.png");
        imagenes.add("/Milmillas/src/Imagenes/Pinchadura.png");
        
    }
        
    

	@Override
	public Carta crearcarta() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int indice = rand.nextInt(imagenes.size());
		return new CartaProblema(imagenes.get(indice));
		
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
