package Cartas;

import javax.swing.JPanel;

public interface CartaFactory {
	Carta crearcarta();
	void mostarCartaEnVista(JPanel panel);


}
