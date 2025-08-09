import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {

    public static void writeToFile(String filePath, List<String> data) throws FileOperationException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(filePath),
                        StandardCharsets.UTF_8
                )
        )) {

            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            throw new FileOperationException("Ошибка при записи в файл: " + filePath, e);
        }
    }

    public static List<String> readFromFile(String filePath) throws FileOperationException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath),
                        StandardCharsets.UTF_8
                )
        )) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new FileOperationException("Файл не найден: " + filePath, e);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка при чтении файла: " + filePath, e);
        }

        return lines;
    }
}
