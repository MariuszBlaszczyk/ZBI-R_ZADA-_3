import java.util.Random;

public class Zad2 {

    /*
    Napisz program, w którym losowane są trzy liczby całkowite z przedziału
    <100, 999>. Z tak otrzymanych liczb utwórz liczbę trzycyfrową, której
    cyfry setek, dziesiątek i jedności to największe spośród odpowiednio
    cyfr setek, cyfr dziesiątek oraz cyfr jedności trzech wylosowanych
    liczb. Kiedy przykładowo wylosujesz liczby 123, 438, 918 wynikiem
    będzie liczba 938, ponieważ 9 to największa z cyfr setek, 3 to
    największa z cyfr dziesiątek oraz 8 to największa z cyfr jedności.
     */

    static int generateNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The number is out of range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int maxValue(int... numbers) {
        int maximum = Integer.MIN_VALUE;
        for (int value : numbers) {
            maximum = Math.max(value, maximum);
        }
        return maximum;
    }

    static int unities(int number) {
        return number % 10;
    }

    static int tens(int number) {
        return (number % 100) / 10;
    }

    static int hundreds(int number) {
        return (number % 1000) / 100;
    }

    static int buildNumberFromMaxDigits(int number1, int number2, int number3) {
        int maxUnities = maxValue(unities(number1), unities(number2), unities(number3));
        int maxTens = maxValue(tens(number1), tens(number2), tens(number3));
        int maxHundreds = maxValue(hundreds(number1), hundreds(number2), hundreds(number3));
        return (maxHundreds) * 100 + (maxTens * 10) + maxUnities;
    }


    public static void main(String[] args) {

        int min = 100;
        int max = 999;

        int number1 = generateNumber(min, max);
        int number2 = generateNumber(min, max);
        int number3 = generateNumber(min, max);

        System.out.println("Number1: " + number1);
        System.out.println("Number2: " + number2);
        System.out.println("Number3: " + number3);

        int newNumber = buildNumberFromMaxDigits(number1, number2, number3);
        System.out.println("New number: " + newNumber);
    }
}
