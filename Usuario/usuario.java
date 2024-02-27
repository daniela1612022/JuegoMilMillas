package Usuario;

import java.util.ArrayList;
import java.util.List;

import Carta.Carta; // Importa la clase Carta del paquete Carta

public class Usuario {
    private String nombre;
    private List<Carta> mano;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    // Método para recibir cartas
    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    // Método para jugar una carta de la mano
    public Carta jugarCarta(int indice) {
        if (indice >= 0 && indice < mano.size()) {
            return mano.remove(indice);
        } else {
            return null;
        }
    }

    // Método para obtener el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la mano del usuario
    public List<Carta> getMano() {
        return mano;
    }

    // Método para determinar el tipo de juego del usuario
    public static String determinarTipoJuego(int numJugadores) {
        if (numJugadores == 2 || numJugadores == 3) {
            return "individual";
        } else if (numJugadores == 4 || numJugadores == 6) {
            return "parejas";
        } else {
            return "No válido";
        }
    }
}