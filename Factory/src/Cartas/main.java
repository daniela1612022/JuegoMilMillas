package Cartas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
    public static void main(String[] args) {
        CartaFactory factory = new CartaProblemaFactory();
        Carta carta = factory.crearcarta();
        JPanel panel = new JPanel();
        carta.mostrarCartaEnVista(panel);
        factory = new CartaSeguridadFactory();
        carta = factory.crearcarta();
        carta.mostrarCartaEnVista(panel);
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
