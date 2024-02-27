package Model;

public class Carta {
    private String nombre;
    private String imagen;

    public Carta(String nombre,String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void realizarAccion() {
        System.out.println("Acción genérica de la carta: " + nombre);
    }
    public String getImagen() {
		return imagen;
	}
    
}