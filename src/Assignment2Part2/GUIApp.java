/*
    Author: Stuart Larsen
    Date: 5/10/2019
    Course: Algorithms Winter 2019
    Assignment: 2 Part 2
    Instructor: Fatma Serce
    Synopsis: This program works with the FrameGUI and has a few methods that run based on how the user interacts with
              the UI
 */

package Assignment2Part2;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GUIApp
{
    public static int dataSize;
    public static String userSelection;
    public static Comparable[] listOfNums;


    // generate a file with sorted data based on which sorting algorithm the user has selected
    public static void generateFile(Comparable[] sortedNums, int dataSize)
    {
        String fileName = "";
        if (userSelection.equals("sorted"))
        {
            fileName = fileName.format("Sorted%d.txt", dataSize);
        }
        else
        {
            fileName = fileName.format("Random%d.txt", dataSize);
        }

        File file = new File(fileName);

        try
        {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (int i = 0; i < sortedNums.length; i++)
            {
                writer.println(sortedNums[i]);
            }
            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }


    // Generates a list of random numbers to be sorted later
    public static Comparable[] generateRandomNumbers(int dataSize)
    {
        Comparable[] randomNums = new Comparable[dataSize];
        Random ran = new Random();
        int random;
        for (int i = 0; i < dataSize; i++)
        {
            random = ran.nextInt(dataSize);
            randomNums[i] = random;
        }

        return randomNums;
    }


    // Generates a list of sorted numbers
    public static Comparable[] generateSortedNumbers(int dataSize)
    {
        Comparable[] sortedNums = new Comparable[dataSize];
        for (int i = 0; i < dataSize; i++)
            {
                sortedNums[i] = i;
            }

        return sortedNums;
    }
}
