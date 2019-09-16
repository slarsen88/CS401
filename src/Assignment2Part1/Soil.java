/*
    Author: Stuart Larsen
    Date: 5/10/2019
    Course: Algorithms Winter 2019
    Assignment: 2 Part 1
    Instructor: Fatma Serce
    Synopsis: This program utilizes union find to see if there is a connected path from the top row to the bottom row
              of a given 2d array
 */

package Assignment2Part1;
import UnionFind.*;
import edu.princeton.cs.algs4.In;

public class Soil
{
    public static void main(String[] args)
    {
        int n = findArrayDimensions();
        int[][] a = readFile(n);
        UnionFind uf = new WeightedQuickUnionPathCompression(n * n);
        unionRows(a, uf);
        unionColumns(a, uf, n);
        findTopAndBottomRow(a, uf, n);
    }

    // Finds the dimensions of the array in the given .txt file
    public static int findArrayDimensions()
    {
        In in = new In("sample2.txt");
        int lineCount = 0;
        while (!in.isEmpty())
        {
            lineCount++;
            in.readLine();
        }

        return lineCount;
    }

    // Reads the given file and returns a 2d array from the given data
    public static int[][] readFile(int dimensions)
    {
        In in = new In("sample2.txt");
        int[][] a = new int[dimensions][dimensions];
        int row = 0;
        int col = 0;
        while (!in.isEmpty())
        {
            if (col < dimensions)
            {
                a[row][col] = in.readInt();
                col++;
            }
            else
            {
                row++;
                col = 0;
            }
        }

        return a;
    }

    // Traverse the 2d array row by row and union values that are next to one another if they are both "1"
    public static void unionRows(int[][] a, UnionFind uf)
    {
        int index = 0; // Keep a variable for an index to map the 2d array into a 1d array
        for (int row = 0; row < a.length; row++)
        {
            for (int col = 0; col < a.length - 1; col++)
            {

                if (a[row][col] == 1 && a[row][col + 1] == 1)
                {
                    uf.union(index, index + 1); // union the indices in our 1d array id[]
                }
                index++;
            }
            index++;
        }
    }

    // Traverse the 2d array column by column and union values that are on top of one another if they are both "1"
    public static void unionColumns(int[][] a, UnionFind uf, int n)
    {
        int index = 0; // store index variable to map 2d array into 1d array indices
        for (int col = 0; col < a.length; col++)
        {
            for (int row = 0; row < a.length - 1; row++)
            {
                if (a[row][col] == 1 & a[row + 1][col] == 1)
                {
                    uf.union(index, index + n);
                }
                index += n;
            }

            if (col <= a.length - 1)
            {
                index = col + 1;
            }
        }
    }

    // Traverse the top and bottom rows and run "find()" on each index. Print if a path is or is not found
    public static void findTopAndBottomRow(int[][] a, UnionFind uf, int n)
    {
        int indexTopRow = 0;
        for (int col = 0; col < a.length; col++)
        {
            int indexBotRow = (n * n) - n;
            for (int i = 0; i < a.length; i++)
            {
                if (uf.find(indexTopRow, indexBotRow))
                {
                    System.out.println("Allows water to drain");
                    return;
                }
                indexBotRow++;
            }

            if (col <= a.length - 1)
            {
                indexTopRow = col + 1;
            }
        }

        System.out.println("Doesn't allow water to drain");
    }
}
