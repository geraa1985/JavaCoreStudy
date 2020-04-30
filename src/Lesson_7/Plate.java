package Lesson_7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        food -= n;
    }

    public void addFood(int n) {
        food += n;
        System.out.println("\nВы досыпали " + n + " еды.");
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
