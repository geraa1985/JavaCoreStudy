package Lesson_6;

public class Cats extends Animals {

    private static int countCats = 0;
    private String name = "Кот";
    private int limitRun = 200;
    private float limitJump = 2.0f;

    public Cats() {
        super();
        countCats++;
    }

    public static int getCountCats() {
        return countCats;
    }

    public Cats(String name, int limitRun, float limitJump) {
        super();
        countCats++;
        this.name = name;
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }

    protected void run(int x) {
        if (x <= limitRun) {
            System.out.println(name + " пробежал " + x + " метров");
        } else {
            System.out.println("run:false");
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
