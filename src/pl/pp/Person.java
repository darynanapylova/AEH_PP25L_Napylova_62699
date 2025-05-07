package pl.pp;

public class Person {
    // pola (atrybuty) klasy określającej obiekt "Person" (jego parametry/cechy)
    public String forename; // pole przechowujące cechę imię
    public String surname; // pole przechowujące cechę nazwisko
    public int age; // pole przechowujące cechę wiek
    public String city; // pole przechowujące cechę miasto
    public String sign; // pole przechowujące cechę znak zodiaku

    /**
     * Konstruktor domyślny - element inicjalizujący pola obiektu podczas jego tworzenia
     * (jeśli sami nie podamy żadnych parametrów)
     */
    public Person() {

    }

    /**
     * Konstruktor z trzema parametrami, które możemy podać przy jego tworzeniu
     */
    public Person(String initForename, String initSurname, int initAge,String initCity,String initSign) {
        forename = initForename;
        surname = initSurname;
        age = initAge;
        city = initCity;
        sign = initSign;
    }

    // metody klasy określające akcje możliwe do wykonania przez obiekt
    public void hiToAll(){
        System.out.println("Nazywam się " + forename + " " + surname + ". " + "Mam " + age + " lat. Mieszkam w " + city + " . Mój znak zodiaku to "+ sign + " .");
    }

    // przykładowa metoda growOld, która zwiększa dany wiek obiektu o jeden za każdym jej wywołaniem
    public int growOld(int years){
        age = age + years;
        return age;
    }
    int beYounger() {
        age = age - 1;
        return age;
    }
    // przykładowa metoda getName zwracająca wartość forename obiektu
        String getName() {
            return forename;
    }

    // przykładowa metoda setName ustawiająca wartość forename obiektu
    public void setName(String nameToSet){
        forename = nameToSet;
    }
}
