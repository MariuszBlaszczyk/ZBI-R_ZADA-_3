import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad1 {

    /*
    Napisz program, w którym pobierasz od użytkownika dwie liczby całkowite,
    dopóki ilość wspólnych dodatnich dzielników tych liczb nie będzie dzielnikiem jednej z pobranych liczb.
    Ilość dzielników nie powinna uwzględniać liczby 1 oraz liczby, której dzielniki wyznaczamy.
     */

    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        try {
            number = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("The value given is not a number, pleae give it again: ");
            scan.nextLine();
            scan.nextInt();
        }
        return number;
    }// jeśli wpiszę bezpośrednio z ręki 60 i 30 to wynikiem jest 6, natomiast jeśli wpiszę najpierw literę,
    //wyskoczy wyjątk to podaję 60, do drugiej liczby znów daję litere wyskakuje wyjątek, a po niej daje cyfrę,
    // i wtedy niby podałem 60 i 30, ale wynik z licznika podaje 0 zamiat 6. Próbuje się nauczyć tej konstrukcji
    //try catch, ale czegoś tam jeszcze nie ogarniam.


    static int minimum(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int value : numbers) {
            min = Math.min(min, value);
        }
        return min;
    }

    static int commonDividers(int number1, int number2) {
        int counter = 0;
        int min = minimum(number1, number2);
        for (int i = 2; i < min; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                System.out.print("Common dividers is: " + i + "\t");
                //counter++ i ++counter zwracają taką samą liczbę, dlatego którego lepiej użyć licząc licznik
                //i w ogóle kiedy lepiej użyć ++counter
                counter++;

                //jak to zapisać żeby wyświetliło wspólne liczniki bez powtarzania  w jendej linii, no i liczbę
                //wspólnych dzielników bo się zakręcilem trochę
            }
        }
        System.out.print("Number of common dividers: " + counter);
        return counter;
    }

    static boolean numeratorIsACommonDivisor(int number1, int number2) {
        boolean result1 = number1 % commonDividers(number1, number2) == 0;
        boolean result2 = number2 % commonDividers(number1, number2) == 0;
        return result1 || result2;
    }


    public static void main(String[] args) {

        int number1, number2;
        do {
            System.out.println("Give the first number:");
            number1 = getNumberFromUser();
            System.out.println("Give the second number:");
            number2 = getNumberFromUser();
        } while (!numeratorIsACommonDivisor(number1, number2));

        System.out.println("Number1: " + number1);
        System.out.println("Number2: " + number2);

    }
}
