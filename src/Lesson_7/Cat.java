package Lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    private int countEat;

    {
        countEat = 0;
        satiety = false;
    }

    public Cat(String name, int apptite) {
        this.name = name;
        this.appetite = apptite;
    }

    public void eat(Plate plate) {
        if ((plate.getFood() - appetite) >= 0) {
            plate.decreaseFood(appetite);
            satiety = true;
            countEat++;
        }
    }

    public int getAppetite() {
        return appetite;
    }

    public void info(){
        if (satiety){
            System.out.println(name + " неголодный, с его аппетитом (" + appetite + "), он уже покушал " + countEat +
                    " раз(а)!!!");
        } else {
            System.out.println(name + ", с его аппетитом (" + appetite + "), остался голодным...");
        }
    }
}
