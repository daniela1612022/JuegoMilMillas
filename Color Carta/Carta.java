import java.util.ArrayList;
import java.util.List;

public class Carta {
    private String color;
    private String nombre;
    private int cantidad;

    public Carta(String color, String nombre, int cantidad) {
        this.color = color;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para generar un mazo de cartas basado en las especificaciones proporcionadas
    public static List<Carta> generarMazo() {
        List<Carta> mazo = new ArrayList<>();

        // Cartas de color amarillo
        mazo.add(new Carta("amarillo", "Seguridad Prioridad de paso", 1));
        mazo.add(new Carta("amarillo", "Combustible extra", 1));
        mazo.add(new Carta("amarillo", "As del volante", 1));
        mazo.add(new Carta("amarillo", "A prueba de Pinchaduras", 1));

        // Cartas de color gris
        mazo.add(new Carta("gris", "Distancia 25 Km/h", 10));
        mazo.add(new Carta("gris", "Distancia 50 Km/h", 10));
        mazo.add(new Carta("gris", "Distancia 75 Km/h", 10));
        mazo.add(new Carta("gris", "Distancia 100 Km/h", 12));
        mazo.add(new Carta("gris", "Distancia 200 Km/h", 4));

        // Cartas de color rojo
        mazo.add(new Carta("rojo", "Problemas Stop", 5));
        mazo.add(new Carta("rojo", "Velocidad maxima 50 Km/h", 4));
        mazo.add(new Carta("rojo", "Sin Gasolina", 3));
        mazo.add(new Carta("rojo", "Accidente", 3));
        mazo.add(new Carta("rojo", "Pinchadura", 3));

        // Cartas de color verde
        mazo.add(new Carta("verde", "Soluciones Siga", 14));
        mazo.add(new Carta("verde", "Fin velocidad Maxima", 6));
        mazo.add(new Carta("verde", "Gasolina", 6));
        mazo.add(new Carta("verde", "Taller", 6));
        mazo.add(new Carta("verde", "Llanta de Repuesto", 6));

        return mazo;
    }

    public static void main(String[] args) {
        List<Carta> mazo = Carta.generarMazo();

        // Imprimir el mazo de cartas generado
        for (Carta carta : mazo) {
            System.out.println("Color: " + carta.getColor() + ", Nombre: " + carta.getNombre() + ", Cantidad: " + carta.getCantidad());
        }
    }
}