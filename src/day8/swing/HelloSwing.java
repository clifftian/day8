package day8.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class HelloSwing {
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Hello Swing");
		JLabel label = new JLabel("A Label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setVisible(true);
		TimeUnit.SECONDS.sleep(1);
		label.setText("Hey! This is Different!");
	}
}