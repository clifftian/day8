package day8.swing;

import javax.swing.*;
import java.awt.*;
import static day8.swing.SwingConsole.*;

public class Button1 extends JFrame {
	private JButton b1 = new JButton("Button 1"), b2 = new JButton("Button 2");

	public Button1() {
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}

	public static void main(String[] args) {
		run(new Button1(), 600, 800);
	}
}