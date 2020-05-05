package Lesson_9;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	private static final int WIN_X = 500;
	private static final int WIN_Y = 100;
	private static final int WIN_WIDTH = 500;
	private static final int WIN_HEIGHT = 500;


	private Settings panelSet;
	private Game panelGame;
	private Logic logic = new Logic(this);


	public Window() {
		setBounds(WIN_X, WIN_Y, WIN_WIDTH, WIN_HEIGHT);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Крестики-нолики");
		setResizable(false);


		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
		JButton buttonSet = new JButton("Настройки");
		buttonSet.setBackground(Color.yellow);
		JButton buttonStart = new JButton("Старт");
		buttonStart.setBackground(Color.green);
		JButton buttonExit = new JButton("Выход");
		buttonExit.setBackground(Color.red);
		buttonPanel.add(buttonSet);
		buttonPanel.add(buttonStart);
		buttonPanel.add(buttonExit);
		add(buttonPanel, BorderLayout.SOUTH);

		panelSet = new Settings(this);

		panelGame = new Game(this);

		buttonSet.addActionListener(e -> {
			remove(panelGame);
			add(panelSet, BorderLayout.CENTER);
			panelSet.setVisible(true);
			panelSet.repaint();
		});

		buttonStart.addActionListener(e -> {
			remove(panelSet);
			getSettings(panelSet.gameModeValue(), panelSet.fieldSizeX(), panelSet.fieldSizeY(), panelSet.winLength());
			add(panelGame, BorderLayout.CENTER);
			panelGame.setVisible(true);
			panelGame.repaint();
			logic.setGameFinished(false);
		});

		buttonExit.addActionListener(e -> System.exit(0));


		setVisible(true);
	}

	void getSettings(int gameModeValue, int fieldSizeX, int fieldSizeY, int winLength){
		panelGame.setSettings(gameModeValue, fieldSizeX, fieldSizeY, winLength);
		logic.setSettings(gameModeValue, fieldSizeX, fieldSizeY, winLength);
		logic.initMap();
//		logic.printMap();
	}

	void setPoint(int x, int y) {
		logic.setHumanXY(x, y);
	}

	boolean getGetFinished() {
		return logic.isGameFinished();
	}

	char getDOT_X() {
		return logic.getDOT_X();
	}

	char getDOT_O() {
		return logic.getDOT_O();
	}

	char[][] getMap() {
		return logic.getMap();
	}

	public Game getPanelGame() {
		return panelGame;
	}
}
