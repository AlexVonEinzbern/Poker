package Poker;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Contiene toda la lógica del juego.
 * 
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
	public static final int ANCHO = 64;
	public static final int ALTO = 98;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private ArrayList<Carta> cartasComunitarias = new ArrayList<Carta>();
	private ArrayList<JLabel> nombres = new ArrayList<JLabel>();
	private ArrayList<JLabel> dineros = new ArrayList<JLabel>();
	JLabel iDealer = new JLabel(new ImageIcon( "src/images/dealer.png"));		
    Jugador dealer = new Jugador();

	public Poker() {
		try {
			initGUI();
			//Default window config
			this.setUndecorated(false);
			this.pack();
			this.setResizable(false);
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
		
		this.getContentPane().add(panel);
		panel.setLayout(null);
	//
		iniciarJuego();
	}
	/**
	 * Agrega la imágen de fondo al panel, agrega las cartas a la mesa y las posiciona.
	 */
	public void iniciarJuego() {
	
    int etapa;

    
    
	crearMesa();

	crearJugadores();
	repartirParaIniciar();
	verTodo();
	dealer=jugadores.get(4);
	posicionarIDialer();
	
	
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

<<<<<<< HEAD
		int x=900;
		int y=80;
		//vamos a graficar el mazo usaremos 20 cartas para ello.
		for (int i=0;i<20;i++) {
			mazo.getBarajaFrancesa().get(i).setBounds(x,y,ANCHO,ALTO);
			x--;
			y--;
=======
				
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
			
>>>>>>> branch 'master' of https://github.com/AlexVonEinzbern/Poker.git
		}

	public void crearJugadores() {

		int cuantosJugadores=Integer.parseInt(JOptionPane.showInputDialog("cuantos Jugadores?"));
		for (int cuantos=0;cuantos<cuantosJugadores;cuantos++) {
			jugadores.add(new Jugador());
			jugadores.get(cuantos).setDinero(100);
			jugadores.get(cuantos).setNombre(JOptionPane.showInputDialog("nombre del jugador "+ (cuantos+1)));
		}
		posicionarNombreDelosJugadores();
	}
	
	public void repartir (Jugador quien) {
		for (int i=0;i<2;i++) {
			quien.getMisCartas().add(mazo.getBarajaFrancesa().get(0));
			mazo.getBarajaFrancesa().remove(0);
			imagenDeFondo.add(quien.getMisCartas().get(i));
		}
	}
	private void crearMesa() {
		
		imagenDeFondo.setBounds(0, 0, 960, 540);
		panel.add(imagenDeFondo);
		agregarLasCartasALaMesa();
		imagenDeFondo.add(iDealer);
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

	}
	public void posicionarNombreDelosJugadores() {
		
		for  (int i=0;i<jugadores.size();i++) {
		
			JLabel nombreDelJugador = new JLabel(jugadores.get(i).getNombre(),JLabel.CENTER);
			nombres.add(nombreDelJugador);
			JLabel dineroDelJugador = new JLabel(Integer.toString(jugadores.get(i).getDinero())+"$",JLabel.CENTER);
			dineros.add(dineroDelJugador);	
			
			nombres.get(i).setFont(new Font("Serif", Font.BOLD, 14));		
			nombres.get(i).setForeground(Color.WHITE);
			dineros.get(i).setFont(new Font("Serif", Font.BOLD, 14));		
			dineros.get(i).setForeground(Color.YELLOW);
			
			imagenDeFondo.add(nombres.get(i));
			imagenDeFondo.add(dineros.get(i));
		}
		
		//nombre y dinero  del jugador 1
		
		if (jugadores.size()>0) {
		nombres.get(0).setBounds(293, 10, 80, 16);
		dineros.get(0).setBounds(293, 26, 80, 16);
		}
		// nombre y dinero del jugador 2

		if (jugadores.size()>1) {
		nombres.get(1).setBounds(593, 10, 80, 16);
		dineros.get(1).setBounds(593, 26, 80, 16);
		}
		// nombre y dinero del jugador 3

		if (jugadores.size()>2) {
		nombres.get(2).setBounds(883, 250, 80, 16);
		dineros.get(2).setBounds(883, 266, 80, 16);
		}
		// nombre y dinero del jugador 4

		if (jugadores.size()>3) {
		nombres.get(3).setBounds(593, 490, 80, 16);
		dineros.get(3).setBounds(593, 506, 80, 16);
		}
		
		if (jugadores.size()>4) {
		// nombre y dinero del jugador 5
		nombres.get(4).setBounds(293, 490, 80, 16);
		dineros.get(4).setBounds(293, 506, 80, 16);	
		}
		
		if (jugadores.size()>5) {
		// nombre y dinero del jugador 6
		nombres.get(5).setBounds(1, 250, 78, 16);
		dineros.get(5).setBounds(1, 266, 78, 16);	
		}
		
	}
	public void  verTodo() {
		
		for (int j = 0; j < jugadores.size(); j++) {
			for (int i = 0; i < 2; i++) {
				jugadores.get(j).getMisCartas().get(i).voltear();

			}

		}

	}
	 public void posicionarIDialer() {
		 if (dealer==jugadores.get(0)) {
			 iDealer.setBounds(360,20,25,25);
		 }
		 
		 if (dealer==jugadores.get(1)) {
			 iDealer.setBounds(660,20,25,25);
		 }
		 
		 if (dealer==jugadores.get(2)) {
			 iDealer.setBounds(910,295,25,25);
		 }

		 if (dealer==jugadores.get(3)) {
			 iDealer.setBounds(570,495 ,25,25);
		 }
		 
		 if (dealer==jugadores.get(4)) {
			 iDealer.setBounds(280,495 ,25,25);
		 }
		 
	 }
}

















