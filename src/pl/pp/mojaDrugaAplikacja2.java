package pl.pp;

import java.util.Scanner;

public class mojaDrugaAplikacja2 {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz swoj wiek:");
        double wiek = scanner.nextDouble();
        int x = 365*24*60*60 ; // 1 rok w sekundach
        long y = (long) wiek * x;

        System.out.println(" Twoj wiek w sekundach "+ y);


    }
}
