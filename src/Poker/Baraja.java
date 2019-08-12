package Poker;

import java.util.ArrayList;

public class Baraja {

	private ArrayList<Carta> barajaFrancesa = new ArrayList<Carta>();

	public void crearUnaBaraja() {

		char[] palos = { 'p', 'd', 't', 'c' };
		char[] colores = { 'n', 'r', 'n', 'r' };
		String[] simbolos = { "J", "Q", "k", "A" };

		// agregar cartas nuericas a la baraja francesa
		for (int palo = 0; palo < 5; palo++) {

			for (int desde = 2; desde < 11; desde++) {
				barajaFrancesa.add(new Carta(desde, Integer.toString(desde), palos[palo], colores[palo]));
			}
		}

		// agregar cartas J,Q,K a la baraja francesa

		for (int palo = 0; palo < 5; palo++) {

			for (int desde = 0; desde < 4; desde++) {
				barajaFrancesa.add(new Carta(10, simbolos[desde], palos[palo], colores[palo]));
			}
		}

		// agregar cartas A a la baraja francesa

		for (int desde = 0; desde < 5; desde++) {
			barajaFrancesa.add(new Carta(1, simbolos[3], palos[desde], colores[desde]));
		}

	}

	public Baraja() {
		crearUnaBaraja();
	}

	public ArrayList<Carta> getBarajaFrancesa() {
		return barajaFrancesa;
	}
}