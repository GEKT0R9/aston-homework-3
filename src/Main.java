import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "test.txt";
        List<String> dataToWrite = List.of(
                "11",
                "Hello world!",
                "Привет мир!"
        );

        try {
            FileReadWrite.writeToFile(filePath, dataToWrite);
            System.out.println("Данные успешно записаны в файл.");
        } catch (FileOperationException e) {
            System.err.println("Ошибка при записи: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            List<String> readData = FileReadWrite.readFromFile(filePath);
            System.out.println("\nСодержимое файла:");
            readData.forEach(System.out::println);
        } catch (FileOperationException e) {
            System.err.println("Ошибка при чтении: " + e.getMessage());
            e.printStackTrace();
        }
    }
}