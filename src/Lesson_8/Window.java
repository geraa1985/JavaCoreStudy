package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class Window extends JFrame {

	static JTextArea display = new JTextArea();
	static int firstValue;
	static String operation;

	public Window() throws HeadlessException {
		setTitle("Calculator");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(500, 100, 300, 300);


		JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
		JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton buttonSum = new JButton("+");
		JButton buttonSub = new JButton("-");
		JButton buttonMul = new JButton("*");
		JButton buttonDivide = new JButton("/");
		JButton buttonReset = new JButton("C");
		buttonReset.setBackground(Color.red);
		JButton buttonStart = new JButton("=");
		buttonStart.setBackground(Color.green);

		add(display, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);

		buttonPanel.add(button7);
		buttonPanel.add(button8);
		buttonPanel.add(button9);
		buttonPanel.add(buttonSum);

		buttonPanel.add(button4);
		buttonPanel.add(button5);
		buttonPanel.add(button6);
		buttonPanel.add(buttonSub);

		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(buttonMul);

		buttonPanel.add(buttonReset);
		buttonPanel.add(button0);
		buttonPanel.add(buttonStart);
		buttonPanel.add(buttonDivide);

		pressButton(button0);
		pressButton(button1);
		pressButton(button2);
		pressButton(button3);
		pressButton(button4);
		pressButton(button5);
		pressButton(button6);
		pressButton(button7);
		pressButton(button8);
		pressButton(button9);

		buttonReset.addActionListener(e -> {
			display.setText("");
			firstValue = 0;
			operation = "";
		});

		pressOperator(buttonSum);
		pressOperator(buttonSub);
		pressOperator(buttonMul);
		pressOperator(buttonDivide);

		buttonStart.addActionListener(e -> {
			int secondValue = parseInt(display.getText());
			if (operation.equals("+")) {
				display.setText((firstValue + secondValue) + "");
			}
			if (operation.equals("-")) {
				display.setText((firstValue - secondValue) + "");
			}
			if (operation.equals("*")) {
				display.setText((firstValue * secondValue) + "");
			}
			if (operation.equals("/")) {
				display.setText((firstValue / secondValue) + "");
			}
			firstValue = 0;
			operation = "";
		});

		setVisible(true);
	}

	static void pressButton(JButton button) {
		button.addActionListener(e -> display.setText(display.getText() + button.getText()));
	}

	static void pressOperator(JButton button) {
		button.addActionListener(e-> {
				firstValue = parseInt(display.getText());
				display.setText("");
				operation = button.getText();
		});
	}
}
