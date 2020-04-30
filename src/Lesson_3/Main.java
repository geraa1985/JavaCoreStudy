package Lesson_3;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();

	public static void main(String[] args) {

		game();
		repeat();

		game2();
		repeat2();
	}

	static void game() {
		int z = random.nextInt(10);
		System.out.println("Сыграем в игру УГАДАЙ ЧИСЛО. Я загадал число от 1 до 10. У тебя есть 3 попытки.");
		int n = 3;
		for (int i = 1; i <= n; i++) {
			int x = scan.nextInt();
			if (x == z) {
				System.out.println("\nВы угадали!");
				break;
			} else {
				if (x > z) {
					System.out.printf("Слишком большое.\nКоличество оставшихся попыток: %d \n", n - i);
				}
				if (x < z) {
					System.out.printf("Слишком маленькое.\nКоличество оставшихся попыток: %d \n", n - i);
				}
				if (i == n) {
					System.out.println("\nВы проиграли!");
				}
			}
		}
	}

	static void repeat() {
		while (true) {
			System.out.println("Сыграем еще раз? 1 - да, 0 - нет");
			String x = scan.next();
			if (x.equals("1")) {
				game();
			} else if (x.equals("0")) {
				System.out.println("До новых встреч!");
				break;
			}
		}
	}

	static void game2() {
		String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
		int x = random.nextInt(words.length);
		String question = words[x];
		System.out.println(question);
		System.out.println("Угадайте слово, которое я загадал: ");
		StringBuilder builder = new StringBuilder("###############");
		boolean b = true;
		do {
			String answer = scan.next();
			if (answer.equals(question)) {
				System.out.println("Вы угадали!!! Ответ: " + question);
				b = false;
			} else {
				for (int i = 0; i < Math.min(question.length(), answer.length()); i++) {
					if (question.charAt(i) == answer.charAt(i)) {
						builder.setCharAt(i, question.charAt(i));
					}
				}
				System.out.println("Попробуйте ещё раз! Подсказка: " + builder);
			}
		} while (b);
	}

	static void repeat2() {
		while (true) {
			System.out.println("Сыграем еще раз? 1 - да, 0 - нет");
			String x = scan.next();
			if (x.equals("1")) {
				game2();
			} else if (x.equals("0")) {
				System.out.println("До новых встреч!");
				break;
			}
		}
	}
}