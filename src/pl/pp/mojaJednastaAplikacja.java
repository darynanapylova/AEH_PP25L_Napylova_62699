package pl.pp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mojaJednastaAplikacja {
    public static void main(String[] args) {
        List<StudentInfo> listaStudentow = Arrays.asList(
                new StudentInfo("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new StudentInfo("67990", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new StudentInfo("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new StudentInfo("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        StudentInfo najlepszyStudent = listaStudentow.stream()
                .max(Comparator.comparingDouble(StudentInfo::sredniaOcen))
                .orElse(null);

        if (najlepszyStudent != null) {
            System.out.println("Najlepszy student: " + najlepszyStudent);
        } else {
            System.out.println("Brak danych o studentach.");
        }

        listaStudentow.sort(Comparator.comparing(StudentInfo::nazwisko));

        System.out.println("\nStudenci posortowani alfabetycznie:");
        for (StudentInfo student : listaStudentow) {
            System.out.println(student);
        }
    }
}

class StudentInfo {
    private String nrIndeksu;
    private String imie;
    private String nazwisko;
    private List<Integer> oceny;

    public StudentInfo(String nrIndeksu, String imie, String nazwisko, List<Integer> oceny) {
        this.nrIndeksu = nrIndeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = oceny;
    }

    public String numerIndeksu() {
        return nrIndeksu;
    }

    public String imie() {
        return imie;
    }

    public String nazwisko() {
        return nazwisko;
    }

    public List<Integer> oceny() {
        return oceny;
    }

    public double sredniaOcen() {
        if (oceny == null || oceny.isEmpty()) return 0.0;
        return oceny.stream()
                .filter(o -> o != null)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " (" + nrIndeksu + ") - Średnia: " + sredniaOcen();
    }
}
