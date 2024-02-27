package Model;

import java.util.ArrayList;
import java.util.List;

public class AsignacionCartas {
	
	public List<Carta> barajita;
	
	public AsignacionCartas() {
		// TODO Auto-generated constructor stub
		barajita= new ArrayList<>();
		CartaAtaque();
		CartaDefensa();
		CartaMillas();
		CartaSeguridad();
	}
	
	
	public void CartaMillas(){
		
		CartaMillas docientos = new CartaMillas("200", 200,"src/ImagenesFondo/200millas.png");
		CartaMillas cien = new CartaMillas("100", 100,"src/ImagenesFondo/100millas.png");
		CartaMillas setcinco = new CartaMillas("75", 75,"src/ImagenesFondo/75millas.png");
		CartaMillas cincuenta = new CartaMillas("50", 50,"src/ImagenesFondo/50millas.png");
		CartaMillas ventcinco = new CartaMillas("25", 25,"src/ImagenesFondo/25millas.png");
		
		anadirCarta(docientos, 4);
		anadirCarta(cien, 12);
		anadirCarta(setcinco, 10);
		anadirCarta(cincuenta, 10);
		anadirCarta(ventcinco, 10);
		
		

	}
	public void CartaSeguridad(){
		CartaSeguridad prioridad = new CartaSeguridad("Carta prioridad al paso",100,"src/ImagenesFondo/prioridadPaso.png");
		CartaSeguridad combustible = new CartaSeguridad("Combustible extra",100,"src/ImagenesFondo/combustibleExtra.png");
		CartaSeguridad as = new CartaSeguridad("as del volante",100,"src/ImagenesFondo/asAlVolante.png");
		CartaSeguridad aprueba = new CartaSeguridad("A prueba de pinchasos",100,"src/ImagenesFondo/apruebaPinchazo.png");
		
		anadirCarta(prioridad, 1);
		anadirCarta(combustible, 1);
		anadirCarta(as, 1);
		anadirCarta(aprueba, 1);

	}
	
	
	public void CartaAtaque(){

		CartaAtaque falta = new CartaAtaque("Falta de combustible", -1,"src/ImagenesFondo/FaltaCombust.png");
		CartaAtaque vel = new CartaAtaque("Velocidad maxima 50", -1,"src/ImagenesFondo/velMax50.png");
		CartaAtaque ponchaso = new CartaAtaque("Rueda pinchada", -1,"src/ImagenesFondo/pinchadura.png");
		CartaAtaque choque = new CartaAtaque("Choque", -1,"src/ImagenesFondo/Choque.png");
		CartaAtaque alto = new CartaAtaque("Pare", -1,"src/ImagenesFondo/stop.png");
		
		anadirCarta(falta, 3);
		anadirCarta(vel, 4);
		anadirCarta(ponchaso, 3);
		anadirCarta(choque, 3);
		anadirCarta(alto, 5);

	}
	
	public void CartaDefensa(){
		CartaDefensa fin = new CartaDefensa("No hay limites de velocidad", 0,"src/ImagenesFondo/finVelMax.png");
		CartaDefensa rueda = new CartaDefensa("Rueda de repuesto", 0,"src/ImagenesFondo/ruedaAuxilio.png");
		CartaDefensa taller = new CartaDefensa("Mecanico", 0,"src/ImagenesFondo/taller.png");
		CartaDefensa combustible = new CartaDefensa("Combustible lleno", 0,"src/ImagenesFondo/combustible.png");
		CartaDefensa siga = new CartaDefensa("siga", 0,"src/ImagenesFondo/siga.png");
		
		anadirCarta(fin, 6);
		anadirCarta(rueda, 6);
		anadirCarta(taller, 6);
		anadirCarta(combustible, 6);
		anadirCarta(siga, 14);

	}
	
	public void anadirCarta(Carta cartica, int cant){
		
		for (int i = 0; i < cant; i++) {
			barajita.add(cartica);
		}	
	}
	
	public List<Carta> getBarajita() {
		return barajita;
	}

}
