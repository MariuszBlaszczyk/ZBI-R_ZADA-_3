import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Zad14 {
    /*
    Napisz program, który symuluje prostą grę dwuosobową. Aplikacja prosi
    pierwszego użytkownika o podanie dowolnej liczby z przedziału
        <100, 999>. Następnie drugi użytkownik podaje liczby, dopóki nie uda
    mu się podać takiej, która ma identyczną sumę cyfr, jak liczba podana
    przez przeciwnika. Należy zliczyć ilość prób, które potrzebował gracz,
    żeby podać prawidłową liczbę. Następnie drugi gracz podaje liczbę
    i gracz pierwszy musi na tych samych zasadach podać liczbę. Gra kończy
    się, kiedy jeden z graczy będzie potrzebował więcej niż 5 prób
    na podanie prawidłowej liczby. Nie zapomnij na koniec wyświetlić
i   nformacji o zwycięzcy.
     */

    static int getNumberFromUser(int min, int max) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        do {
            try {
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

    static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    static int numberOfTrials(int userNumber) {
        int counter = 0;
        int trailNumber;
        for (int i = 0; i < 5; i++) {
            trailNumber = getNumberFromUser(100, 999);
            System.out.println("The sum of the digits is not identical, keep trying.");
            if (sumDigits(userNumber) == sumDigits(trailNumber)) {
                counter++;
                System.out.println("Bravo, you have managed to find a number with the same sum of digits after "
                        + counter + " trying.");
                break;
            }
            counter++;
        }
        return counter;
    }

    static void andTheWinnerIs(int attemptUser1, int attemptUser2) {
        if (attemptUser1 < attemptUser2) {
            System.out.println("And the winner is first player with " + attemptUser1 + " attempts.");
        } else if (attemptUser1 > attemptUser2) {
            System.out.println("And the winner is second player with " + attemptUser2 + " attempts.");
        } else {
            System.out.println("We have a draw - " + attemptUser1 + " : " + attemptUser2);
        }
    }

    public static void main(String[] args) {

        int min = 100;
        int max = 999;

        System.out.println("I ask the first player to give a number between " + min + " - " + max + ".");
        int user1number = getNumberFromUser(min, max);

        System.out.println("The second player gives a number until you manage to give one that has the same" +
                " sum of digits as the number given by the first player.");

        int user1 = numberOfTrials(user1number);

        System.out.println("I ask the second player to give a number between " + min + " - " + max + ".");
        int user2number = getNumberFromUser(min, max);

        System.out.println("The first player gives a number until you manage to give one that has the same" +
                " sum of digits as the number given by the second player.");

        int user2 = numberOfTrials(user2number);

        andTheWinnerIs(user1, user2);


    }

}
