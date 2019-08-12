package Poker;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class PrincipalPoker {
	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Poker myWindow = new Poker();
			}
		});
	}
}
