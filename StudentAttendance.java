import java.util.ArrayList;
import java.util.Scanner;

class Student {
int id;
String name;
int totalClasses = 0;
int presentClasses = 0;

```
Student(int id, String name) {
    this.id = id;
    this.name = name;
}

void markAttendance(boolean present) {
    totalClasses++;
    if (present) {
        presentClasses++;
    }
}

double getPercentage() {
    if (totalClasses == 0) {
        return 0.0;
    }
    return (presentClasses * 100.0) / totalClasses;
}

void display() {
    System.out.println("ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("Classes Attended: " + presentClasses);
    System.out.println("Total Classes: " + totalClasses);
    System.out.printf("Attendance: %.2f%%\n", getPercentage());
    System.out.println("-------------------------");
}
```

}

public class StudentAttendance {
static ArrayList<Student> students = new ArrayList<>();
static Scanner sc = new Scanner(System.in);

```
public static void main(String[] args) {
    int choice;

    do {
        System.out.println("\n===== STUDENT ATTENDANCE SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Mark Attendance");
        System.out.println("4. View Attendance Report");
        System.out.println("5. Search Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        choice = readInt();

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                viewStudents();
                break;
            case 3:
                markAttendance();
                break;
            case 4:
                attendanceReport();
                break;
            case 5:
                searchStudent();
                break;
            case 6:
                System.out.println("Thank you for using the system!");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    } while (choice != 6);

    sc.close();
}

static int readInt() {
    while (!sc.hasNextInt()) {
        System.out.print("Please enter a valid number: ");
        sc.next();
    }
    int value = sc.nextInt();
    sc.nextLine();
    return value;
}

static Student findStudent(int id) {
    for (Student s : students) {
        if (s.id == id) {
            return s;
        }
    }
    return null;
}

static void addStudent() {
    System.out.print("Enter Student ID: ");
    int id = readInt();

    if (findStudent(id) != null) {
        System.out.println("Student ID already exists!");
        return;
    }

    System.out.print("Enter Student Name: ");
    String name = sc.nextLine().trim();

    if (name.isEmpty()) {
        System.out.println("Name cannot be empty.");
        return;
    }

    students.add(new Student(id, name));
    System.out.println("Student added successfully!");
}

static void viewStudents() {
    if (students.isEmpty()) {
        System.out.println("No students registered.");
        return;
    }

    System.out.println("\n===== REGISTERED STUDENTS =====");
    for (Student s : students) {
        System.out.println("ID: " + s.id + " | Name: " + s.name);
    }
}

static void markAttendance() {
    if (students.isEmpty()) {
        System.out.println("Please add students first.");
        return;
    }

    System.out.print("Enter Student ID: ");
    int id = readInt();

    Student s = findStudent(id);

    if (s == null) {
        System.out.println("Student not found.");
        return;
    }

    System.out.print("Present or Absent (P/A): ");
    String status = sc.nextLine().trim();

    if (status.equalsIgnoreCase("P")) {
        s.markAttendance(true);
        System.out.println("Attendance marked Present.");
    } else if (status.equalsIgnoreCase("A")) {
        s.markAttendance(false);
        System.out.println("Attendance marked Absent.");
    } else {
        System.out.println("Invalid status. Enter P or A.");
    }
}

static void attendanceReport() {
    if (students.isEmpty()) {
        System.out.println("No attendance records available.");
        return;
    }

    System.out.println("\n===== ATTENDANCE REPORT =====");
    for (Student s : students) {
        s.display();
    }
}

static void searchStudent() {
    System.out.print("Enter Student ID to search: ");
    int id = readInt();

    Student s = findStudent(id);

    if (s != null) {
        System.out.println("\nStudent Found!");
        s.display();
    } else {
        System.out.println("Student not found.");
    }
}
```

}
