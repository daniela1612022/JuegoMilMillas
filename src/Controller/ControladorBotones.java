package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Model.Baraja;
import Model.CartaUsada;


public class ControladorBotones implements ActionListener{

	private JLabel etiqueta;
	private JButton baraja, b1, b2, b3, b4, b5;
	private Baraja barajita;
	private CartaUsada bote;
	private int eval;
	
    public ControladorBotones(JLabel etiqueta, JButton baraja,JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,CartaUsada bote,Baraja bar, int a) {
        this.etiqueta = etiqueta;
        this.baraja = baraja;
        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;
        this.b5=b5;
        this.barajita= bar;
        this.bote = bote;
        this.eval=a;
 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            etiqueta.setIcon( boton.getIcon());
            ImageIcon iconoInicial = new ImageIcon("src/ImagenesFondo/Persona2.gif");
        	boton.setIcon(iconoInicial);
            boton.setText("Cambiado");
            boton.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            baraja.setEnabled(true);
            
            if(eval==1) {
            	barajita.agregarBotada(bote.getC1());
            }else {
            	if(eval==2) {
                	
            		barajita.agregarBotada(bote.getC2());
                }else {
                	if(eval==3) {
                		barajita.agregarBotada(bote.getC3());
                    }else {
                    	if(eval==4) {
                    		barajita.agregarBotada(bote.getC4());
                        }else {
                        	if(eval==5) {
                        		barajita.agregarBotada(bote.getC5());
                            }else {
                            	if(eval==6) {
                            		barajita.agregarBotada(bote.getC6());
                                }
                            }
                        }
                    }
                }
            }
        }
    
}
    
}
