package Poker;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Carta extends JButton {

	private int valorNumerico;
	private String simbolo;
	private String palo;
	private String color;
	
	
	public Carta(int valorNumerico,String simbolo,String palo,String color) {
		this.valorNumerico=valorNumerico;
		this.simbolo=simbolo;
		this.palo=palo;
		this.color=color;
		this.setIcon(new ImageIcon("src/cards/"+valorNumerico+simbolo+palo+color+".png"));
	}
}
