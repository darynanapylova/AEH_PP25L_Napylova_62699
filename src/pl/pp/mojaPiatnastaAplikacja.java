package pl.pp;

abstract class Item {
    protected String title;
    protected String author;
    protected String id;
    protected int year;
    protected boolean available;

    public Item(String title, String author, String id, int year, boolean available) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.year = year;
        this.available = available;
    }

    public abstract void showDetails();
}

interface Loanable {
    void borrow();
    void returnItem();
    boolean isAvailable();
}

class Novel extends Item implements Loanable {
    private String genre;

    public Novel(String title, String author, String id, int year, boolean available, String genre) {
        super(title, author, id, year, available);
        this.genre = genre;
    }

    @Override
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Borrowed novel: \"" + title + "\"");
        } else {
            System.out.println("Novel \"" + title + "\" is not available.");
        }
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("Returned novel: \"" + title + "\"");
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void showDetails() {
        System.out.println("Novel: \"" + title + "\" by " + author + " (" + year + ") | Genre: " + genre);
    }
}

class Textbook extends Item implements Loanable {
    private String subject;

    public Textbook(String title, String author, String id, int year, boolean available, String subject) {
        super(title, author, id, year, available);
        this.subject = subject;
    }

    @Override
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Borrowed textbook: \"" + title + "\"");
        } else {
            System.out.println("Textbook \"" + title + "\" is not available.");
        }
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("Returned textbook: \"" + title + "\"");
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void showDetails() {
        System.out.println("Textbook: \"" + title + "\" by " + author + " | Subject: " + subject);
    }
}

class Magazine extends Item {
    private int issueNumber;

    public Magazine(String title, String author, String id, int year, int issueNumber) {
        super(title, author, id, year, true);
        this.issueNumber = issueNumber;
    }

    @Override
    public void showDetails() {
        System.out.println("Magazine: \"" + title + "\" | Issue #" + issueNumber + " (" + year + ")");
    }
}

public class mojaPiatnastaAplikacja {
    public static void main(String[] args) {
        Item[] catalog = {
                new Novel("Duma i uprzedzenie", "Jane Austen", "B001", 1813, true, "Romans"),
                new Textbook("Podstawy fizyki", "David Halliday", "T100", 2010, true, "Fizyka"),
                new Novel("Władca Pierścieni", "J.R.R. Tolkien", "B002", 1954, false, "Fantasy"),
                new Magazine("National Geographic", "Redakcja NG", "M045", 2023, 11)
        };

        for (Item item : catalog) {
            System.out.println("\n=== Katalog ===");
            item.showDetails();

            if (item instanceof Loanable) {
                Loanable loanable = (Loanable) item;
                if (loanable.isAvailable()) {
                    loanable.borrow();
                } else {
                    System.out.println("This item is currently borrowed.");
                }

                loanable.returnItem();
            }
        }
    }
}
