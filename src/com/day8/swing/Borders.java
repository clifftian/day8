package com.day8.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import static com.day8.swing.SwingConsole.*;

public class Borders extends JFrame{

	static JPanel ShowBorder (Border b){
		JPanel jp = new JPanel ();
		jp.setLayout(new BorderLayout());
		String nm = b.getClass().toString();
		nm = nm.substring(nm.lastIndexOf('.') + 1);
		jp.add(new JLabel (nm, JLabel.CENTER), BorderLayout.CENTER);
		jp.setBorder(b);
		return jp;
	}

	public Borders() {
		setLayout(new GridLayout(2,40));
		add(ShowBorder(new TitledBorder("tile Tile")));
		add(ShowBorder(new EtchedBorder()));
		add(ShowBorder(new LineBorder(Color.BLUE)));
		add(ShowBorder(new MatteBorder(5,5,30,30,Color.BLUE)));
		add(ShowBorder(new BevelBorder(javax.swing.border.BevelBorder.RAISED)));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run(new Borders(),500,500);
		
	}

}
