package pl.pp;

import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class mojaSzostaAplikacja {


    public static BigInteger factorialIterative(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Silnia jest niezdefiniowana dla liczb ujemnych.");
        }
        BigInteger result = BigInteger.ONE;
        for (long i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger factorialRecursive(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Silnia jest niezdefiniowana dla liczb ujemnych.");
        }
        if (n == 0) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(factorialRecursive(n - 1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Podaj dodatnią liczbę całkowitą, dla której chcesz obliczyć silnię:");
            try {
                N = scanner.nextLong();
                if (N < 0) {
                    System.out.println("Błąd: Proszę podać liczbę dodatnią.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Błąd: Proszę podać poprawną liczbę całkowitą.");
                scanner.next(); // Konsumuj błędne wejście, aby uniknąć nieskończonej pętli
            }
        }
        scanner.close();


        long startTimeIterative = System.nanoTime();
        BigInteger resultIterative = factorialIterative(N);
        long endTimeIterative = System.nanoTime();
        long executionTimeIterative = (endTimeIterative - startTimeIterative) / 1000000;
        System.out.println("Silnia z " + N + " (iteracyjna) = " + resultIterative);
        System.out.println("Metoda iteracyjna zajmuje " + executionTimeIterative + "ms");


        long startTimeRecursive = System.nanoTime();
        BigInteger resultRecursive = factorialRecursive(N);
        long endTimeRecursive = System.nanoTime();
        long executionTimeRecursive = (endTimeRecursive - startTimeRecursive) / 1000000;
        System.out.println("Silnia z " + N + " (rekurencyjna) = " + resultRecursive);
        System.out.println("Metoda rekurencyjna zajmuje " + executionTimeRecursive + "ms");
    }
}