package philosoph;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

        private static final int NUMBER_OF_PHILOSOPHERS = 5;
        private static final int NUMBER_OF_EATING_TIMES = 3;
        private static Semaphore[] forks;
        private static Semaphore meals;

        public static void main(String[] args) {
            forks = new Semaphore[NUMBER_OF_PHILOSOPHERS];
            meals = new Semaphore(NUMBER_OF_PHILOSOPHERS - 1);

            for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
                forks[i] = new Semaphore(1);
            }

            Thread[] philosophers = new Thread[NUMBER_OF_PHILOSOPHERS];

            for (int i = 1; i <= NUMBER_OF_PHILOSOPHERS; i++) {
                final int philosopherIndex = i;
                final int leftForkIndex = philosopherIndex - 1;
                final int rightForkIndex = (philosopherIndex % NUMBER_OF_PHILOSOPHERS);

                philosophers[i - 1] = new Thread(() -> {
                    try {
                        for (int j = 0; j < NUMBER_OF_EATING_TIMES; j++) {
                            think(philosopherIndex);
                            eat(philosopherIndex, leftForkIndex, rightForkIndex);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                });

                philosophers[i - 1].start();
            }

            try {
                for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
                    philosophers[i].join();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private static void think(int philosopherIndex) throws InterruptedException {
            System.out.println("Философ " + philosopherIndex + " размышляет...");
            Thread.sleep((long) (Math.random() * 1000));
        }

        private static void eat(int philosopherIndex, int leftForkIndex, int rightForkIndex) throws InterruptedException {
            meals.acquire(); // Ограничение на количество доступных еды

            forks[leftForkIndex].acquire(); // Берем левую вилку
            forks[rightForkIndex].acquire(); // Берем правую вилку

            System.out.println("Философ " + philosopherIndex + " ест...");

            Thread.sleep((long) (Math.random() * 1000));

            forks[leftForkIndex].release(); // Освобождаем левую вилку
            forks[rightForkIndex].release(); // Освобождаем правую вилку

            meals.release(); // Увеличиваем количество доступной еды
        }
    }


