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

    static double radiusOfCircle(double side1, double side2, double side3) {
        double side = side1 * side2 * side3;
        double area = areaOfTriangle(side1, side2, side3);
        return side / (4 * area);
    }

    static double areaOfCircle(double side1, double side2, double side3) {
        double radius = radiusOfCircle(side1, side2, side3);
        return Math.PI * Math.pow(radius, 2);
    }


    public static void main(String[] args) {

        double user1, user2, user3;

        do {
            System.out.println("Enter the first side");
            user1 = getNumberFromUser();
            System.out.println("Enter the second side");
            user2 = getNumberFromUser();
            System.out.println("Enter the third side");
            user3 = getNumberFromUser();
        } while (!(areaOfCircle(user1, user2, user3) > 100));

        System.out.println("Side 1 = " + user1);
        System.out.println("Side 2 = " + user2);
        System.out.println("Side 3 = " + user3);

        System.out.println("Area of circle is: " + areaOfCircle(user1, user2, user3));
    }
}
