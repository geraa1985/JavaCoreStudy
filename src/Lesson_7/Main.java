package Lesson_7;

import java.util.Random;

public class Main {
	public static Random random = new Random();

	public static void main(String[] args) {
		int rangeAppetite;
		String[] arrCatName;
		int countCats;
		Cat[] cats;
		int food;
		int minFood;


		arrCatName = new String[]{"Грея", "Дымка", "Зола", "Мальвина", "Мате", "Мисти", "Муни", "Мышка", "Нева", "Рея"
				, "Руни", "Смоки", "Соя", "Тень", "Фрея", "Хайди", "Хидан", "Шаде", "Шейди", "Шейла", "Эшли",
				"Альберт", "Ашер", "Вельвет", "Вульф", "Грей", "Дориан", "Дымок", "Клауд", "Мускус", "Пепел", "Поль",
				"Пьеро", "Смоки", "Сумрак", "Тень", "Том", "Хром", "Чарли", "Шарки", "Шайн", "Юнг"};
		rangeAppetite = 20;
		countCats = 7;
		cats = new Cat[countCats];
		food = 50;
		minFood = food;

		for (int i = 0; i < countCats; i++) {
			int appetite = (int) (Math.random() * rangeAppetite);
			String name = arrCatName[random.nextInt(arrCatName.length)];
			cats[i] = new Cat(name, appetite);
		}

		Plate plate = new Plate(food);

		for (int i = 0; i < countCats; i++) {
			if (cats[i].getAppetite() < minFood) {
				minFood = cats[i].getAppetite();
			}
		}

		while (plate.getFood() > minFood) {
			for (int i = 0; i < countCats; i++) {
				cats[i].eat(plate);
			}
		}

		for (int i = 0; i < countCats; i++) {
			cats[i].info();
		}

		plate.addFood(food);
		plate.info();

	}
}
