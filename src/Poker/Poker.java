package Poker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Poker extends JFrame {
	JLabel imagenDeFondo = new JLabel(new ImageIcon("src/images/mesa.jpg"));
	JPanel panel = new JPanel();
	Baraja mazo=new Baraja();
	public static final int ANCHO=128;
	public static final int ALTO=196;
	
	public Poker() {
		try {
			initGUI();
			//Default window config
			this.setUndecorated(false);
			pack();
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setSize(1280, 720);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No se ha encontrado la imágen de fondo");
		}
	}
	
	private void initGUI() {
		crearMesa();
		this.getContentPane().add(panel);
		panel.setLayout(null);
	}
	
	
	private void crearMesa() {
		
		panel = new JPanel();
		imagenDeFondo.setBounds(0, 0, 1280, 720);
		panel.add(imagenDeFondo);
		agregarLasCartasALaMesa();
		posicionarMasoEnlaMesa();
		JOptionPane.showMessageDialog(null, mazo.getBarajaFrancesa().size());
		
	}
	
	private void posicionarMasoEnlaMesa() {

		int x=0;
		int y=80;
		for (int i=0;i<52;i++) {
			mazo.getBarajaFrancesa().get(i).setBounds(x,y,ANCHO,ALTO);
			x+=5;
			
		}
	}
	 
	private void agregarLasCartasALaMesa() {
		for (int i=0;i<52;i++) {
		imagenDeFondo.add(mazo.getBarajaFrancesa().get(i));
		}
	}
}

















