package Model;

public class CartaSeguridad extends Carta{
	
	public int puntosSeguridad;
	
	public CartaSeguridad(String nombre, int puntosSeguridad, String imagen) {
		// TODO Auto-generated constructor stub
		 super(nombre, imagen);
	     this.puntosSeguridad = puntosSeguridad;
	}
	
    @Override
    public void realizarAccion() {
        System.out.println("Andando con carta " + getNombre() + " - Puntos de millas: " + puntosSeguridad);
    }

	

}
