import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad13 {

    /*
    Napisz program, który pobiera od użytkownika 10 liczb całkowitych.
    Liczby muszą być z przedziału <10, 99>. Każda kolejna pobierana liczba
    musi mieć cyfrę dziesiątek taką samą jak cyfra jedności poprzednio
    pobranej liczby. Kiedy cyfra jedności poprzednio pobranej liczby była
    równa zero, wtedy pobierana liczba może posiadać dowolną cyfrę
    dziesiątek. Pierwsza pobierana liczba jest dowolną liczbą dwucyfrową.
    Oblicz spośród pobranych liczb sumę tych, których cyfra jedności wynosi
    zero. Nie stosujemy tablic.
     */

    static int getNumberFromUser(int min, int max) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Give the integer");
                do {
                    number = scan.nextInt();
                    if (min > number || number > max) {
                        System.out.println("The number cannot be less than " + min + " and bigger than " + max +
                                ", please provide a new number:");
                    }
                } while (!(min <= number && number <= max));
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("You must give a number!");
                scan.nextLine();
            }
        } while (error);
        return number;
    }


    static int unities(int number) {
        return number % 10;
    }

    static int tens(int number) {
        return (number % 100) / 10;
    }

    static int sumOfNumbersWhoseOnesDigitIIsZero(int min, int max) {
        int sum = 0;
        int number1 = getNumberFromUser(min, max);
        int number;
        int latest = number1;
        for (int i = 1; i < 10; i++) {
            do {
                number = getNumberFromUser(min, max);
                if (unities(latest) != tens(number) && unities(latest) != 0) {
                    System.out.println("The unity digit of the first number is not the same as the " +
                            "tens digit of the second number.");
                }
            } while (!(unities(latest) == tens(number) || unities(latest) == 0));
            latest = number;
            if (unities(latest) == 0) {
                sum += latest;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int min = 10;
        int max = 99;

        System.out.println("Sum:" + sumOfNumbersWhoseOnesDigitIIsZero(min, max));


    }
}


