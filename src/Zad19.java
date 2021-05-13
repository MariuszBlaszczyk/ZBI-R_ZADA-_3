import java.util.Random;

public class Zad19 {
    /*
    Napisz program, w którym losujesz kolejne liczby całkowite z przedziału
    <1, 400>. Losowanie pierwszej liczby trwa tak długo, aż nie będzie ona jednym
    z elementów ciągu Fibonacciego. Kolejne losowane liczby muszą być co najmniej
    o 5 większe od poprzednio wylosowanej liczby. Losowanie kończy się, kiedy
    wylosowano liczbę różniącą się od pierwszej wylosowanej liczby o co najmniej
    500. Nie stosujemy tablic.
     */

    static int generateNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    static void finalResult(int min, int max) {
        int number1;
        do {
            number1 = generateNumber(min, max);
        } while (!(isFibonacci(number1)));
        System.out.println("The first number drawn is: " + number1);
        int number = 0;
        int num = number1;
        while (!(number > num + 5)) {
            number = generateNumber(min, max);
        }
        System.out.println(number);
        num = number;
}


    public static void main(String[] args) {

        int min = 1;
        int max = 1000;


        finalResult(min, max);
    }
}
