package Cartas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartaDistanciaFactory implements CartaFactory {
    private List<String> imagenes;

    public CartaDistanciaFactory() {
        imagenes = new ArrayList<>();
        imagenes.add("/Milmillas/src/Imagenes/25 M_H.png");
        imagenes.add("/Milmillas/src/Imagenes/50 M_H.png");
        imagenes.add("/Milmillas/src/Imagenes/75 M_H.png");
        imagenes.add("/Milmillas/src/Imagenes/100 M_H.png");
        imagenes.add("/Milmillas/src/Imagenes/200 M_H.png");
    }


	@Override
	public Carta crearcarta() {
        Random rand = new Random();
        int indice = rand.nextInt(imagenes.size());
        return new CartaDistancia(imagenes.get(indice));
	}

	@Override
	public void mostarCartaEnVista(JPanel panel) {
        Random rand = new Random();
        int indice = rand.nextInt(imagenes.size());
        JLabel label = new JLabel(new String(imagenes.get(indice)));
        panel.add(label);
		
	}


}
