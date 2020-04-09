package Lesson_1;

public class Main {
    public static void main(String[] args) {
    // Задание №2
        byte a = 5;
        short b = 10;
        int c = 45;
        long d = 745L;

        float e = 1.5f;
        double f = 1.789;

        boolean h = true;

        char g = 'a';

        String s = "Hello!";

        System.out.println(res3(4, 5, 6, 7));
        System.out.println(res4(11, 4));
        res5(-10);
        System.out.println(res6(b));
        res7("Anton");
        res8(300);
    }

    //Задание №3
    static int res3(int a, int b, int c, int d) {
        return (a * (b + (c / d)));
    }

    //Задание №4
    static boolean res4(int a, int b) {
        int c = a + b;
        if (c > 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //Задание №5
    static void res5(int a) {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положитеоьное");
        }
    }

    //Задание №6
    static boolean res6(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    //Задание №7
    static void res7(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //Задание №8
    static void res8(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год невисокосный");
        }
    }

}
