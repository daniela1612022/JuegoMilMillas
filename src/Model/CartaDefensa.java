package Model;

public class CartaDefensa extends Carta {
    private int puntosDefensa;

    public CartaDefensa(String nombre, int puntosDefensa, String imagen) {
        super(nombre, imagen);
        this.puntosDefensa = puntosDefensa;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    @Override
    public void realizarAccion() {
        System.out.println("Defendiendo con carta " + getNombre() + " - Puntos de defensa: " + puntosDefensa);
    }
}