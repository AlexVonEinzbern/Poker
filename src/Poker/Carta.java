package Poker;

import javax.swing.JButton;

public class Carta extends JButton {
	
	private int valorNumerico;
	private  String simbolo;
	private char palo;
	private char color;
	
	public Carta(int valorNumerico,String simbolo,char palo,char color) {
		this.valorNumerico=valorNumerico;
		this.simbolo=simbolo;
		this.palo=palo;
		this.color=color;
	}
}
