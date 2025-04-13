package pl.pp;
import java.util.Scanner;

public class mojaCzwartaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wpisz dolnego i gornego limitu:");
            int dol = scanner.nextInt();
            int gor = scanner.nextInt();
            int suma = 0;

            if (gor <= dol) {
                System.out.println("Wyjście...");
                break;
            }
            else {
            for (int i = dol;i <= gor;i++) {
            suma += i*i;
            }
            }

            System.out.println("Suma kwadratów liczb od  " + (dol * dol) + " do " + (gor * gor) + "  wynosi " + suma);
            var user = scanner.next();

            if (user.equals("-1")){
                break;
        }

        }
        scanner.close();

    }
}