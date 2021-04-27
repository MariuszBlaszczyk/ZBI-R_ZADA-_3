import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad9 {

    /*
    Napisz program, który wyznacza współczynnik BMI. Pobieraj
    od użytkownika potrzebne wielkości i wyświetlaj informacje na temat
    wagi użytkownika (nadwaga, niedowaga, w normie).
     */

    static double getUserWeight() {
        Scanner scan = new Scanner(System.in);
        double weight = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Enter your weight in kilograms");
                weight = scan.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.err.println("The value given is not a number, pleae give it again: ");
                scan.nextLine();
            }
        }
        while (error);
        return weight;
    }

    static double getUserHeight() {
        Scanner scan = new Scanner(System.in);
        double height = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Enter your height in centimetres");
                height = scan.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.err.println("The value given is not a number, pleae give it again: ");
                scan.nextLine();
            }
        }
        while (error);
        height = height / 100;
        return height;
    }

    static double calculateBmi(double weight, double height) {
        double heightPow = Math.pow(height, 2);
        double bmi = weight / heightPow;
        bmi *= 100;
        bmi = Math.round(bmi);
        bmi /= 100;
        return bmi;
    }

    static int rangeOf(double bmi) {
        if (bmi <= 15.9) {
            return 1;
        } else if (bmi <= 16.9) {
            return 2;
        } else if (bmi <= 18.4) {
            return 3;
        } else if (bmi <= 24.9) {
            return 4;
        } else if (bmi <= 29.9) {
            return 5;
        } else if (bmi <= 34.9) {
            return 6;
        } else if (bmi <= 39.9) {
            return 7;
        } else {
            return 8;
        }
    }

    static void finalResult(double number) {
        int range = rangeOf(number);
        String result = null;
        switch (range) {
            case 1 -> result = "Starvation !!!";
            case 2 -> result = "Emaciation !!";
            case 3 -> result = "Underweight :(";
            case 4 -> result = "Normal weight :)";
            case 5 -> result = "Overweight :(";
            case 6 -> result = "Grade 1 obesity !";
            case 7 -> result = "Grade 2 obesity !!";
            case 8 -> result = "SGrade 3 obesity !!!";
        }
        System.err.println(result);
    }


    public static void main(String[] args) {

        double weight = getUserWeight();
        double height = getUserHeight();
        double bmi = calculateBmi(weight, height);

        System.out.println("\n" + "BMI is: " + bmi + "\n");

        finalResult(bmi);
    }
}
