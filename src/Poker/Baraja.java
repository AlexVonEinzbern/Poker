package Poker;

import java.util.ArrayList;

public class Baraja {

	private ArrayList<Carta> barajaFrancesa = new ArrayList<Carta>();

	public void crearUnaBaraja() {
		int valor=11;

		String[] palos = { "p", "d", "t", "c" };
		String[] colores = { "n", "r", "n", "r" };
		String[] simbolos = { "J", "Q", "K", "A" };

		// agregar cartas nuericas a la baraja francesa
		for (int palo = 0; palo < 4; palo++) {

			for (int desde = 2; desde < 11; desde++) {
				barajaFrancesa.add(new Carta(desde, Integer.toString(desde), palos[palo], colores[palo]));
			}
		}

		// agregar cartas J,Q,K a la baraja francesa

		for (int letra = 0; letra < 3; letra++) {
			

			for (int palo = 0; palo < 4; palo++) {
				barajaFrancesa.add(new Carta(valor, simbolos[letra], palos[palo], colores[palo]));
			}
			valor++;
		}

		// agregar cartas A a la baraja francesa

			for (int palo = 0; palo < 4; palo++) {
				barajaFrancesa.add(new Carta(1, simbolos[3], palos[palo], colores[palo]));
			}
	} 

	public Baraja() {
		crearUnaBaraja();
	}

	public ArrayList<Carta> getBarajaFrancesa() {
		return barajaFrancesa;
	}
}