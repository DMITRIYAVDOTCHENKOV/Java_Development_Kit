package calculator;

import java.text.DecimalFormat;

public class Calculator extends Sum {
    public static void main(String[] args) {
        double a = 100.5;
        int b = 36;

        double a2 = 10.3;
        double b2 = 36.2;

        Number sumResult = Calculator.sum(a, b);
        Number multiplyResult = Calculator.multiply(a, b);
        Number divideResult = Calculator.divide(a, b);
        Number subtractResult = Calculator.subtract(a, b);

        double sumResult2 = Calculator.sum(a2, b2);
        double multiplyResult2 = Calculator.multiply(a2, b2);
        double divideResult2 = Calculator.divide(a2, b2);
        double subtractResult2 = Calculator.subtract(a2, b2);

        DecimalFormat decimalFormat = new DecimalFormat();

        System.out.printf("Сумма чисел %f и %d = %s\n", a, b, decimalFormat.format(sumResult));
        System.out.printf("Произведение чисел %f и %d = %s\n", a, b, decimalFormat.format(multiplyResult));
        System.out.printf("Частное чисел %f и %d = %s\n", a, b, decimalFormat.format(divideResult));
        System.out.printf("Разница чисел %f и%d = %s\n", a, b, decimalFormat.format(subtractResult));
        System.out.println("=========================================");
        System.out.printf("Сумма чисел %f и %f = %f\n", a2, b2, sumResult2);
        System.out.printf("Произведение чисел %f и %f = %f\n", a2, b2, multiplyResult2);
        System.out.printf("Частное чисел %f и %f = %f\n", a2, b2, divideResult2);
        System.out.printf("Разница чисел %f и %f = %f\n", a2, b2, subtractResult2);


    }
}
