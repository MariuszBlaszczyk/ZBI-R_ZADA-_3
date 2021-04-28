import java.util.Random;

public class Zad11 {

    /*
    Napisz program, który losuje trzy liczby całkowite z przedziału
    <30, 100>, dopóki suma cyfr najmniejszej liczby nie będzie taka sama
    jak suma cyfr liczby największej.
     */

    static int generateNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Number is out of bound");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    static int minValue(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int value : numbers) {
            min = Math.min(value, min);
        }
        return min;
    }

    static int maxValue(int... numbers) {
        int max = Integer.MIN_VALUE;
        for (int value : numbers) {
            max = Math.max(value, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int min = 30;
        int max = 100;

        int number1, number2, number3;

        do {
            number1 = generateNumber(min, max);
            number2 = generateNumber(min, max);
            number3 = generateNumber(min, max);
        } while (!(sumDigits(minValue(number1, number2, number3)) == sumDigits(maxValue(number1, number2, number3))));

        System.out.println("Number1: " + number1);
        System.out.println("Number2: " + number2);
        System.out.println("Number3: " + number3);

    }
}
