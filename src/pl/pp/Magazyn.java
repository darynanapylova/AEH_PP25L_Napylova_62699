package pl.pp;

public class Magazyn {
    private String numermag;
    private int przestrzenmag;
    private String nazwamag;
    private String email;
    private String numertel;

    public Magazyn() {}

    public Magazyn(String numermag, int przestrzenmag, String nazwamag, String email, String numertel) {
        this.numermag = numermag;
        this.przestrzenmag = przestrzenmag;
        this.nazwamag = nazwamag;
        this.email = email;
        this.numertel = numertel;
    }

    public String getNumermag() { return numermag; }
    public void setNumermag(String numermag) { this.numermag = numermag; }

    public int getPrzestrzenmag() { return przestrzenmag; }
    public void setPrzestrzenmag(int przestrzenmag) { this.przestrzenmag = przestrzenmag; }

    public String getNazwamag() { return nazwamag; }
    public void setNazwamag(String nazwamag) { this.nazwamag = nazwamag; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumertel() { return numertel; }
    public void setNumertel(String numertel) { this.numertel = numertel; }




    public void aktualizujKontakt(String email, String numertel) {
        this.email = email;
        this.numertel = numertel;
        System.out.println("Zaktualizowano dane kontaktowe. Nowy email: " + email + ", nowy numer telefonu: " + numertel);
    }

    public void dodajTowar(int iloscJednostekTowaru) {
        if (przestrzenmag >= iloscJednostekTowaru) {
            przestrzenmag -= iloscJednostekTowaru;
            System.out.println("Dodano " + iloscJednostekTowaru + " jednostek towaru. Pozostała przestrzeń: " + przestrzenmag);
        } else {
            System.out.println("Brak miejsca! Pozostała przestrzeń: " + przestrzenmag);
        }
    }

    public void usunTowar(int iloscJednostekTowaru) {
        int zajetaPrzestrzen = 5000 - przestrzenmag;
        if (zajetaPrzestrzen >= iloscJednostekTowaru) {
            przestrzenmag += iloscJednostekTowaru;
            System.out.println("Usunięto " + iloscJednostekTowaru + " jednostek towaru. Pozostała przestrzeń: " + przestrzenmag);
        } else {
            System.out.println("Nie można usunąć " + iloscJednostekTowaru + " jednostek. Zajęta przestrzeń: " + zajetaPrzestrzen);
        }
    }

    public String sprawdzZajetosc() {
        int zajeta = 5000 - przestrzenmag;
        return "Zajęta przestrzeń: " + zajeta + ", dostępna: " + przestrzenmag;
    }

    public void getInfo() {


    }
    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn();


        System.out.println("Stan początkowy:");
        magazyn.getInfo();
        System.out.println(magazyn.sprawdzZajetosc());

        magazyn.dodajTowar(1000);
        magazyn.usunTowar(2500);
        System.out.println(magazyn.sprawdzZajetosc());

        magazyn.aktualizujKontakt("nowy@magazyn.pl", "+48 100 000 000");

        System.out.println("Za mało miejsca w magazynie:");
        magazyn.dodajTowar(2500);
    }
}
