import java.util.Random;

public class Zad12 {

    /*
    Napisz program, który losuje dwie liczby całkowite z przedziału
    <10, 35>, dopóki suma cyfry jedności pierwszej wylosowanej liczby oraz
    cyfry dziesiątek drugiej wylosowanej liczby nie będzie liczbą pierwszą większą od 5.
     */

    static int generateNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Number is out of bound");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int unities(int number) {
        return number % 10;
    }

    static int tens(int number) {
        return (number % 100) / 10;
    }

    //Czy ta metoda jest prawidłowo napisana?? tak wiem że jej nie użyłem
    static boolean isNotPrime(int number) {
        if (number < 2) {
            return true;
        }
        if (number == 2 || number == 3) {
            return false;
        }
        double sqrt = Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        double sqrt = Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    


    public static void main(String[] args) {

        int min = 10;
        int max = 35;

        int number1, number2, sum;

        do {
            number1 = generateNumber(min, max);
            number2 = generateNumber(min, max);
            sum = unities(number1) + tens(number2);
        } while (!(isPrime(sum) && sum > 5));

        System.out.println("Number1 is: " + number1);
        System.out.println("Number2 is: " + number2);
    }
}