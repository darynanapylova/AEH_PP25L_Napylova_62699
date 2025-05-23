package pl.pp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class mojaDwunastaAplikacja {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Path inputFilePath;
        Path outputFilePath;

        // Wczytaj poprawną ścieżkę pliku wejściowego
        while (true) {
            System.out.print("Wprowadź ścieżkę do pliku wejściowego: ");
            String input = userInput.nextLine();
            inputFilePath = Path.of(input);

            if (Files.exists(inputFilePath) && Files.isReadable(inputFilePath)) {
                break;
            } else {
                System.out.println("Nie udało się odczytać pliku. Upewnij się, że ścieżka jest poprawna.");
            }
        }

        // Wczytaj ścieżkę do pliku wyjściowego
        System.out.print("Wprowadź ścieżkę do pliku wyjściowego: ");
        outputFilePath = Path.of(userInput.nextLine());

        try {
            List<String> inputLines = Files.readAllLines(inputFilePath);
            int totalLines = inputLines.size();

            System.out.println("Znaleziono " + totalLines + " linii w pliku.");

            String inputFileName = inputFilePath.getFileName().toString();
            List<String> summary = List.of(
                    "Nazwa pliku: " + inputFileName,
                    "Liczba linii: " + totalLines
            );

            Files.write(outputFilePath, summary);
            System.out.println("Informacje zapisano do pliku: " + outputFilePath);

        } catch (IOException ex) {
            System.err.println("Błąd podczas przetwarzania plików:");
            ex.printStackTrace();
        } finally {
            userInput.close();
        }
    }
}
