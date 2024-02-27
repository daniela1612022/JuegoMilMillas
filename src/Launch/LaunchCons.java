package Launch;

import javax.print.DocFlavor.BYTE_ARRAY;

import Model.Baraja;

public class LaunchCons {
	
	public static void main(String[] args) {
		
		Baraja bara = new Baraja();
		System.out.println("lista 1");
		bara.mostrarLista();
		
		for (int i = 0; i < 107; i++) {
			bara.robarCarta();			
		}
		System.out.println("lista 2");
		bara.mostrarLista();
		
		
		
		}

}
