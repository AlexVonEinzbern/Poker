package Poker;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private int dinero;
	private ArrayList<Carta> misCartas = new ArrayList<Carta>();
	private ArrayList<Carta> miJugada = new ArrayList<Carta>();


	/**
	 * determina la mejor jugada de un jugador empezando por la mejor jugada y
	 * buscar la jugada inmediatmente inferior si la anterior no existe.
	 * 
	 */

	
	
	public Jugador(){

	}
	

	


	public boolean tengoUnaEscaleraRealDeColor() {

		boolean laTengo = false;
		/**
		 * vamos a ver si tenemos un escalera real de color (una escalera del 10 al as
		 * con todos los palos iguales)
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

	public void verMisCartas() {
		for (int i = 0; i < 2; i++) {
			misCartas.get(i).voltear();
		}
	}

	public String getNombre() {
		return nombre;
	}

	
	public int getDinero() {
		return dinero;
	}


	public void setDinero(int dinero) {
		this.dinero = dinero;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<Carta> getMisCartas() {
		return misCartas;
	}

	/**
	 * @brief Comprueba cuantas repeticiones de cartas hay en la mano del jugador.
	 *        6=Poker, 4=Full, 3=trio, 2=Dobles Parejas, 1=Pareja, 0=Carta Alta
	 * @return int Contador de repeticiones.
	 * @author Carlos Jesus FErnandez Basso
	 */

	protected int repeticiones() {
		int cont = 0;

		for (int s = 0; s < misCartas.size(); s++) {
			for (int j = 0; j < misCartas.size(); j++) {

				if (s != j) {

					if (misCartas.get(s).getValorNumerico() == misCartas.get(j).getValorNumerico()) {
						cont++;
					}
				}
			}
		}

		return (cont / 2);
	};

	protected void ordenar() {
		// Ordenación de las cartas
		Carta c;
		for (int i = 0; i < (misCartas.size() - 1); i++) {
			for (int j = i + 1; j < misCartas.size(); j++) {
				if (misCartas.get(i).getValorNumerico() > misCartas.get(j).getValorNumerico()) {
					c = new Carta(misCartas.remove(i));
					misCartas.add(i, misCartas.remove(j - 1));
					misCartas.add(j, c);
				}
			}
		}

	};

	protected boolean color() {
		boolean color = true;
		for (int i = 0; i < (misCartas.size() - 1); i++) {
			if (!(misCartas.get(i).getPalo().equals(misCartas.get(i + 1).getPalo()))) {
				color = false;
			}
		}
		return color;
	};

	protected boolean escalera() {

		this.ordenar();
		// Comprobamos si hay escalera.
		boolean salida = true;
		for (int i = 1; i < misCartas.size(); i++) {
			if (misCartas.get(i).getValorNumerico() != (misCartas.get(i - 1).getValorNumerico() + 1)) {
				salida = false;
			}
		}
		return salida;
	};

	protected boolean escaleracolor() {

		return ((this.escalera()) && (this.color()));
	};

	protected boolean poker(int r) {

		return (r == 6);
	};

	protected boolean full(int r) {
		return (r == 4);
	};

	protected boolean trio(int r) {
		return (r == 3);
	}

	protected boolean doblepareja(int r) {
		return (r == 2);
	};

	protected boolean pareja(int r) {
		return (r == 1);
	};
	

	public ArrayList<Carta> getMiJugada() {
		return miJugada;}

	protected String mano() {
		String salida = "";
		// Contamos las repeticiones en la lista de cartas.
		int aux = this.repeticiones();

		// Escalera de Color
		if (this.escaleracolor()) {
			salida = "Escalera de Color";
		} // Poker
		else if (this.poker(aux)) {
			salida = "Poker";
		} // FullHouse
		else if (this.full(aux)) {
			salida = "Full";
		} // Color
		else if (this.color()) {
			salida = "Color";
		} // Escalera
		else if (this.escalera()) {
			salida = "Escalera";
		} // Trío
		else if (this.trio(aux)) {
			salida = "Trío";
		} // Dobles parejas
		else if (this.doblepareja(aux)) {
			salida = "Dobles Parejas";
		} // Pareja
		else if (this.pareja(aux)) {
			salida = "Pareja";
		} // Carta Alta
		else {
			salida = "Carta Alta";
		}

		return salida;
	};

	
}