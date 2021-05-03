import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad5 {

    /*
    Napisz program, w którym użytkownik podaje liczbę całkowitą i wyznacza,
    ile jest w niej cyfr parzystych, znajdujących się na pozycji parzystej.
    Zakładamy, że cyfra jedności ma pozycję parzystą, cyfra dziesiątek
    ma pozycję nieparzystą, cyfra setek ma pozycję parzystą itd.
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
                System.err.println("You must specify a number. Please try again: ");
                scan.nextLine();
            }
        } while (error);
        return number;
    }

    static int howManyEvenDigitsIsInEvenPosition(int number) {
        int counter = 0;
        boolean evenPos = true;
        while (number > 0) {
            number %= 10;
            if (number % 2 == 0 && evenPos) {
                counter++;
            }
            evenPos = !evenPos;
        }
        return counter;
    }

    public static void main(String[] args) {

        int number = getNumberFromUser();
        System.out.println("Counter: " + howManyEvenDigitsIsInEvenPosition(number));

    }
}



