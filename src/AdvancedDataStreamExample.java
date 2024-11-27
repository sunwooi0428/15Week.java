import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdvancedDataStreamExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of people:");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Enter name for person " + (i + 1) + ":");
            String name = scanner.nextLine();
            System.out.println("Enter age for person " + (i + 1) + ":");
            int age = Integer.parseInt(scanner.nextLine());
            people.add(new Person(name, age));
        }

        // 데이터 직렬화 및 파일에 저장
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.dat"))) {
            oos.writeObject(people);
            System.out.println("People data serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 데이터 역직렬화 및 읽기
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.dat"))) {
            List<Person> deserializedPeople = (List<Person>) ois.readObject();
            System.out.println("Deserialized people data:");
            deserializedPeople.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}