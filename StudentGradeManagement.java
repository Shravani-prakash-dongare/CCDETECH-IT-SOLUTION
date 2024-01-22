import java.util.*;

class Student {
    String name;
    int rollNumber;
    int[] marks;

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public double calculatePercentage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public String calculateGrade() {
        double percent = calculatePercentage();

        if (percent >= 90) {
            return "A";
        } else if (percent >= 80) {
            return "B";
        } else if (percent >= 70) {
            return "C";
        } else if (percent >= 60) {
            return "D";
        } else if (percent >= 50) {
            return "E";
        } else {
            return "F";
        }
    }
}

public class StudentGradeManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        while (true) {
            System.out.println("\nWelcome to Student Grade Management System \n");
            System.out.println(
                    "1. Add Student \n2. View Students List \n3. Update Student \n4. Delete Students \n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updatestudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close(); // Close the Scanner resource
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Student Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.println("Enter the number of Subjects: ");
        int numOfSubjects = scanner.nextInt();

        int marks[] = new int[numOfSubjects];
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.println("Enter Marks of Subject " + (i + 1));
            marks[i] = scanner.nextInt();
        }

        Student newStudent = new Student(name, rollNumber, marks);
        studentList.add(newStudent);
        System.out.println("Record Added Successfully");
    }

    public static void viewStudents() {
        System.out.println("\n--------------List Of Students-------------------- \n");
        for (Student student : studentList) {
            System.out.println("Name: " + student.name + "\nRoll No.: " + student.rollNumber + "\nPercentage: "
                    + student.calculatePercentage() + "%" + "\nGrade: " + student.calculateGrade());
            System.out.println("\n");
        }
    }

    public static void updatestudent() {
        System.out.println("Enter the roll no fo the student to update  data :");
        int rollno = scanner.nextInt();

        for (Student student : studentList) {
            if (student.rollNumber == rollno) {
                System.out.println("Enter new marks for each subject :");
                for (int i = 0; i < student.marks.length; i++) {
                    System.out.println("Subject " + (i + 1));
                    student.marks[i] = scanner.nextInt();
                }
                System.out.println("Student Marks Updated SuccessFully!");
                return;
            }
        }
        System.out.println("Student not found" + rollno);
    }

    private static void deleteStudent() {
        System.out.println("Enter the Roll no to delete :");
        int rollno = scanner.nextInt();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).rollNumber == rollno) {
                studentList.remove(i);
                System.out.println("Student data Deleted Successfully!");
                return;
            }
        }
        System.out.println("Student not found" + rollno);
    }
}
