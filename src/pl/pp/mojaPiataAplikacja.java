package pl.pp;

public class mojaPiataAplikacja {


    public static void printRectangle(char symbol, int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        char symbolToPrint = '-';
        int rectangleWidth = 9;
        int rectangleHeight = 4;

        printRectangle(symbolToPrint, rectangleWidth, rectangleHeight);

    }
}