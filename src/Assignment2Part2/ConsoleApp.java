package Assignment2Part2;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import Sort.*;

public class ConsoleApp
{
    public int dataSize;

    public static void main(String[] args)
    {
        FrameGUI gui = new FrameGUI();
        // Ask for user input
        Scanner userInput = new Scanner(System.in);
        int dataSize = dataSize(userInput);
        String userSelection = sortedOrRandom(userInput);

        // Creates a file with sorted numbers, or a random bunch of numbers
        if (userSelection.equals("sorted"))
        {
            Comparable[] listOfSortedNums = generateSortedFile(dataSize);
            String sortingAlgorithm = chooseSortingAlgorithm(userInput);
            // start timer
            sortData(sortingAlgorithm, listOfSortedNums);
            // end timer
        }
        else
        {
            Comparable[] unsortedRandomNums = generateRandomFile(dataSize);
            String sortingAlgorithm = chooseSortingAlgorithm(userInput);
            // start timer
            sortData(sortingAlgorithm, unsortedRandomNums);
            // end timer
        }
    }


    // get the size of the data from the user
    public static int dataSize(Scanner userInput)
    {
        int dataSize = 0;
        System.out.print("Choose a data size from 1<->500000: ");
        dataSize = userInput.nextInt();
        return dataSize;
    }


    // get input from user on sorted or random file
    public static String sortedOrRandom(Scanner userInput)
    {
        String choice;
        System.out.print("Sorted or Random? ");
        choice = userInput.next().toLowerCase();
        boolean invalidOption = true;
        while (invalidOption)
        {
            if (choice.equals("sorted") || choice.equals("random"))
            {
                invalidOption = false;
                return choice;
            }
            else
            {
                System.out.print("Please choose a valid option (sorted or random): ");
                choice = userInput.next().toLowerCase();
            }
        }

        return "invalid";
    }

    // generate a file with sorted data based on what the user has selected (which sorting algorithm)
    public static Comparable[] generateSortedFile(int dataSize)
    {
        File file = new File("Sorted.txt");
        Comparable[] sortedNums = new Comparable[dataSize];
        try
        {
            PrintWriter writer = new PrintWriter("Sorted.txt", "UTF-8");
            for (int i = 0; i < dataSize; i++)
            {
                sortedNums[i] = i;
                writer.println(i);
            }
            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        return sortedNums;
    }

    private static String chooseSortingAlgorithm(Scanner userInput)
    {
        String algorithm = "";
        System.out.print("Select a sorting algorithm:\nSelection (1)\nInsertion (2)\nShell (3) \n" +
                        "Bubble (4)\nMerge (5)\nQuick (6)\nHeap (7)");
        int userChoice = userInput.nextInt();
        switch(userChoice)
        {
            case 1:
                algorithm = "selectionSort";
                break;
            case 2:
                algorithm = "insertionSort";
                break;
            case 3:
                algorithm = "shellSort";
                break;
            case 4:
                algorithm = "bubbleSort";
                break;
            case 5:
                algorithm = "mergeSort";
                break;
            case 6:
                algorithm = "quickSort";
                break;
            case 7:
                algorithm = "heapSort";
                break;
        }

        return algorithm;
    }

    // generate a file with random ints
    public static Comparable[] generateRandomFile(int dataSize)
    {
        File file = new File("random.txt");
        Comparable[] randomNums = generateRandomNumbers(dataSize);
        try
        {
            PrintWriter writer = new PrintWriter("random.txt", "UTF-8");
            for (Comparable num : randomNums)
            {
                writer.println(num);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        return randomNums;
    }

    // test method to generate random numbers
    public static Comparable[] generateRandomNumbers(int dataSize)
    {
        Comparable[] x = new Comparable[dataSize];
        Random ran = new Random();
        for (int i = 0; i < dataSize; i++)
        {
            int random = ran.nextInt(dataSize);
            System.out.println(random);
            x[i] = random;
        }

        return x;
    }

    private static void sortData(String sortingAlgorithm, Comparable[] listOfUnsortedNum)
    {
        Sort sort = new Sort();
        switch(sortingAlgorithm)
        {
            case "selectionSort":
                sort.selectionSort(listOfUnsortedNum);
                break;
            case "insertionSort":
                sort.insertionSort(listOfUnsortedNum);
                break;
            case "shellSort":
                sort.shellSort(listOfUnsortedNum);
                break;
            case "bubbleSort":
                sort.bubbleSort(listOfUnsortedNum);
                break;
            case "mergeSort":
                sort.mergeSort(listOfUnsortedNum, 0, listOfUnsortedNum.length - 1);
                break;
            case "quickSort":
                sort.quickSort(listOfUnsortedNum, 0, listOfUnsortedNum.length - 1);
                break;
//            case "heapSort":
//                sort.heapSort(listOfUnsortedNum);
//                break;
        }
        //return listOfUnsortedNum; // RENAME THIS IT'S SORTED WHEN RETURNED
    }
}
