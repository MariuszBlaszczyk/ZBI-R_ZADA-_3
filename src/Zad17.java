import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad17 {

    /*
    Pobieraj od użytkownika za każdym razem trzy liczby typu double. Pobieranie
    liczb kontynuuj, dopóki użytkownik nie poda takiej trójki liczb, która będzie
    reprezentować trójkąt, którego pole okręgu opisanego na nim będzie większe od 100.
     */


    static double getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        double number = 0;
        boolean error = true;
        do {
            try {
                number = scan.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("You must give a number.");
                scan.nextLine();
            }
        } while (error);
        return number;
    }

    static double areaOfTriangle(double side1, double side2, double side3) {
        double sideSum = side1 + side2 + side3;
        double halfPerimeter = sideSum / 2.0;
        double a = halfPerimeter - side1;
        double b = halfPerimeter - side2;
        double c = halfPerimeter - side3;
        return Math.sqrt(halfPerimeter * a * b * c);
    }


    public static void main(String[] args) {

        double user1, user2, user3;

        do {
            user1 = getNumberFromUser();
            user2 = getNumberFromUser();
            user3 = getNumberFromUser();
        } while ();
    }
}
