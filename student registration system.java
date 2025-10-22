import java.io.*;
import java.util.Scanner;

class Student {
    String name;
    int age;
    String course;

    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String toString() {
        return name + ", " + age + ", " + course;
    }
}

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (FileWriter fw = new FileWriter("students.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter course: ");
            String course = sc.nextLine();

            Student student = new Student(name, age, course);
            out.println(student.toString());

            System.out.println("Student registered successfully!");

            System.out.println("\nAll Registered Students:");
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
