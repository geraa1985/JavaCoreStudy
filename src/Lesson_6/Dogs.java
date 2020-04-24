package Lesson_6;

public class Dogs extends Animals{

    private static int countDogs = 0;
    private String name = "Пёс";

    private int limitRun = 500;
    private int limitSwim = 10;
    private float limitJump = 0.5f;

    public Dogs() {
        super();
        countDogs++;
    }

    public Dogs(String name, int limitRun, int limitSwim, float limitJump) {
        super();
        countDogs++;
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
    }

    public static int getCountDogs() {
        return countDogs;
    }

    protected void run(int x) {
        if (x <= limitRun) {
            System.out.println(name + " пробежал " + x + " метров");
        } else {
            System.out.println("run:false");
        }
    }

    protected void swim(int x) {
        if (x <= limitSwim) {
            System.out.println(name + " проплыл " + x + " метров");
        } else {
            System.out.println("swim:false");
        }
    }

    protected void jump(float x) {
        if (x <= limitJump) {
            System.out.println(name + " прыгнул на " + x + " метров");
        } else {
            System.out.println("jump:false");
        }
    }
}
