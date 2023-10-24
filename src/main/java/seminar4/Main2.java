package seminar4;

import java.util.*;

public class Main2 {
    /*
    В рамках выполнения задачи необходимо:
    1) - Создать коллекцию мужеский и женский имен с помощью
    интерфейса List - добавьте повторяющиеся значения
    2) - Получит и уникальный список SET на основании List
    3) - определите наименьший элемент (алфавитный порядок)
    4) - Определяете наибольший элемент (по кол-ву букв в слове но в обратном порядке)
    5) - Удалите все элементы содержания букву 'A'

     */
    public static void main(String[] args) {
        List<String> list = generateList();
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
//        System.out.println(getMaxByLength(set));
        removeByChar(set);
        System.out.println(set);
    }

    static void removeByChar(Set<String> set) {
        set.removeIf(s -> s.contains("Р°"));
    }

    static String getMaxByLength(Set<String> set) {
        return set.stream().max(Comparator.comparingInt(String::length)).get();
    }

    static String getMinByAlphabet(Set<String> set) {
        Set<String> set1 = new TreeSet<>(set);
//        System.out.println(set1.stream().max(String::compareTo));
        Iterator<String> iterator = set1.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    static List<String> generateList() {
        List<String> list = new ArrayList<>();
        list.add("Константин");
        list.add("Василий");
        list.add("Василий");
        list.add("Светлана");
        list.add("Светлана");
        list.add("Анна");
        list.add("Анна");
        list.add("иван");
        list.add("Иван");
        list.add("Валерий");
        return list;
    }
}