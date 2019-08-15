package Poker;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<Carta> misCartas = new ArrayList<Carta>();
	private ArrayList<Carta> miJugada = new ArrayList<Carta>();
	private int valorDeMiJugada;

	/**
	 * determina la mejor jugada de un jugador empezando por la mejor jugada y
	 * buscar la jugada inmediatmente inferior si la anterior no existe.
	 * 
	 */
	public boolean tengoUnaEscaleraRealDeColor() {

		boolean laTengo = false;
		/**
		 * vamos a ver si tenemos un escalera real de color
		 * (una escalera del 10 al as con todos los palos iguales)
		 */
		
		for (int i = 0; i < misCartas.size(); i++) {
			/**
			 * vamos a buscar un diez
			 */
			if (misCartas.get(i).getValorNumerico() == 10) {

				/**
				 * el diez hallado es de picas
				 */
				if (misCartas.get(i).getPalo() == "p") {

					if (misCartas.contains(new Carta(11, "J", "P", "n"))
							&& misCartas.contains(new Carta(12, "Q", "P", "n"))
							&& misCartas.contains(new Carta(13, "K", "P", "n"))
							&& misCartas.contains(new Carta(1, "A", "P", "n"))) {
						laTengo = true;
					} else
						laTengo = false;
				}

				/**
				 * el diez hallado es de diamantes
				 */
				else if (misCartas.get(i).getPalo() == "d") {

					if (misCartas.contains(new Carta(11, "J", "d", "r"))
							&& misCartas.contains(new Carta(12, "Q", "d", "n"))
							&& misCartas.contains(new Carta(13, "K", "d", "r"))
							&& misCartas.contains(new Carta(1, "A", "d", "r"))) {
						laTengo = true;
					} else
						laTengo = false;

				}

				/**
				 * el diez hallado es de treboles
				 */
				else if (misCartas.get(i).getPalo() == "t") {

					if (misCartas.contains(new Carta(11, "J", "t", "n"))
							&& misCartas.contains(new Carta(12, "Q", "t", "n"))
							&& misCartas.contains(new Carta(13, "K", "t", "n"))
							&& misCartas.contains(new Carta(1, "A", "t", "n"))) {
						laTengo = true;
					} else
						laTengo = false;

				}
				/**
				 * el diez hallado es de treboles
				 */
				else if (misCartas.get(i).getPalo() == "c") {

					if (misCartas.contains(new Carta(11, "J", "c", "r"))
							&& misCartas.contains(new Carta(12, "Q", "c", "r"))
							&& misCartas.contains(new Carta(13, "K", "c", "r"))
							&& misCartas.contains(new Carta(1, "A", "c", "r"))) {
						laTengo = true;
					} else
						laTengo = false;

				}
			} // si no tengo un diez definitivamente no mpuedo tener una escalera real de
				// color
			else
			laTengo = false;
		}

		return laTengo;
	}


	public boolean tengoUnaEscaleraReal() {
		boolean laTengo = false;
		if ((misCartas.contains(new Carta(valorDeMiJugada, nombre, nombre, nombre).getSimbolo()=="10")||
			misCartas.contains(new Carta(10,"10","p","n"))||
			misCartas.contains(new Carta(10,"10","d","r"))||
			misCartas.contains(new Carta(10,"10","p","n")))&&
				(misCartas.contains(new Carta(11,"J","c","r"))||
				 misCartas.contains(new Carta(11,"J","p","n"))||
				 misCartas.contains(new Carta(11,"J","p","n"))||
				 misCartas.contains(new Carta(11,"J","p","n")))){
			
		}
	return laTengo;
	}
}