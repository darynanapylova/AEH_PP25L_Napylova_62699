package pl.pp;
import pl.pp.Person;
import pl.pp.Circle;
import pl.pp.Magazyn;

public class mojaDziewiataAplikacja {
    public static void main(String[] args) {
        Person person1 = new Person("Test", "Testowy", 25); //nowy obiekt klasy Person
        person1.hiToAll(); //wywołanie metody hiToAll() z obiektu person1 klasy Person

        person1.growOld(10); //wywołanie metody growOld( z obiektu person1 klasy Person
        person1.hiToAll();

        person1.setForename("ZmienionyTest"); //wywołanie metody tzw. "settera" do zmiany imienia
        person1.hiToAll();

        String personName = person1.getForename(); //wywołanie metody tzw. "gettera" do pobrania imienia
        int personAge = person1.getAge(); //wywołanie metody tzw. "gettera" do pobrania wieku
        System.out.println("Pobrane imię to " + personName + " z wiekiem = " + personAge);

        Circle circle1 = new Circle(1.2); //nowy obiekt klasy Circle
        circle1.getInfo(); //wywołanie metody getInfo() z obiektu circle1 klasy Circle
        circle1.setRadius(2.6); //wywołanie metody tzw. "settera" do zmiany promienia
        circle1.getInfo();

        Magazyn magazyn = new Magazyn(
                "235235",       // numermag
                5000,            // przestrzenmag
                "Iryna Polak",    // nazwamag
                "mag@mail.com", // email
                "+48 000 000 000"     // numertel
        );
        magazyn.getInfo();
        System.out.println("Stan początkowy:");
        magazyn.getInfo();
        System.out.println(magazyn.sprawdzZajetosc());

        magazyn.dodajTowar(1000);
        magazyn.usunTowar(2500);
        System.out.println(magazyn.sprawdzZajetosc());

        magazyn.aktualizujKontakt("nowy@mail.com", "+48 100 000 000");

        System.out.println("Za mało miejsca w magazynie:");
        magazyn.dodajTowar(2500);
        magazyn.getInfo();














    }
}
