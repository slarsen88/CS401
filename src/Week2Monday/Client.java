package Week2Monday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client
{
    public static void main(String[] args)
    {
        Set<Student> set = new HashSet<Student>();
        Student std1 = new Student(123, "Michael");
        Student std2 = new Student(123, "Michael");
        set.add(std1);
        set.add(std2);

        System.out.println(set.size());
        System.out.println(set.contains(new Student(123, "Michael")));
    }
}
