package calculator;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "hello");
        System.out.println("Первый элемент: " + pair.first());
        System.out.println("Второй элемент: " + pair.second());
        System.out.println("пара: " + pair);

        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};

        Double[] array3 = {1.0, 2.0, 3.0};
        Double[] array4 = {1.0, 2.0, 6.0};

        boolean isEqual = CompareArrays.compareArrays(array1, array2);
        boolean isEqual2 = CompareArrays.compareArrays(array3, array4);

        if (isEqual) {
            System.out.println("Массивы равны");
        } else {
            System.out.println("Массивы различаются");
        }

        if (isEqual2) {
            System.out.println("Массивы равны");
        } else {
            System.out.println("Массивы различаются");
        }
    }
}
