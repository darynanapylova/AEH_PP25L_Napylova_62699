package pl.pp;

import java.util.Scanner;

public class mojaCzwartaAplikacja2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz działanie: dodawanie, odejmowanie, mnożenie, dzielenie. Aby zakończyć, wpisz 'wyjscie'.");
            String kal = scanner.next();

            if (kal.equals("wyjscie")) {
                break;
            }

            System.out.println("Napisz dwie liczby:");
            double jed = scanner.nextDouble();
            double dwa = scanner.nextDouble();
            double znacz = 0;

            if (kal.equals("dodawanie")) {
                znacz = jed + dwa;
            } else if (kal.equals("odejmowanie")) {
                znacz = jed - dwa;
            } else if (kal.equals("mnożenie")) {
                znacz = jed * dwa;
            } else if (kal.equals("dzielenie")) {
                if (dwa != 0) {
                    znacz = jed / dwa;
                } else {
                    System.out.println("Błąd: nie można dzielić przez zero.");
                    continue;
                }
            } else {
                System.out.println("Nieznana operacja.");
                continue;
            }

            System.out.println("Równa się " + znacz);
        }

        scanner.close();
    }
}
