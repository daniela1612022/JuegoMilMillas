package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Model.Baraja;
import Model.Carta;
import Model.CartaUsada;

public class ControladorBaraja implements ActionListener{

	private Baraja bara;
	private JButton b1,b2,b3,b4,b5,b6;
	private CartaUsada bote;
	
    public ControladorBaraja(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6, Baraja bara,CartaUsada bote) {
        this.bara = bara;
        this.bote = bote;
        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;
        this.b5=b5;
        this.b6=b6;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            if(b1.getText()=="Cambiado") {
            	ImageIcon iconoInicial1 = new ImageIcon(bote.getC1().getImagen());
            	bote.setC1(bara.robarCarta());
            	b1.setText(bote.getC1().getNombre());
            	b1.setIcon(dimensionarImagen(iconoInicial1, 100, 200));
            	
            }else {
            	if(b2.getText()=="Cambiado") {
                	ImageIcon iconoInicial2 = new ImageIcon(bote.getC2().getImagen());
            		bote.setC2(bara.robarCarta());
            		b2.setText(bote.getC2().getNombre());
                	b2.setIcon(dimensionarImagen(iconoInicial2, 100, 200));
                	
                }else {
                	if(b3.getText()=="Cambiado") {
                		ImageIcon iconoInicial3 = new ImageIcon(bote.getC3().getImagen());
                		bote.setC3(bara.robarCarta());
                		b3.setText(bote.getC3().getNombre());
                    	b3.setIcon(dimensionarImagen(iconoInicial3, 100, 200));

                    }else {
                    	if(b4.getText()=="Cambiado") {
                        	ImageIcon iconoInicial4 = new ImageIcon(bote.getC4().getImagen());
                    		bote.setC4(bara.robarCarta());
                    		b4.setText(bote.getC4().getNombre());
                        	b4.setIcon(dimensionarImagen(iconoInicial4, 100, 200));
                        	
                        }else {
                        	if(b5.getText()=="Cambiado") {

                            	ImageIcon iconoInicial5 = new ImageIcon(bote.getC5().getImagen());
                        		bote.setC5(bara.robarCarta());
                        		b5.setText(bote.getC5().getNombre());
                            	b5.setIcon(dimensionarImagen(iconoInicial5, 100, 200));
                            	
                            }else {
                            	if(b6.getText()=="Cambiado") {

                                	ImageIcon iconoInicial6 = new ImageIcon(bote.getC6().getImagen());
                            		bote.setC6(bara.robarCarta());
                            		b6.setText(bote.getC6().getNombre());
                                	b6.setIcon(dimensionarImagen(iconoInicial6, 100, 200));
                                	
                                }
                            }
                        }
                    }
                }
            }
            boton.setText(" Hay" + bara.mostrarTamanio()+" Cartas");
            boton.setEnabled(false);
            b1.setEnabled(true);
            b2.setEnabled(true);
        	b3.setEnabled(true);
        	b4.setEnabled(true);
        	b5.setEnabled(true);
        	b6.setEnabled(true);
            
        }
    
    }
    public ImageIcon dimensionarImagen(ImageIcon a, int anchoBoton, int altoBoton) {
		// TODO Auto-generated method stub
    	
    	Image imagenRedimensionada = a.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
    	ImageIcon im = new ImageIcon(imagenRedimensionada);
    	
    	return im;

	}

}
