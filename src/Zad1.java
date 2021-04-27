import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad1 {

    /*
    Napisz program, w którym pobierasz od użytkownika dwie liczby całkowite,
    dopóki ilość wspólnych dodatnich dzielników tych liczb nie będzie dzielnikiem jednej z pobranych liczb.
    Ilość dzielników nie powinna uwzględniać liczby 1 oraz liczby, której dzielniki wyznaczamy.
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



    static int minimum(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int value : numbers) {
            min = Math.min(min, value);
        }
        return min;
    }

    static int commonDividers(int number1, int number2) {
        int counter = 0;
        int min = minimum(number1, number2);
        System.out.print("Common dividers is: ");
        for (int i = 2; i < min; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                System.out.print(i + " ");
                counter++;
            }
        }
        System.out.print("\n" + "Number of common dividers: ");
        System.out.print(counter + "\t");
        return counter;
    }

    static boolean numeratorIsACommonDivisor(int number1, int number2) {
        int cd = commonDividers(number1, number2);
        boolean result1 = number1 % cd == 0;
        boolean result2 = number2 % cd == 0;
        return result1 || result2;
    }


    public static void main(String[] args) {

        int number1, number2;
        do {
            System.out.println("Give the first number:");
            number1 = getNumberFromUser();
            System.out.println("Give the second number:");
            number2 = getNumberFromUser();
        } while (!numeratorIsACommonDivisor(number1, number2));



    }
}
