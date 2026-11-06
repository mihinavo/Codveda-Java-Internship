
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        int lineCount = 0;
        int wordCount = 0;
        int characterCount = 0;

        try {
            BufferedReader reader = new BufferedReader(
                new FileReader(inputFile)
            );

            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                String trimmedLine = line.trim();

                if (!trimmedLine.isEmpty()) {
                    wordCount += trimmedLine.split("\\s+").length;
                }

                characterCount += line.length();
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(
                new FileWriter(outputFile)
            );

            writer.write("FILE HANDLING RESULTS");
            writer.newLine();
            writer.write("---------------------");
            writer.newLine();
            writer.write("Total Lines: " + lineCount);
            writer.newLine();
            writer.write("Total Words: " + wordCount);
            writer.newLine();
            writer.write("Total Characters: " + characterCount);
            writer.newLine();

            writer.close();

            System.out.println("File processed successfully!");
            System.out.println("Results saved in " + outputFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
