package JavaProject;
import java.util.*;

class Student implements Comparable<Student>{
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks)
    {
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    @Override
    public int compareTo(Student s)
    {
        return this.name.compareTo(s.name);
    }
    @Override
    public String toString()
    {
        return id+" "+name+" "+marks;
    }
}

class MarksComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2)
    {
        return Double.compare(s2.marks, s1.marks);
    }
}
public class StudentRecordManagement {
    public static void main(String[] args)
    {
        ArrayList<Student> students=new ArrayList<>();
        HashSet<Integer> ids=new HashSet<>();
        HashMap<Integer, Student> studentMap=new HashMap<>();
        TreeMap<Integer, Student> sortedMap=new TreeMap<>();

        Student s1 = new Student(101, "Vaibhavi", 85);
        Student s2 = new Student(102, "Archana", 90);
        Student s3 = new Student(103, "Tanaya", 78);

        Student[] arr = {s1, s2, s3};

        for(Student s:arr)
        {
            if(ids.add(s.id))
            {
                students.add(s);
                studentMap.put(s.id,s);
                sortedMap.put(s.id,s);
            }
        }
        System.out.println("Students List: ");
        for (Student s:students)
        {
            System.out.println(s);
        }
        System.out.println("\nSearch Student By ID 102:");
        System.out.println(studentMap.get(102));

        Collections.sort(students);

        System.out.println("\nSorted By Name (Comparable):");
        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students, new MarksComparator());

        System.out.println("\nSorted By Marks (Comparator):");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nTreeMap Records (Sorted By ID):");

        for (Map.Entry<Integer, Student> entry : sortedMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
