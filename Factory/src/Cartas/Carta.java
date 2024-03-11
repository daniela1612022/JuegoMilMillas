package Cartas;

import javax.swing.*;
import java.awt.*;

abstract class Carta {
    private String imagen; 

    public Carta(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

	public void mostrarCartaEnVista(JPanel panel) {
		// TODO Auto-generated method stub
		
	}

}
