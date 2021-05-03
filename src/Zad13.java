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
                } while (!(min < number && number < max));
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


    public static void main(String[] args) {

        int min = 10;
        int max = 99;
        int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;


        num1 = getNumberFromUser(min, max);

        do {
            num2 = getNumberFromUser(min, max);
            if (tens(num2) != unities(num1)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num3 = getNumberFromUser(min, max);
            if (tens(num3) != unities(num2)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num4 = getNumberFromUser(min, max);
            if (tens(num4) != unities(num3)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num5 = getNumberFromUser(min, max);
            if (tens(num5) != unities(num4)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num6 = getNumberFromUser(min, max);
            if (tens(num6) != unities(num5)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num7 = getNumberFromUser(min, max);
            if (tens(num7) != unities(num6)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num8 = getNumberFromUser(min, max);
            if (tens(num8) != unities(num7)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num9 = getNumberFromUser(min, max);
            if (tens(num9) != unities(num8)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
            num10 = getNumberFromUser(min, max);
            if (tens(num10) != unities(num9)) {
                System.out.println("The tens digit must be the same as the unity digit of the previously given number.");
            }
        } while (!(tens(num2) == unities(num1) || unities(num1) == 0));

    }
}


