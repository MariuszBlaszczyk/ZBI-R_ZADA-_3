import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad10 {

    /*
    Napisz program, w którym pobierasz od użytkownika dwie liczby,
    dopóki ich NWD nie okaże się liczbą o sumie cyfr większej od 10.
     */


    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        do {
            try {
                number = scan.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.err.println("You must specify a number. Please try again: ");
                scan.nextLine();
            }
        } while (error);
        return number;
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
            min = Math.min(min, value);
        }
        return min;
    }

    static int maxValue(int... numbers) {
        int max = Integer.MIN_VALUE;
        for (int value : numbers) {
            max = Math.max(max, value);
        }
        return max;
    }


    static int greatestCommonDivisor(int number1, int number2) {
        int gcd = 0;
        int min = minValue(number1, number2);
        for (int i = 1; i <= min; i--) {
            if (number1 % 2 == 0 && number2 % 2 == 0) {
                gcd = maxValue(i, gcd);
            }
        }
        return gcd;
    }

    public static void main(String[] args) {

        int number1, number2;
        do {
            System.out.println("Give the first number");
            number1 = getNumberFromUser();
            System.out.println("Give the second number");
            number2 = getNumberFromUser();
        } while (!(sumDigits(greatestCommonDivisor(number1, number2)) > 10));

    }
}
