package Lesson_9;

import javax.swing.*;
import java.awt.*;

public class Finish extends JFrame {

	public Finish(Window window, Logic logic) {
		setBounds(window.getBounds());
		JLabel label = new JLabel(logic.getFinishText(), SwingConstants.CENTER);
		label.setFont(new Font("Monospaced", Font.BOLD, 40));
		add(label);
		JButton buttonOk = new JButton("Ok");
		add(buttonOk, BorderLayout.SOUTH);
		buttonOk.addActionListener(e -> {
			setVisible(false);
			window.getPanelGame().setVisible(false);
		});

		setVisible(true);
	}
}
