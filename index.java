import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
public class FileHandlingUtility {

    // Define file path
    private static final Path FILE_PATH = Paths.get("file.txt");

    // Method to write text to a file (creates or overwrites)
    public static void writeFile(String content) throws IOException {
        Files.write(FILE_PATH, content.getBytes());
        System.out.println("Write operation completed.");
    }

    // Method to read text from a file
    public static void readFile() throws IOException {
        System.out.println("\nFile contents:");
        List<String> lines = Files.readAllLines(FILE_PATH);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    // Method to modify the file by appending text
    public static void modifyFile(String content) throws IOException {
        Files.write(
                FILE_PATH,
                content.getBytes(),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE
        );
        System.out.println("\nModify operation completed.");
    }

    // Main method
    public static void main(String[] args) {
        try {
            writeFile("Java File Handling Utility\n");
            readFile();
            modifyFile("This line was added to modify the file.\n");
            readFile();
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
