import java.rmi.ServerError;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad18 {

    /*
    Wylosuj dwie zmienne x oraz y typu double z przedziału <3.5, 9.5>. Liczby
    x oraz y reprezentują punkt na płaszczyźnie. Następnie pobieraj od użytkownika
    5 par liczb typ double, które również opisują punkt w układzie współrzędnych.
    Wyznacz parę, której odległość od punktu o współrzędnych x oraz y jest
    najmniejsza. Nie stosujemy tablic.
     */

    static double generateNumbers(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return Math.random() * (max - min) + min;
    }

    static double getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        double number = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Give the number");
                number = scan.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.err.println("You must give a number");
                scan.nextLine();
            }
        } while (error);
        return number;
    }

    static void finalResult(double min, double max) {
        double userNumber1 = 0;
        double userNumber2 = 0;
        double x = generateNumbers(min, max);
        System.out.println("X = " + x);
        double y = generateNumbers(min, max);
        System.out.println("Y = " + y);
        double absDraw = Math.abs(x - y);
        double absUser = Math.abs(userNumber1 - userNumber2);
        double abs = Math.abs(absUser - absDraw);
        double min1= 0;
        double min2 = 0;
        double minDev = Double.MAX_VALUE;
        for (int i = 0; i <= 5; i++) {
            userNumber1 = getNumberFromUser();
            userNumber2 = getNumberFromUser();
            if (minDev > abs) {
                minDev = abs;
                min1 = userNumber1;
                min2 = userNumber2;
            }
        }
        System.out.println("The pair with the largest standard deviation is: " + min1 + " and " + min2 + ".");
    }


    public static void main(String[] args) {

        double min = 3.5;
        double max = 9.5;

        finalResult(min, max);
    }
}
