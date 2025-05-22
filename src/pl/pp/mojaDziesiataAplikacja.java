package pl.pp;

public class mojaDziesiataAplikacja {
    public static void main(String[] args) {
        int[] daneWejsciowe = {1, 2, 3, 4, 5, -3, -2, -1};
        int[] wynik = analizujTablice(daneWejsciowe);

        if (wynik.length == 0) {
            System.out.println("Brak danych wejściowych.");
        } else {
            System.out.println("Ilość liczb ujemnych: " + wynik[0]);
            System.out.println("Suma liczb dodatnich: " + wynik[1]);
        }
    }

    public static int[] analizujTablice(int[] liczby) {
        if (liczby == null || liczby.length == 0) {
            return new int[0];
        }

        int ujemne = 0;
        int sumaDodatnich = 0;

        for (int liczba : liczby) {
            if (liczba < 0) {
                ujemne++;
            } else if (liczba > 0) {
                sumaDodatnich += liczba;
            }
        }

        int[] rezultat = new int[2];
        rezultat[0] = ujemne;
        rezultat[1] = sumaDodatnich;
        return rezultat;
    }
}