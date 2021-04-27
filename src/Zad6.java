import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad6 {

    /*
    Napisz program, w którym użytkownik podaje liczbę całkowitą. Sprawdź,
    czy suma cyfr tej liczby jest liczbą pierwszą.
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

    static int sumDigit(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        double sqrt = Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int number = getNumberFromUser();

        System.out.println(isPrime(sumDigit(number)) ? "The sum of the numbers is prime." :
                "The sum of the numbers is not prime.");
    }
}
