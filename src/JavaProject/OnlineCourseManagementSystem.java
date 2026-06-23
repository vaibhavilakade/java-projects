package JavaProject;
import java.util.*;
import java.util.stream.Collectors;

class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String msg) {
        super(msg);
    }
}
class CourseDetails implements Comparable<CourseDetails> {

    private int courseId;
    private String courseName;
    private double fees;

    public CourseDetails(int courseId, String courseName, double fees) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fees = fees;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getFees() {
        return fees;
    }

    @Override
    public int compareTo(CourseDetails c) {
        return this.courseName.compareTo(c.courseName);
    }

    @Override
    public String toString() {
        return courseId + " | " + courseName + " | ₹" + fees;
    }
}

 class Student {

    private int studentId;
    private String studentName;
    private String courseName;
    private int progress;

    public Student(int studentId, String studentName,
                   String courseName, int progress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.progress = progress;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getProgress() {
        return progress;
    }

    @Override
    public String toString() {
        return studentId + " | " +
                studentName + " | " +
                courseName + " | " +
                progress + "%";
    }
}

public class OnlineCourseManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<CourseDetails> courses = new ArrayList<>();

        courses.add(new CourseDetails(101, "Java Full Stack", 30000));
        courses.add(new CourseDetails(102, "Python Full Stack", 30000));
        courses.add(new CourseDetails(103, "Oracle SQL", 5000));
        courses.add(new CourseDetails(104, "Java", 6000));
        courses.add(new CourseDetails(105, "Python", 6000));
        courses.add(new CourseDetails(106, "Spring Boot", 5000));

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Vaibhavi",
                "Java Full Stack", 90));

        students.add(new Student(2, "Tanaya",
                "Python Full Stack", 80));

        students.add(new Student(3, "Sandesh",
                "Java Full Stack", 95));

        students.add(new Student(4, "Kirti",
                "Spring Boot", 70));

        System.out.println("=========== AVAILABLE COURSES ===========");

        Collections.sort(courses);

        for (CourseDetails c : courses) {
            System.out.println(c);
        }

        try {

            System.out.print("\nEnter Course ID to Search: ");
            int id = sc.nextInt();

            boolean found = false;

            for (CourseDetails c : courses) {

                if (c.getCourseId() == id) {

                    System.out.println("\nCourse Found");
                    System.out.println(c);

                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new CourseNotFoundException(
                        "Course Not Found!");
            }

        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=========== ENROLLED STUDENTS ===========");

        students.forEach(System.out::println);

        System.out.println("\n=========== STUDENTS ABOVE 80% ===========");

        students.stream()
                .filter(s -> s.getProgress() > 80)
                .forEach(System.out::println);

        System.out.println("\n=========== SORTED BY PROGRESS ===========");

        students.stream()
                .sorted(Comparator.comparing(Student::getProgress))
                .forEach(System.out::println);

        System.out.println("\n=========== TOP STUDENT ===========");

        students.stream()
                .max(Comparator.comparing(Student::getProgress))
                .ifPresent(System.out::println);

        double average = students.stream()
                .mapToInt(Student::getProgress)
                .average()
                .orElse(0);

        System.out.println("\nAverage Progress = "
                + average + "%");

        System.out.println("\n=========== GROUPED BY COURSE ===========");

        Map<String, List<Student>> grouped =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getCourseName));

        grouped.forEach((course, list) -> {
            System.out.println(course + " -> " + list);
        });

        System.out.println("\n=========== STUDENT COUNT PER COURSE ===========");

        Map<String, Long> count =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getCourseName,
                                Collectors.counting()));

        count.forEach((course, total) ->
                System.out.println(course + " = " + total));

        sc.close();
    }
}