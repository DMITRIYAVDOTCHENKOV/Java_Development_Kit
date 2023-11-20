package lesson6_maven.hw_maven;

import java.util.Arrays;

//В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
//        Необходимо:
//        Создать свой Java Maven или Gradle проект;
//        Самостоятельно реализовать прикладную задачу;
//        Сохранить результат в HashMap<шаг теста, результат>
//        Вывести на экран статистику по победам и поражениям
public class Main {
    public static void main(String[] args) {
        MontyHallParadox montyHallParadox = new MontyHallParadox();
        montyHallParadox.main(Arrays.toString(args));

    }
}
