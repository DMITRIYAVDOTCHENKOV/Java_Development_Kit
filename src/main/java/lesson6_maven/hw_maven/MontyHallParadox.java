package lesson6_maven.hw_maven;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.HashMap;
import java.util.Map;

public class MontyHallParadox {
    public static void main(String args) {
        int totalTests = 1000;
        Map<Integer, String> results = new HashMap<>();

        int winsBySticking = 0;
        int winsBySwitching = 0;

        RandomDataGenerator random = new RandomDataGenerator();

        for (int i = 1; i <= totalTests; i++) {
            int carDoor = random.nextInt(1, 3);
            int chosenDoor = random.nextInt(1, 3);

            int revealedDoor;
            do {
                revealedDoor = random.nextInt(1, 3);
            } while (revealedDoor == carDoor || revealedDoor == chosenDoor);

            int switchedDoor;
            do {
                switchedDoor = random.nextInt(1, 3);
            } while (switchedDoor == chosenDoor || switchedDoor == revealedDoor);

            if (chosenDoor == carDoor) {
                winsBySticking++;
                results.put(i, "Победа, если подтвердил первый выбор");
            } else if (switchedDoor == carDoor) {
                winsBySwitching++;
                results.put(i, "Победа, если отказался от первого варианта");
            } else {
                results.put(i, "Lost");
            }
        }

        System.out.println("Победа, если подтвердил первый выбор: " + winsBySticking);
        System.out.println("Победа, если отказался от первого варианта : " + winsBySwitching);
        System.out.println("Поражения: " + (totalTests - winsBySticking - winsBySwitching));

        System.out.println("Победы, если подтверждено первоначальное решение: " + ((double) winsBySticking / totalTests) * 100 + "%");
        System.out.println("Победы, если было изменено первоначальное решение: " + ((double) winsBySwitching / totalTests) * 100 + "%");
        System.out.println("Поражения: " + ((double) (totalTests - winsBySticking - winsBySwitching) / totalTests) * 100 + "%");

//        System.out.println("\nРезультаты игры:");
//        for (Map.Entry<Integer, String> entry : results.entrySet()) {
//            System.out.println("Step " + entry.getKey() + ": " + entry.getValue());
//        }
    }
}
