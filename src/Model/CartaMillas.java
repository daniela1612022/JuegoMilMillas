package Model;


public class CartaMillas extends Carta{
	
	private int puntosMillas;
	
	public CartaMillas(String nombre, int puntosMillas, String imagen) {
		// TODO Auto-generated constructor stub
		 super(nombre, imagen);
	     this.puntosMillas = puntosMillas;
	}
	
    @Override
    public void realizarAccion() {
        System.out.println("Andando con carta " + getNombre() + " - Puntos de millas: " + puntosMillas);
    }

}
