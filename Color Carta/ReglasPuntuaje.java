import java.util.List;
import java.util.ArrayList;

public class ReglasPuntuaje {
    // Constantes para el puntaje
    private static final int PUNTAJE_POR_MILLAS = 1;
    private static final int PUNTAJE_CARTA_SEGURIDAD = 100;
    private static final int PUNTAJE_PREMIO_4_SEGURIDADES = 300;
    private static final int PUNTAJE_PREMIO_TK = 300;
    private static final int PUNTAJE_PREMIO_MIL_MILLAS = 400;
    private static final int PUNTAJE_PREMIO_ACCION_DEMORADA = 300;
    private static final int PUNTAJE_PREMIO_VIAJE_SEGURO = 300;
    private static final int PUNTAJE_PREMIO_BLOQUEO_TOTAL = 500;

    // Método para calcular el puntaje de una mano
    public int calcularPuntaje(int millasRecorridas, int cartasSeguridad, boolean premio4Seguridades,
            int tks, boolean completado1000Millas, boolean accionDemorada, boolean viajeSeguro,
            boolean bloqueoTotal) {
        int puntaje = millasRecorridas * PUNTAJE_POR_MILLAS;
        puntaje += cartasSeguridad * PUNTAJE_CARTA_SEGURIDAD;
        if (premio4Seguridades) puntaje += PUNTAJE_PREMIO_4_SEGURIDADES;
        puntaje += tks * PUNTAJE_PREMIO_TK;
        if (completado1000Millas) puntaje += PUNTAJE_PREMIO_MIL_MILLAS;
        if (accionDemorada) puntaje += PUNTAJE_PREMIO_ACCION_DEMORADA;
        if (viajeSeguro) puntaje += PUNTAJE_PREMIO_VIAJE_SEGURO;
        if (bloqueoTotal) puntaje += PUNTAJE_PREMIO_BLOQUEO_TOTAL;
        return puntaje;
    }

    // Método para verificar si una jugada es válida
    public boolean esJugadaValida(Jugador jugador, Carta carta) {
        // Implementa la lógica para verificar si la jugada es válida según las reglas del juego
        return true; // Cambia esto según la implementación real
    }

    // Método para verificar si un jugador ha completado las 1000 millas
    public boolean haCompletado1000Millas(int millasRecorridas) {
        return millasRecorridas == 1000;
    }

    // Método para verificar si la acción demorada se aplica
    public boolean aplicaAccionDemorada(List<Carta> mazo) {
        // Implementa la lógica para verificar si se aplica la acción demorada según las reglas del juego
        return false; // Cambia esto según la implementación real
    }

    // Otros métodos necesarios para implementar las reglas del juego
}
