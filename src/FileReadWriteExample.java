import java.io.*;

public class FileReadWriteExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output.txt")) {

            int data;
            while ((data = fr.read()) != -1) {
                fw.write(data);
            }
            System.out.println("Text file copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}