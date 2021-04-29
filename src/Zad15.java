import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zad15 {

    /*
    Napisz program, który losuje liczbę z przedziału <30, 200>. Następnie pobieraj
    od użytkownika kolejne liczby całkowite tak długo, aż średnia wszystkich
    podanych liczb razem z liczbą wylosowaną nie dadzą średniej, która jest
    co najmniej o 20 mniejsza od liczby wylosowanej na początku.
     */

    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Give the integer");
                number = scan.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("You must give a number!");
                scan.nextLine();
            }
        } while (error);
        return number;
    }

    static int generateNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static double averagePlusNumber(int number, int... numbers) {
        double sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        sum += number;
        return sum / numbers.length + 1;
    }

    public static void main(String[] args) {

        int min = 30;
        int max = 200;

        int number1 = generateNumber(min, max);

        System.out.println("Number1: " + number1 + "\n");
        int number2;

        do {
            number2 = getNumberFromUser();
        } while (!(averagePlusNumber(number1, number2) > number1));
        //ma byc mniejsza o co najmniej 20 od wylosowanej liczby
    }
}
