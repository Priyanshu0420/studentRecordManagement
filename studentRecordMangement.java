import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentRecordMangament {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println();
            System.out.println("=============>>>>>>>>> Student Record Management <<<<<<<<<================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully....!!!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("Student not found!!");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    boolean foundUpdate = false;

                    for (Student s : students) {
                        if (s.id == updateId) {
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter new marks: ");
                            s.marks = sc.nextDouble();
                            System.out.println("Student updated!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate)
                        System.out.println("Student not found!!");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;
                    for (Student s : students) {
                        if (s.id == deleteId) {
                            students.remove(s);
                            System.out.println("Student deleted!!");
                            foundDelete = true;
                            break;
                        }
                    }

                    if(!foundDelete)
                        System.out.println("Student not found!!");
                    break;

                case 5:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid choice!!");
            }

        } while (choice != 5);
    }
}
