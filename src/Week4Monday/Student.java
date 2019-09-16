package Week4Monday;

public class Student implements Comparable<Student>
{
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa)
    {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getGpa()
    {
        return gpa;
    }

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }


    @Override
    public int compareTo(Student o)
    {
        if ((o == null) || !(o instanceof Student))
        {
            throw new RuntimeException();
        }

        if (this.getId() < o.getId())
        {
            return -1;
        }
        else if (this.getId() > o.getId())
        {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString()
    {
        return "ID:" + id + " Name:" + name + " GPA:" + gpa;
    }
}
