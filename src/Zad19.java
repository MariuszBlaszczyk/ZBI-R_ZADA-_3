import java.util.Random;

public class Zad19 {
    /*
    Napisz program, w którym losujesz kolejne liczby całkowite z przedziału
    <1, 400>. Losowanie pierwszej liczby trwa tak długo, aż nie będzie ona jednym
    z elementów ciągu Fibonacciego. Kolejne losowane liczby muszą być co najmniej
    o 5 większe od poprzednio wylosowanej liczby. Losowanie kończy się, kiedy
    wylosowano liczbę różniącą się od pierwszej wylosowanej liczby o co najmniej
    500. Nie stosujemy tablic.
     */

    static int generateNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }


    public static void main(String[] args) {

        int min = 1;
        int max = 400;
    }
}
