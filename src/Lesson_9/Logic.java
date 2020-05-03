package Lesson_9;

import java.util.Random;

public class Logic {
	private int gameMode;
	private int sizeX;
	private int sizeY;
	private int dotsToWin;
	private String finishText;

	private Window window;

	private final char DOT_X = 'X';
	private final char DOT_O = 'O';
	private final char DOT_EMPTY = '.';

	private char[][] map;


	static Random random = new Random();
	private boolean gameFinished;

	private int player = 1;

	Finish finish;

	public Logic(Window window) {
		this.window = window;
	}

	public void go() {
		gameFinished = true;
//		printMap();
		if (checkWinLines(DOT_X)) {
			finishText = "Выиграли крестики!";
			finish = new Finish(window, this);
			return;
		}

		if (isFull()) {
			finishText = "Ничья...";
			finish = new Finish(window, this);
			return;
		}

		if (gameMode == 0) {
			aiTurn();
		} else if (gameMode == 1) {
			if (player == 1) {
				player = 2;
			} else {
				player = 1;
			}
		}

//		printMap();
		if (checkWinLines(DOT_O)) {
			finishText = "Выиграли нолики!";
			finish = new Finish(window, this);
			return;
		}
		if (isFull()) {
			finishText = "Ничья...";
			finish = new Finish(window, this);
			return;
		}
		gameFinished = false;
	}

	public void initMap() {
		map = new char[sizeY][sizeX];
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				map[i][j] = DOT_EMPTY;
			}
		}
	}

//	public void printMap() {
//		System.out.print("  ");
//		for (int i = 1; i <= sizeX; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//
//		for (int i = 0; i < sizeY; i++) {
//			System.out.print(i + 1 + " ");
//			for (int j = 0; j < sizeX; j++) {
//				System.out.printf("%s ", map[i][j]);
//			}
//			System.out.println();
//		}
//	}


	public void setHumanXY(int x, int y) {
		if (isCellValid(y, x) && (player == 1)) {
			map[y][x] = DOT_X;
			go();
		} else if (isCellValid(y, x) && (player == 2)) {
			map[y][x] = DOT_O;
			go();
		}
	}

	public boolean isCellValid(int y, int x) {
		if (x < 0 || y < 0 || x >= sizeX || y >= sizeY) {
			return false;
		}
		return map[y][x] == DOT_EMPTY;
	}

	public void aiTurn() {
		int x;
		int y;

		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				if (isCellValid(i, j)) {
					map[i][j] = DOT_O;
					if (checkWinLines(DOT_O)) {
						return;
					}
					map[i][j] = DOT_EMPTY;
				}
			}
		}

		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				if (isCellValid(i, j)) {
					map[i][j] = DOT_X;
					if (checkWinLines(DOT_X)) {
						map[i][j] = DOT_O;
						return;
					}
					map[i][j] = DOT_EMPTY;
				}
			}
		}

		do {
			y = random.nextInt(sizeY);
			x = random.nextInt(sizeX);
		} while (!isCellValid(y, x));
		map[y][x] = DOT_O;
	}

	public boolean isFull() {
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				if (map[i][j] == DOT_EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
		if (cx + vx * dotsToWin - 1 > sizeY - 1 || cy + vy * dotsToWin - 1 > sizeX - 1 || cy + vy * (dotsToWin - 1) < 0) {
			return false;
		}

		for (int i = 0; i < dotsToWin; i++) {
			if (map[cy + i * vy][cx + i * vx] != dot) {
				return false;
			}
		}
		return true;
	}

	public boolean checkWinLines(char dot) {
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) || checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
					return true;
				}
			}
		}
		return false;
	}

	public void setSettings(int gameMode, int sizeX, int sizeY, int dotsToWin) {
//		System.out.println("in logic: " + " " + gameMode + " " + sizeX + " " + sizeY + " " + dotsToWin);
		this.gameMode = gameMode;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.dotsToWin = dotsToWin;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public char getDOT_X() {
		return DOT_X;
	}

	public char getDOT_O() {
		return DOT_O;
	}

	public char[][] getMap() {
		return map;
	}

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}

	public String getFinishText() {
		return finishText;
	}
}
