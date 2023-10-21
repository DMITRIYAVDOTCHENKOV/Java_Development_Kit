package calculator;

public class Divide extends Subtract {
    public static <T extends Number> T divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо");
        }
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(((Integer) a) / ((Integer) b));
        } else if (a instanceof Double && (b instanceof Double || b instanceof Integer)) {
            return (T) Double.valueOf(((Double) a) / b.doubleValue());
        } else if (a instanceof Float && (b instanceof Float || b instanceof Integer)) {
            return (T) Float.valueOf(((Float) a) / b.floatValue());
        } else if (a instanceof Long && (b instanceof Long || b instanceof Integer)) {
            return (T) Long.valueOf(((Long) a) / b.longValue());
        } else {
            throw new IllegalArgumentException("Неверные данные");
        }
    }
}