/*
    Author: Stuart Larsen
    Date: 4/22/2019
    Course: Algorithms Winter 2019
    Assignment: 1 Part 2 question 2
    Instructor: Fatma Serce
    Synopsis: This small program returns all values that appear in both the given sorted arrays
 */

package Assignment1ComparingTwoArrays;

import java.util.HashSet;

public class Exercise1412
{
    public static void main(String[] args)
    {


        int[] a = {0, 1, 1, 1, 1, 1, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6};
        int[] b = {0, 2, 2, 3, 4, 4, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
        appearInBoth(a, b);

        // Additional test cases
        /*
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 6, 7, 8};
        appearInBoth(a, b);

        int[] a = {1, 2, 3, 4, 6};
        int[] b = {4, 5, 6, 9, 10};
        appearInBoth(a, b);
        */
    }

    // This function, given two arrays will print out values that appear in BOTH given arrays
    public static void appearInBoth(int[] a, int[] b)
    {
        /*
        FIRST ATTEMPT
        This solution, using Binary Search runs at nlogn speed.

        for (int i = 0; i < a.length; i++)
        {
            if (Arrays.binarySearch(b, a[i]) >= 0)
            {
                System.out.println(a[i]);
            }
        }
         */


        int aIndex = 0;
        int bIndex = 0;
        HashSet<Integer> intersectionOfArrays = new HashSet<>();
        while (aIndex < a.length && bIndex < b.length) // The iteration will continue until we reach the end of 1 of the arrays
        {
            if (a[aIndex] == b[bIndex]) // If we find a match, add the number to a hash set
                                        // and then increment both counters to check the next value
            {
                intersectionOfArrays.add(a[aIndex]);
                aIndex++;
                bIndex++;
            }

            // If one of the values is greater than the other, we know that, to find a match
            // we need to keep incrementing through B until we either find or don't find a match
            else if (a[aIndex] > b[bIndex]) {
                bIndex++;
            }
            else
            {
                aIndex++;
            }
        }

        for (Integer num : intersectionOfArrays)
        {
            System.out.print(num + " ");
        }
    }
}
