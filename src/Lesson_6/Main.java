package Lesson_6;

public class Main {
    public static void main(String[] args) {
        Cats cat1 = new Cats();
        Dogs dog1 = new Dogs("Барсик",50, 10, 0.8f);
        Dogs dog2 = new Dogs("Бобик",1000, 10, 2);

        cat1.run( 50);
        dog1.run(100);
        dog2.run(700);
        dog1.jump(0.5f);


        System.out.println("\nВсего животных: " + Animals.getCountAnimals());
        System.out.println("Всего котов: " + Cats.getCountCats());
        System.out.println("Всего собак: " + Dogs.getCountDogs());
    }
}
