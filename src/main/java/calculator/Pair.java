package calculator;
// Можете подсказать, что тут случилось ), эта запись идентична , с той что закомментировано ? ,
// почему предложила IDE так сделать )
public record Pair<T, U>(T first, U second) {
    @Override
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
//    private final T first;
//    private final U second;
//
//    public Pair(T first, U second) {
//        this.first = first;
//        this.second = second;
//    }
//
//    public T getFirst() {
//        return first;
//    }
//
//    public U getSecond() {
//        return second;
//    }
//
//    @Override
//    public String toString() {
//        return "(" + first.toString() + ", " + second.toString() + ")";
//    }

}