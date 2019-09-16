package Week2Monday;

public class Student
{
    private int id;
    private String name;

    public Student()
    {
    }

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (!(obj instanceof Student))
        {
            return false;
        }

        if (this == obj)
        {
            return true;
        }

        return this.getId() == ((Student)obj).getId();
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
