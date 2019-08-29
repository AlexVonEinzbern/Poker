package Poker;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Hace referencia a una carta del juego Poker.
 * @author
 *
 */
public class Carta extends JLabel {

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
	public Carta(int valorNumerico, String simbolo, String palo, String color) {
		this.valorNumerico = valorNumerico;
		this.simbolo = simbolo;
		this.palo = palo;
		this.color = color;
		this.colocarColorAleatorio();

	}

	Carta() {

	};

	Carta(Carta cual) {
		valorNumerico = cual.getValorNumerico();
		palo = cual.getPalo();

	};

	    
	    
	public void colocarColorAleatorio() {
		Random aleatorio =new Random();
		setIcon(imagenesDecartasAlrevez[aleatorio.nextInt(2)]);
	}
	
	public void voltear() {
		setIcon(new ImageIcon("src/cards/"+valorNumerico+simbolo+palo+color+".png"));
	}

	public int getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(int valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ImageIcon[] getImagenesDecartasAlrevez() {
		return imagenesDecartasAlrevez;
	}

	public void setImagenesDecartasAlrevez(ImageIcon[] imagenesDecartasAlrevez) {
		this.imagenesDecartasAlrevez = imagenesDecartasAlrevez;
	}
	
	
	
}

















