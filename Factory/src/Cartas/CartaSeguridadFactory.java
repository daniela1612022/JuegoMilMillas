package Cartas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartaSeguridadFactory implements CartaFactory {
    private List<String> imagenes;

    public CartaSeguridadFactory() {
        imagenes = new ArrayList<>();
        imagenes.add("/Milmillas/src/Imagenes/Prioridad de Paso.png");
        imagenes.add("/Milmillas/src/Imagenes/Combustible Extra.png");
        imagenes.add("/Milmillas/src/Imagenes/As del Volante.png");
        imagenes.add("/Milmillas/src/Imagenes/A Prueba de Pinchadura.png");
    }

	@Override
	public Carta crearcarta() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int indice = rand.nextInt(imagenes.size());
		return new CartaSeguridad(imagenes.get(indice));
		
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
