import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private int id;
    private String name;
    private float marks;
    public Student(int id, String name, float marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float getMarks() { return marks; }
    public void setMarks(float marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    float marks = sc.nextFloat();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2: 
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nStudent List:");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3: 
                    System.out.print("Enter ID of student to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    boolean foundUpdate = false;
                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            System.out.print("Enter new Name: ");
                            s.setName(sc.nextLine());
                            System.out.print("Enter new Marks: ");
                            s.setMarks(sc.nextFloat());
                            System.out.println("Student updated successfully!");
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }
                    break;

                case 4: 
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == deleteId) {
                            students.remove(i);
                            System.out.println("Student deleted successfully!");
                            foundDelete = true;
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
