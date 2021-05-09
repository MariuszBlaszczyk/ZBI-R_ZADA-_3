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
                System.err.println("You must give a number!");
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
        double number1;
        double number2;
        double min1 = 0;
        double max1 = 0;
        double min2 = 0;
        double max2 = 0;
        double minDev = Double.MAX_VALUE;
        double maxDev = Double.MIN_VALUE;
        for (int i = 1; i <= 10; i++) {
            number1 = getNumberFromUser(minUser, maxUser);
            number2 = generateNumber(minDraw, maxDraw);
            if (minDev > standardDeviation(number1, number2)) {
                minDev = standardDeviation(number1, number2);
                min1 = number1;
                min2 = number2;
            }
            if (maxDev < standardDeviation(number1, number2)) {
                maxDev = standardDeviation(number1, number2);
                max1 = number1;
                max2 = number2;
            }
        }
        System.out.println("The pair with the smallest standard deviation is " + min1 + " and " + min2 + ".");
        System.out.println("The pair with the largest standard deviation is " + max1 + " and " + max2 + ".");
    }


    public static void main(String[] args) {


        double minUser = 4.5;
        double maxUser = 10.5;

        double minDraw = 3.5;
        double maxDraw = 12.5;

        finalResult(minUser, maxUser, minDraw, maxDraw);

    }
}
