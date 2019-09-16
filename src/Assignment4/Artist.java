/*
        Author: Stuart Larsen
        Date: 6/19/2019
        Course: Algorithms Winter 2019
        Assignment: 4
        Instructor: Fatma Serce
        Synopsis: This class contains information about Artists. It stores properties such as ID, Name, Listen count
                  It also overrides compareTo in order to use Artists in a MinPQ data structure
 */

package Assignment4;

public class Artist implements Comparable<Artist>
{
    private int id;
    private String name;
    private double listeningCount;


    public double getListeningCount()
    {
        return listeningCount;
    }

    public void setListeningCount(double listeningCount)
    {
        this.listeningCount = listeningCount;
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

    // Used to compare Artist objects in MinPQ
    @Override
    public int compareTo(Artist o)
    {
        Double doubleObj = this.getListeningCount();
        Double doubleObj2 = o.getListeningCount();
        return doubleObj.compareTo(doubleObj2);
    }
}
