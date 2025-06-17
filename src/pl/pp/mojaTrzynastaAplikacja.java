package pl.pp;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class mojaTrzynastaAplikacja {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Path inputPath = promptForInputFile(userInput);
        Path outputPath = promptForOutputFile(userInput);

        analyzeAndSaveWordData(inputPath, outputPath);

        userInput.close();

        System.out.println("Operation completed successfully. Output saved to: " + outputPath);
    }

    private static Path promptForInputFile(Scanner scanner) {
        while (true) {
            System.out.print("Please enter the path to the source text file: ");
            String input = scanner.nextLine();
            File file = new File(input);

            if (file.exists() && file.isFile()) {
                return file.toPath();
            } else {
                System.out.println("Invalid file. Make sure it exists and is a regular file.");
            }
        }
    }

    private static Path promptForOutputFile(Scanner scanner) {
        System.out.print("Please enter the desired path for the output file: ");
        return Paths.get(scanner.nextLine());
    }

    private static void analyzeAndSaveWordData(Path inputFile, Path outputFile) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        int wordCount = 0;

        String sourceFileName = inputFile.getFileName().toString();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile.toFile()))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] tokens = currentLine.toLowerCase().split("\\s+");

                for (String token : tokens) {
                    String word = token.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read from input file: " + e.getMessage());
            return;
        }

        System.out.println("\n--- Word Analysis ---");
        System.out.println("File: " + sourceFileName);
        System.out.println("Total words: " + wordCount);
        System.out.println("Word counts:");
        frequencyMap.forEach((k, v) -> System.out.println(k + ": " + v));

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile.toFile())))) {
            pw.println("Source file: " + sourceFileName);
            pw.println("Total words: " + wordCount);
            pw.println();
            pw.println("Word Frequencies:");
            frequencyMap.forEach((k, v) -> pw.println(k + ": " + v));
        } catch (IOException e) {
            System.err.println("Failed to write to output file: " + e.getMessage());
        }
    }
}
