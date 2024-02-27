package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;
    private List<Carta> botadas;
    private AsignacionCartas cartica;

    public Baraja() {
    	cartica = new AsignacionCartas();
    	cartas = cartica.getBarajita();
    	botadas = new ArrayList<>();
    	// Aquí puedes agregar cartas a la baraja durante la inicialización, si es necesario.
    }

    public void agregarBotada(Carta carta) {
        botadas.add(carta);
    }

    public void mezclar() {
        Collections.shuffle(cartas);
    }

    public Carta robarCarta() {
        if (!cartas.isEmpty()) {
        	System.out.println(cartas.get(0).getNombre());
            return cartas.remove(0);
        } else {
            System.out.println("La baraja está vacía. No se puede robar ninguna carta.");       
            cartas.addAll(botadas);
            mezclar();
            botadas.clear();
            return cartas.remove(0);
        }
    }
    
    public void mostrarLista() {
    	
    	for(int i = 0;i<cartas.size();i++)
    	{
    	    System.out.println(cartas.get(i).getNombre());
    	}
    	
    }
    
    public int mostrarTamanio() {
    	System.out.println(cartas.size());
    	return cartas.size();
    }
    
    
    


}

