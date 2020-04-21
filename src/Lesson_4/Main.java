package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final String DOT_EMPTY = "•";
    public static final String DOT_X = "X";
    public static final String DOT_O = "O";
    public static String[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        game();
        repeat();
    }

    static void initMap() {
        map = new String[SIZE + 1][SIZE + 1];
        for (int j = 0; j <= SIZE; j++) {
            map[0][j] = Integer.toString(j);
        }
        for (int i = 1; i <= SIZE; i++) {
            map[i][0] = Integer.toString(i);
            for (int j = 1; j <= SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            for (int j = 0; j <= SIZE; j++) {
                System.out.printf("%3s", map[i][j]);
            }
            System.out.println();
        }
    }

    static void turnPlayer() {
        int x, y;
        do {
            System.out.println("Ваш ход в формате (х у)");
            x = sc.nextInt();
            y = sc.nextInt();
        } while (!checkTurn(x, y));
        map[y][x] = DOT_X;
    }

    static void turnAI() {
        int x, y;

        System.out.println("\nХод компьютера:");

        do {
            x = rand.nextInt(SIZE + 1);
            y = rand.nextInt(SIZE + 1);
        } while (!checkTurn(x, y));

        int h = 0;
        int v = 0;
        int d = 0;
        int u = 0;
        int z;

        if (DOTS_TO_WIN > 3) {
            z = DOTS_TO_WIN - 2;
        } else z = 2;

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= (SIZE - z + 1); j++) {
                for (int k = j; k <= (j + z - 1); k++) {
                    if (map[i][j].equals(map[i][k]) && map[i][j].equals(DOT_X)) {
                        h += 1;
                    } else h = 0;
                }
                if ((h >= z) && (checkTurn(j - 1, i))) {
                    y = i;
                    x = j - 1;
                }
                if ((h >= z) && (checkTurn(j + z, i))) {
                    y = i;
                    x = j + z;
                }
            }
        }


        for (int i = 1; i <= (SIZE - z + 1); i++) {
            for (int j = 1; j <= SIZE; j++) {
                for (int k = i; k <= (i + z - 1); k++) {
                    if (map[i][j].equals(map[k][j]) && map[i][j].equals(DOT_X)) {
                        v += 1;
                    } else v = 0;
                }
                if ((v >= z) && ((checkTurn(j, i - 1)))) {
                    y = i - 1;
                    x = j;
                }
                if ((v >= z) && ((checkTurn(j, i + z)))) {
                    y = i + z;
                    x = j;
                }
            }
        }

        for (int i = 1; i <= (SIZE - z + 1); i++) {
            for (int j = 1; j <= (SIZE - z + 1); j++) {
                for (int k = i, l = j; k <= (i + z - 1); k++, l++) {
                    if (map[i][j].equals(map[k][l]) && map[i][j].equals(DOT_X)) {
                        d += 1;
                    } else d = 0;
                }
                if ((d >= z) && (checkTurn(j - 1, i - 1))) {
                    y = i - 1;
                    x = j - 1;
                }
                if ((d >= z) && (checkTurn(j + z, i + z))) {
                    y = i + z;
                    x = j + z;
                }
            }
        }

        for (int i = SIZE; i >= z; i--) {
            for (int j = 1; j <= (SIZE - z + 1); j++) {
                for (int k = i, l = j; k >= (i - z + 1); k--, l++) {
                    if (map[i][j].equals(map[k][l]) && map[i][j].equals(DOT_X)) {
                        u += 1;
                    } else u = 0;
                }
                if ((u >= z) && (checkTurn(j + z, i - z))) {
                    y = i - z;
                    x = j + z;
                }
                if ((u >= z) && (checkTurn(j - 1, i + 1))) {
                    y = i + 1;
                    x = j - 1;
                }
            }
        }

        map[y][x] = DOT_O;
    }

    static boolean checkTurn(int x, int y) {
        if (x < 0 || x > SIZE || y < 0 || y > SIZE) return false;
        return map[y][x].equals(DOT_EMPTY);
    }

    static boolean mapFull() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                if (map[i][j].equals(DOT_EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(int x, String dot) {
        int h = 0;
        int v = 0;
        int d = 0;
        int u = 0;

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= (SIZE - x + 1); j++) {
                for (int k = j; k <= (j + x - 1); k++) {
                    if (map[i][j].equals(map[i][k]) && map[i][j].equals(dot)) {
                        h += 1;
                    }
                }
                if (h >= x) {
                    return true;
                } else {
                    h = 0;
                }
            }
        }

        for (int i = 1; i <= (SIZE - x + 1); i++) {
            for (int j = 1; j <= SIZE; j++) {
                for (int k = i; k <= (i + x - 1); k++) {
                    if (map[i][j].equals(map[k][j]) && map[i][j].equals(dot)) {
                        v += 1;
                    }
                }
                if (v >= x) {
                    return true;
                } else {
                    v = 0;
                }
            }
        }

        for (int i = 1; i <= (SIZE - x + 1); i++) {
            for (int j = 1; j <= (SIZE - x + 1); j++) {
                for (int k = i, l = j; k <= (i + x - 1); k++, j++) {
                    if (map[i][j].equals(map[k][l]) && map[i][j].equals(dot)) {
                        d += 1;
                    }
                }
                if (d >= x) {
                    return true;
                } else {
                    d = 0;
                }
            }
        }

        for (int i = SIZE; i >= x; i--) {
            for (int j = 1; j <= (SIZE - x + 1); j++) {
                for (int k = i, l = j; k >= (i - x + 1); k--, l++) {
                    if (map[i][j].equals(map[k][l]) && map[i][j].equals(dot)) {
                        u += 1;
                    }
                }
                if (u >= x) {
                    return true;
                } else {
                    u = 0;
                }
            }
        }
        return false;
    }

    static void game() {
        initMap();
        printMap();
        while (true) {
            turnPlayer();
            printMap();
            if (checkWin(DOTS_TO_WIN, DOT_X)) {
                System.out.println("ВЫ ВЫИГРАЛИ!!!");
                break;
            }
            if (mapFull()) {
                System.out.println("НИЧЬЯ!!!");
                break;
            }
            turnAI();
            printMap();
            if (checkWin(DOTS_TO_WIN, DOT_O)) {
                System.out.println("ВЫ ПРОИГРАЛИ!!!");
                break;
            }
            if (mapFull()) {
                System.out.println("НИЧЬЯ!!!");
                break;
            }
        }
    }

    static void repeat() {
        while (true) {
            System.out.println("Сыграем еще раз? 1 - да, 0 - нет");
            String x = sc.next();
            if (x.equals("1")) {
                game();
            } else if (x.equals("0")) {
                System.out.println("До новых встреч!");
                break;
            }
        }
    }
}

