package Lesson_6;

public class Animals {

    private static int countAnimals = 0;

    public Animals() {
        countAnimals++;
    }

    protected void run(int x) {
        System.out.println("Животное пробежало " + x + " метров");
    }

    protected void swim(int x) {
        System.out.println("Животное проплыло " + x + " метров");
    }

    protected void jump(int x) {
        System.out.println("Животное прыгнуло на " + x + " метров");
    }

    public static int getCountAnimals() {
        return countAnimals;
    }
}
