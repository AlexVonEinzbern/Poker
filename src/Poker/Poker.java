package Poker;

import java.util.ArrayList;
import java.util.Scanner;

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

	
	public static final int ANCHO=64;
	
	public static final int ALTO=98;
	
	private ArrayList<Jugador> jugadores =new ArrayList<Jugador>();
	private ArrayList<Carta> cartasComunitarias =new ArrayList<Carta>();
	
	
	
	
	//128 196    64  98  
	public Poker() {
		try {
			initGUI();
			//Default window config
			this.setUndecorated(false);
			pack();
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setSize(960, 540);
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
	//
		iniciarJuego();
	}
	
	/**
	 * Agrega la imágen de fondo al panel, agrega las cartas a la mesa y las posiciona.
	 */
	private void crearMesa() {
	
		imagenDeFondo.setBounds(0, 0, 960, 540);
		panel.add(imagenDeFondo);
		agregarLasCartasALaMesa();
		posicionarMasoEnlaMesa();
	}
	
	/**
	 * Posiciona la baraja en la mesa.
	 */
	private void posicionarMasoEnlaMesa() {

		int x=850;
		int y=10;
		//vamos a graficar el mazo usaremos 20 cartas ara ello (ara que no quede muy grueso)
		for (int i=0;i<10;i++) {
			mazo.getBarajaFrancesa().get(i).setBounds(x,y,ANCHO,ALTO);
			x--;
			y--;
			
		}
	}
	 

	public void iniciarJuego() {
	sacarDelMazo();
	crearJugadores();
	repartirParaIniciar();
	sacarDelMazo();
	sacarDelMazo();
	
	}
	
	public void sacarDelMazo(){
		if (cartasComunitarias.size()<=0) {
			for (int i=0;i<3;i++) {
				cartasComunitarias.add(mazo.getBarajaFrancesa().get(0));
				mazo.getBarajaFrancesa().remove(0);
				imagenDeFondo.add(cartasComunitarias.get(i));
			}
			
			cartasComunitarias.get(0).setBounds(265+53, 221, ANCHO, ALTO);
			cartasComunitarias.get(1).setBounds(265+65+53, 221, ANCHO, ALTO);
			cartasComunitarias.get(2).setBounds(265+65+65+53, 221, ANCHO, ALTO);

				
			}else if (cartasComunitarias.size()==3) {
				cartasComunitarias.add(mazo.getBarajaFrancesa().get(0));
				mazo.getBarajaFrancesa().remove(0);
				imagenDeFondo.add(cartasComunitarias.get(3));
				cartasComunitarias.get(3).setBounds(265+65+65+65+53, 221, ANCHO, ALTO);
				
			}else if (cartasComunitarias.size()==4) {
				cartasComunitarias.add(mazo.getBarajaFrancesa().get(0));
				mazo.getBarajaFrancesa().remove(0);
				imagenDeFondo.add(cartasComunitarias.get(4));
				cartasComunitarias.get(4).setBounds(265+65+65+65+65+53, 221, ANCHO, ALTO);
			}
		
		for (int i=0;i<cartasComunitarias.size();i++) {
			cartasComunitarias.get(i).voltear();
		}
			
		}
	
	
		
	
	public void crearJugadores() {

		int cuantosJugadores=Integer.parseInt(JOptionPane.showInputDialog("cuantos Jugadores?"));
		for (int cuantos=0;cuantos<cuantosJugadores;cuantos++) {
			jugadores.add(new Jugador());
		}
	}
	
	public void repartir (Jugador quien) {
		for (int i=0;i<2;i++) {
			quien.getMisCartas().add(mazo.getBarajaFrancesa().get(0));
			mazo.getBarajaFrancesa().remove(0);
			imagenDeFondo.add(quien.getMisCartas().get(i));
		}
	}
	
	
	public void repartirParaIniciar() {
		for (int i = 0; i < jugadores.size(); i++) {
			repartir(jugadores.get(i));
		}
		posicionarCartasDeLosJugadores();
	}

	/**
	 * Agrega la baraja a la mesa.
	 */
	private void agregarLasCartasALaMesa() {
		for (int i=0;i<52;i++) {
		imagenDeFondo.add(mazo.getBarajaFrancesa().get(i));
		}
	}
		
	public void posicionarCartasDeLosJugadores(){
	//	posicionando jugador 1

		if (jugadores.size()>0) {
			
			jugadores.get(0).getMisCartas().get(0).setBounds(265, 60, ANCHO, ALTO);

			jugadores.get(0).getMisCartas().get(1).setBounds(
					jugadores.get(0).getMisCartas().get(0).getBounds().x + 67,60, ANCHO, ALTO);
		}

	//	posicionando jugador 2

		if (jugadores.size()>1) {

			jugadores.get(1).getMisCartas().get(0).setBounds(565, 60, ANCHO, ALTO);
			
			jugadores.get(1).getMisCartas().get(1).setBounds(
					jugadores.get(1).getMisCartas().get(0).getBounds().x + 67,60,ANCHO,ALTO);
		}
		
//		posicionando jugador 3

		if (jugadores.size()>2) {

				jugadores.get(2).getMisCartas().get(0).setBounds(745, 221, ANCHO, ALTO);
				
				jugadores.get(2).getMisCartas().get(1).setBounds(
						jugadores.get(2).getMisCartas().get(0).getBounds().x + 67,221,ANCHO,ALTO);
			}
		
		
//		posicionando jugador 4

		if (jugadores.size()>3) {

				jugadores.get(3).getMisCartas().get(0).setBounds(565, 380, ANCHO, ALTO);
				
				jugadores.get(3).getMisCartas().get(1).setBounds(
						jugadores.get(3).getMisCartas().get(0).getBounds().x + 67,380,ANCHO,ALTO);
			}
		
		
		
//		posicionando jugador 5

		if (jugadores.size()>4) {

				jugadores.get(4).getMisCartas().get(0).setBounds(265, 380, ANCHO, ALTO);
				
				jugadores.get(4).getMisCartas().get(1).setBounds(
						jugadores.get(4).getMisCartas().get(0).getBounds().x + 67,380,ANCHO,ALTO);
			}
		
		
//		posicionando jugador 6

		if (jugadores.size()>5) {

				jugadores.get(5).getMisCartas().get(0).setBounds(91, 221, ANCHO, ALTO);
				
				jugadores.get(5).getMisCartas().get(1).setBounds(
						jugadores.get(5).getMisCartas().get(0).getBounds().x + 67,221,ANCHO,ALTO);
			}
		
		
		
	
		posicionarMasoEnlaMesa();
	}
}

















