package Poker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Contiene toda la lógica del juego.
 * @author 
 *
 */
public class Poker extends JFrame {
	/**
	 * Contiene la imágen de la mesa de juego.
	 */
	JLabel imagenDeFondo = new JLabel(new ImageIcon("src/images/mesa.jpg"));
	/**
	 * Es el panel sobre el que se coloca la imágen de fondo y las cartas.
	 */
	JPanel panel = new JPanel();
	/**
	 * Contiene las cartas del juego.
	 */
	Baraja mazo = new Baraja();

	public static final int ANCHO=128;
	
	public static final int ALTO=196;
	
	private Jugador judador=new Jugador();
	private Jugador pc=new Jugador();
	
	
	
	
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
	
	/**
	 * Se ejecuta la interfaz gráfica del juego, se agrega el panel al frame.
	 */
	private void initGUI() {
		crearMesa();
		this.getContentPane().add(panel);
		panel.setLayout(null);
	}
	
	/**
	 * Agrega la imágen de fondo al panel, agrega las cartas a la mesa y las posiciona.
	 */
	private void crearMesa() {
		panel = new JPanel();
		imagenDeFondo.setBounds(0, 0, 1280, 720);
		panel.add(imagenDeFondo);
		agregarLasCartasALaMesa();
		posicionarMasoEnlaMesa();
	}
	
	/**
	 * Posiciona la baraja en la mesa.
	 */
	private void posicionarMasoEnlaMesa() {

		int x=900;
		int y=80;
		//vamos a graficar el mazo usaremos 20 cartas ara ello (ara que no quede muy grueso)
		for (int i=0;i<20;i++) {
			mazo.getBarajaFrancesa().get(i).setBounds(x,y,ANCHO,ALTO);
			x--;
			y--;
			
		}
	}
	 
	/**
	 * Agrega la baraja a la mesa.
	 */
	private void agregarLasCartasALaMesa() {
		for (int i=0;i<52;i++) {
		imagenDeFondo.add(mazo.getBarajaFrancesa().get(i));
		}
	}
}

















