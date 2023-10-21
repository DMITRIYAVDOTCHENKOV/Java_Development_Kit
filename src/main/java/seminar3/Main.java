package seminar3;

public class Main {

    public static void main(String[] args) {
        MyArray<String> array = new MyArray<>();
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        System.out.println(array);

        array.remove(1);
        System.out.println();
        System.out.println(array);

        MyArray<Person> array1 = new MyArray<>();
    }
}