package Week4Monday;

import java.util.Arrays;

public class StudentTest
{
    public static void main(String[] args)
    {
        Student[] students = new Student[4];
        students[0] = new Student(12, "A", 3.4);
        students[1] = new Student(22, "C", 1.4);
        students[2] = new Student(34, "B", 3.7);
        students[3] = new Student(10, "D", 2.6);

        Arrays.sort(students);
        Arrays.sort(students, new StudentIDComparator());
        Arrays.sort(students, new StudentGPAComparator());
        for (Student s : students)
        {
            System.out.println(s);
        }
    }
}
