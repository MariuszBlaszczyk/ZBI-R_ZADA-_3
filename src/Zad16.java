import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zad16 {

    /*
    Pobieraj od użytkownika 10 liczb typu double, które muszą być z przedziału
    <4.5, 10.5>. Za każdym razem, kiedy użytkownik poda liczbę, losowana jest
    liczba z przedziału <3.5, 12.5>, co pozwoli nam zestawić 10 par liczb pobrana
    – losowana. Wyznacz taką parę, której odchylenie standardowe jest najmniejsze
    oraz taką parę, której odchylenie standardowe jest największe. Nie stosujemy tablic.
     */

    static double getNumberFromUser(double min, double max) {
        Scanner scan = new Scanner(System.in);
        double number = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Give a number between " + min + " - " + max);
                do {
                    number = scan.nextDouble();
                    if (min > number || max < number) {
                        System.out.println("The number cannot be less than " + min + " and bigger than " + max +
                                ", please provide a new number.");
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

    static double generateNumber(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("Random range is not correct.");
        }
        return Math.random() * (max - min) + min;
    }

    static double standardDeviation(double userNumber, double drawNumber) {
        double avg = (userNumber + drawNumber) / 2.0;
        double a = Math.pow(userNumber - avg, 2);
        double b = Math.pow(drawNumber - avg, 2);
        double x = a + b;
        return Math.sqrt(x / 2.0);
    }

    static void finalResult(double minUser, double maxUser, double minDraw, double maxDraw) {
        double minDev = Double.MAX_VALUE;
        double maxDev = Double.MIN_VALUE;
        for (double i = 1; i <= 10; i++) {
            i = getNumberFromUser(minUser, maxUser);
            for (double j = 1; j <= 10; j++) {
                j = generateNumber(minDraw, maxDraw);
                if (Math.abs(i - j) >= Math.min(minDev, standardDeviation(i, j))) {
                    System.out.println("Minimum deviation has : " + i + " and " + j);
                }
                if (Math.abs(i - j) >= Math.max(minDev, standardDeviation(i, j))) {
                    System.out.println("Maximum deviation has: " + i + " and " + j);
                }
            }
        }
    }

    public static void main(String[] args) {

        double minUser = 4.5;
        double maxUser = 10.5;

        double minDraw = 3.5;
        double maxDraw = 12.5;

        finalResult(minUser, maxUser, minDraw, maxDraw);

    }
}
