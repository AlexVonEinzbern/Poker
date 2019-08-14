package Poker;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<Carta> misCartas=new ArrayList<Carta>();
	private ArrayList<Carta> miJugada=new ArrayList<Carta>();
	private int valorDeMiJugada;
	

	/**
	 * determina la mejor jugada de un jugador empezando por la mejor jugada
	 * y buscar la jugada inmediatmente inferior si la anterior no existe.
	 * 
	 */
	public void queJugadaTnngo() {
		
	/**
	 * vamos a ver si tenemos un escalera real de color
	 */
		
	
	for  (int i=0;i<misCartas.size();i++){
		
		if (misCartas.get(i).getValorNumerico()==10) {
			
		}
	}
	
	
	
	}
	
}
