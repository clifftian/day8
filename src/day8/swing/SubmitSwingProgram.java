package day8.swing;

import javax.swing.*;

import java.util.concurrent.*;

public class SubmitSwingProgram extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JLabel label;

	public SubmitSwingProgram() throws InterruptedException {
		super("Hello Swing");
		label = new JLabel("A Label");
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}

	static SubmitSwingProgram ssp;

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					ssp = new SubmitSwingProgram();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ssp.label.setText("Hey! This is from SubmitSwingProgram!");
			}
		});
	}
}