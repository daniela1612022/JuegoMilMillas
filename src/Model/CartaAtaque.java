package Model;

public class CartaAtaque extends Carta {
    private int puntosAtaque;

    public CartaAtaque(String nombre, int puntosAtaque, String imagen) {
        super(nombre, imagen);
        this.puntosAtaque = puntosAtaque;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    @Override
    public void realizarAccion() {
        System.out.println("Atacando con carta " + getNombre() + " - Puntos de ataque: " + puntosAtaque);
    }
}
