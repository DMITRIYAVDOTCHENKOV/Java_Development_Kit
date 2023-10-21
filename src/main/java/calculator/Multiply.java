package calculator;

public class Multiply extends Divide {
    public static <T extends Number> T multiply(T a, T b) {

        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(((Integer) a) * ((Integer) b));
        } else if (a instanceof Double && (b instanceof Double || b instanceof Integer)) {
            return (T) Double.valueOf(((Double) a) * b.doubleValue());
        } else if (a instanceof Float && (b instanceof Float || b instanceof Integer)) {
            return (T) Float.valueOf(((Float) a) * b.floatValue());
        } else if (a instanceof Long && (b instanceof Long || b instanceof Integer)) {
            return (T) Long.valueOf(((Long) a) * b.longValue());
        } else {
            throw new IllegalArgumentException("Неверные данные");
        }
    }
}
