import java.io.*;

public class FileCopyPerformanceTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        copyUsingStreams();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using Streams: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        copyUsingBufferedStreams();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using Buffered Streams: " + (endTime - startTime) + " ms");
    }

    private static void copyUsingStreams() {
        try (FileInputStream fis = new FileInputStream("source.txt");
             FileOutputStream fos = new FileOutputStream("destination.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyUsingBufferedStreams() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("source.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("destination.txt"))) {
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
