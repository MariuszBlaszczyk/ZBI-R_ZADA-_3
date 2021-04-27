import java.util.Arrays;
import java.util.Random;

public class Zad3 {

    /*
    Napisz program, w którym losowane są trzy liczby całkowite z przedziału <10, 100>,
    dopóki ich suma nie będzie większa od trzykrotności liczby środkowej
    (czyli drugiej co do wielkości spośród trzech podanych).
     */

    static int generateNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Randm range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int sumNumbers(int... numbers) {
        int sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        return sum;
    }

    static int minValue(int... numbers) {
        int minimum = Integer.MAX_VALUE;
        for (int value : numbers) {
            minimum = Math.min(value, minimum);
        }
        return minimum;
    }

    static int maxValue(int... numbers) {
        int maximum = Integer.MIN_VALUE;
        for (int value : numbers) {
            maximum = Math.max(value, maximum);
        }
        return maximum;
    }

    static int midValue(int number1, int number2, int number3) {
        int min = minValue(number1, number2, number3);
        int max = maxValue(number1, number2, number3);
        int sum = number1 + number2 + number3;
        return sum - max - min;
    }

    public static void main(String[] args) {

        int min = 10;
        int max = 100;
        int number1, number2, number3, sum, mid;

        do {
            number1 = generateNumber(min, max);
            number2 = generateNumber(min, max);
            number3 = generateNumber(min, max);
            sum = sumNumbers(number1, number2, number3);
            mid = midValue(number1, number2, number3);
        } while (!(sum > 3 * mid));

        System.out.println("Number 1: " + number1);
        System.out.println("Number 2: " + number2);
        System.out.println("Number 3: " + number3);
        System.out.println("Sum: " + sum);
        System.out.println("Mid: " + mid);
    }
}
