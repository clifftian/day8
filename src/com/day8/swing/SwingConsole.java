package com.day8.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingConsole {
	
	public static void run (final JFrame f, final int width, final int height){
		SwingUtilities.invokeLater(new Runnable(){
			public void run (){
				f.setTitle(f.getClass().getSimpleName());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(width, height);
				f.setVisible(true);
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
