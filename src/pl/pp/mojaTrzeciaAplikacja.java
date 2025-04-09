package pl.pp;
import java.util.Scanner;

public class mojaTrzeciaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iloscdni;

        while (true) {
            System.out.println("Wpisz dodatnią wartość, żeby sprawdzić liczbę dni\n" +
                    "Wpisz wartość -1, żeby wyjść z programu\n" +
                    "Wpisz wartość mniejszą lub równą -2, żeby sprawdzić temperaturę");

            iloscdni = scanner.nextInt();

            if (iloscdni == -1) {
                System.out.println("Wyjście...");
                break;
            } else if (iloscdni <= -2) {
                double fahrenheit = 1.8 * iloscdni + 32;
                double kelwin = iloscdni + 273.16;

                System.out.println(iloscdni + "°C to:");
                System.out.printf("%.2f°F\n", fahrenheit);
                System.out.printf("%.2f K\n", kelwin);
            } else if (iloscdni >= 0) {
                int tygodnie = iloscdni / 7;
                int dni = iloscdni % 7;
                System.out.println(iloscdni + " dni to " + tygodnie + " tygodnie i " + dni + " dni.");
            }
        }

        scanner.close();
    }
}
