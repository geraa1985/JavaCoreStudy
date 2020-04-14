package Lesson_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1: ");
        invertArr();

        System.out.println("\n\nЗадание №2: ");
        fillingArr();

        System.out.println("\n\nЗадание №3: ");
        x2Arr();

        System.out.println("\n\nЗадание №4: ");
        diagArr();

        System.out.println("\n\nЗадание №5: ");
        minMaxArr();

        System.out.println("\n\nЗадание №6: ");
        int[] arr = {2, 3, 4, 5, 6, 10, 5, 5};
        System.out.println(sumPartArr(arr));

        System.out.println("\n\nЗадание №7: ");
        revolvArr(arr, 3);

    }

    //Задание №1 (инверсия элементов массива)
    static void invertArr() {
        int[] arr = {1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.print(arr[i] + "  ");           //Проверка работоспособности
        }
    }

    //Задание №2 (заполнение массива)
    static void fillingArr() {
        int[] arr = new int[8];
        for (int i = 0, j = 0; i < 8; i++, j += 3) {
            arr[i] = j;
            System.out.print(arr[i] + "  ");           //Проверка работоспособности
        }
    }

    //Задание №3 (числа меньше 6 в массиве умнождить на 2)
    static void x2Arr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
            System.out.print(arr[i] + "  ");           //Проверка работоспособности
        }
    }

    //Задание №4 (диагональное заполнение массива)
    static void diagArr() {
        int a = 6;
        int[][] arr = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if ((i == j) || (i + j == a - 1)) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //Задание №5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
    static void minMaxArr() {
        int[] arr = {2, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.printf("Максимальное значение: %4d. \nМинимальное значение: %4d", max, min);           //Проверка работоспособности
    }

    //Задание №6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    static boolean sumPartArr(int[] arr) {
        int right = 0;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            right += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            left += arr[i];
            right -= arr[i];
            if (right == left) {
                return true;
            }
        }
        return false;
    }

    //Задание №7. Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    static void revolvArr(int[] arr, int n) {
        int b;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                b = arr[0];
                arr[0] = arr[arr.length - 1];
                for (int j = 1; j < (arr.length - 1); j++) {
                    arr[arr.length - j] = arr[arr.length - j - 1];
                }
                arr[1] = b;
            }
        }
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                b = arr[arr.length - 1];
                arr[arr.length - 1] = arr[0];
                for (int j = 1; j < (arr.length - 1); j++) {
                    arr[j - 1] = arr[j];
                }
                arr[arr.length - 2] = b;
            }
        }
        for (int g = 0; g < arr.length; g++) {              //Проверка работоспособности (вывод полученного массива)
            System.out.print(arr[g] + "  ");
        }
    }
}

