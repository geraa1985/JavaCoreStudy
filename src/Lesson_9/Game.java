package Lesson_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 3894153739406076151L;
	private int gameModeValue;
	private int fieldSizeX;
	private int fieldSizeY;
	private int winLength;

	private int cellHeight;
	private int cellWidth;

	private boolean isInit = false;

	private Window window;

	public Game(Window window) {
		this.window = window;
		setBackground(Color.cyan);


		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				update(e);
			}
		});

		setVisible(false);
	}

	private void update(MouseEvent e) {
		int cellX = e.getX() / cellWidth;
		int cellY = e.getY() / cellHeight;

		if (!window.getGetFinished()) {
			window.setPoint(cellX, cellY);
		}

//		System.out.println(cellX + " " + cellY);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		render(g);
	}

	private void render(Graphics g) {
		if (!isInit) {
			return;
		}
		int panelWidth = getWidth();
		int panelHeight = getHeight();

		cellHeight = panelHeight / fieldSizeY;
		cellWidth = panelWidth / fieldSizeX;

		for (int i = 1; i < fieldSizeY; i++) {
			int y = i * cellHeight;
			g.drawLine(0, y, panelWidth, y);
		}

		for (int i = 1; i < fieldSizeX; i++) {
			int x = i * cellWidth;
			g.drawLine(x, 0, x, panelHeight);
		}

		for (int i = 0; i < fieldSizeY; i++) {
			for (int j = 0; j < fieldSizeX; j++) {
				if (window.getMap()[i][j] == window.getDOT_O()) {
					drawO(g, j, i);
				}
				if (window.getMap()[i][j] == window.getDOT_X()) {
					drawX(g, j, i);
				}
			}
		}
	}

	private void drawO(Graphics g, int cellX, int cellY) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(10.0f));
		g2.setColor(new Color(0, 0, 255));
		g2.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
	}

	private void drawX(Graphics g, int cellX, int cellY) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(10.0f));
		g2.drawLine(cellX * cellWidth, cellY * cellHeight, (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
		g2.drawLine((cellX + 1) * cellWidth, cellY * cellHeight, cellX * cellWidth, (cellY + 1) * cellHeight);
	}

	void setSettings(int gameModeValue, int fieldSizeX, int fieldSizeY, int winLength) {
		this.gameModeValue = gameModeValue;
		this.fieldSizeX = fieldSizeX;
		this.fieldSizeY = fieldSizeY;
		this.winLength = winLength;
		isInit = true;
	}
}
