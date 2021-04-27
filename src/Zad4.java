import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad4 {

    /*
    Napisz program, w którym użytkownik podaje dwie liczby całkowite,
    dopóki ich suma nie będzie większa od sumy cyfr większej z podanych liczb.
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
        }
        while (error);
        return number;
    }


    static int maxValue(int... numbers) {
        int maximum = Integer.MIN_VALUE;
        for (int value : numbers) {
            maximum = Math.max(value, maximum);
        }
        return maximum;
    }


    static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        int number1, number2, sum;

        do {
            System.out.println("Give the first number");
            number1 = getNumberFromUser();
            System.out.println("Give the second number");
            number2 = getNumberFromUser();
            sum = number1 + number2;
        } while (!(sum > sumDigits(maxValue(number1, number2))));

        System.out.println("Number1: " + number1);
        System.out.println("Number2: " + number2);
        System.out.println("Max value: " + maxValue(number1, number2));
        System.out.println("Sum: " + sum);
        System.out.println("Sum digits max value: " + sumDigits(maxValue(number1, number2)));

    }
}
