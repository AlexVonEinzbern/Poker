package Poker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Poker extends JFrame {
	JLabel imagenDeFondo = new JLabel(new ImageIcon("src/images/mesa.jpg"));
	JPanel panel = new JPanel();
	
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
	}
}
