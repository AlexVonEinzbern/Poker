package Poker;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Hace referencia a una carta del juego Poker.
 * @author
 *
 */
public class Carta extends JButton {

	/**
	 * Valor numérico de la carta.
	 */
	private int valorNumerico;
	
	/**
	 * Símbolo de la carta.
	 */
	private String simbolo;
	
	/**
	 * Palo de la carta.
	 */
	private String palo;
	
	/**
	 * Color de la carta.
	 */
	private String color;
	
	/**
	 * Parte de atrás de las cartas, rojo y azul.
	 */
	private ImageIcon[] imagenesDecartasAlrevez= {
			new ImageIcon("src/cards/rojo.png"),
			new ImageIcon("src/cards/azul.png")};
 
	/**
	 * Constructor de la clase Carta.
	 * @param valorNumerico
	 * @param simbolo
	 * @param palo
	 * @param color
	 */
	public Carta(int valorNumerico,String simbolo,String palo,String color) {
		this.valorNumerico=valorNumerico;
		this.simbolo=simbolo;
		this.palo=palo;
		this.color=color;
		this.colocarColorAleatorio();
	
	}
	
	/**
	 * 
	 */
	public void colocarColorAleatorio() {
		Random aleatorio =new Random();
		setIcon(imagenesDecartasAlrevez[aleatorio.nextInt(2)]);
	}
	
	/**
	 * 
	 */
	public void voltear() {
		setIcon(new ImageIcon("src/cards/"+valorNumerico+simbolo+palo+color+".png"));
	}
}