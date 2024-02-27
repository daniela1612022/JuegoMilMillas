package Vista;

import javax.swing.JFrame;

public class JuegoMillas extends JFrame{
	
	public JuegoMillas() {
		// TODO Auto-generated constructor stub
		setTitle("JuegoMillas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		VentanaPrincipal vent0= new VentanaPrincipal();		
		add(vent0);;
		setSize(1000,700);
		setVisible(true);
		setResizable(false);
		
		
	}

}
