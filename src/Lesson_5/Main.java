package Lesson_5;

public class Main {
    public static void main(String[] args) {
        Staff[] person = new Staff[5];
        person[0] = new Staff("Иванов Иван Иванович", "директор", "iii@mail.ru", "123456789", 60000, 35);
        person[1] = new Staff("Петров Петр Петрович", "замдиректора", "iii@mail.ru", "123456789", 50000, 45);
        person[2] = new Staff("Сидоров Сидр Сидорович", "главбух", "sss@mail.ru", "123456789", 50000, 45);
        person[3] = new Staff("Яколвлев Яков Яковлевич", "менеджер", "yyy@mail.ru", "123456789", 30000, 25);
        person[4] = new Staff("Путайло Евкакий Аристархович", "дворник", "pea@mail.ru", "123456789", 12000, 65);

        for (Staff pers : person) {
            if (pers.getAge() > 40) {
                pers.info();
            }
        }
    }
}
