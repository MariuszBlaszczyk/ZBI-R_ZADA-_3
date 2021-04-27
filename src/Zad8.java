import java.util.Optional;
import java.util.Random;

public class Zad8 {

    /*
    Napisz program, w którym losujesz dwie liczby całkowite z przedziału
    <30, 100>. Wyznacz liczbę o większej ilości nieparzystych dzielników
    (nie traktuj jako dzielniki liczby 1 oraz liczby badanej).
     */

    static int generateNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Number is out of bounds");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int oddDivisors(int number) {
        int moreOdd;
        int counter = 0;
        for (int i = 3; i < number; i++) {
            if (i % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }

    static Optional<Integer> oddDivisorsIsBigger(int number1, int number2) {
        int odd1 = oddDivisors(number1);
        int odd2 = oddDivisors(number2);
        if (odd1 == odd2) {
            return Optional.empty();
        } else if (odd1 > odd2) {
            return Optional.of(number1);
        } else {
            return Optional.of(number2);
        }
    }

    public static void main(String[] args) {

        int min = 30;
        int max = 100;

        int number1 = generateNumber(min, max);
        int number2 = generateNumber(min, max);

        System.out.println("Number1 is: " + number1);
        System.out.println("Number2 is: " + number2);
//Czy musi wyświetlać się słowo Optional???
        System.out.println("Number with more odd divisors: " + oddDivisorsIsBigger(number1, number2));
    }
}
