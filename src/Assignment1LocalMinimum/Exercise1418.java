/*
    Author: Stuart Larsen
    Date: 4/22/2019
    Course: Algorithms Winter 2019
    Assignment: 1 Part 2 question 3
    Instructor: Fatma Serce
    Synopsis: This program looks for a local minimum in the given array. It must run in ~2(lgn) time in worst case
              A local minimum is an entry a[i] that is strictly less than its neighbors.
 */

package Assignment1LocalMinimum;

public class Exercise1418
{
    public static void main(String[] args)
    {
        // Test cases
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(localMins(a));

        int[] b = {7,6,5,4,3,2,1};
        System.out.println(localMins(b));

        int[] c = {8, 9, 10, 13, 12, 11, 14, 1, 16};
        System.out.println((localMins(c)));

        int[] d = {-8, -6, 18, 8, 20, 4, 40};
        System.out.println(localMins(d));

        int[] e = {};
        System.out.println(localMins(e));

        int[] f = {5, -4, 10, 16, 11, 20, 24, -10};
        System.out.println(localMins(f));

        int[] g = {-8, -6, 18, 8, 20, 4, 40};
        System.out.println(localMins(g));
    }

    // Function takes in an integer array and returns the value of a local minimum, if found within the array.
    // Local minimum is defined as an array entry a[i] that is strictly less than its neighbors.
    // This function is very similar to binary search in that it continually divides the problem in half.
    public static int localMins(int[] n)
    {
        int high = n.length - 1;
        int low = 0;
        int mid = low + (high + low) / 2;
        while (mid != 0 && mid != n.length - 1)
        {
            mid = low + (high - low) / 2;
            int midRight = mid + 1;
            int midLeft = mid - 1;
            /*
                if our mid value is 0 or array.length -1, that means that our local min is either the array at index 0
                or the last index
             */
            if (mid == 0 || mid == n.length - 1)
            {
                System.out.print("Local minimum:  ");
                return n[mid];
            }
            /*
                Check to see if the values of array[mid]'s neighbors are greater than it. If true, a local mind has been found
             */
            else if (n[mid] < n[midRight] && n[mid] < n[midLeft])
            {
                System.out.print("Local minimum:  ");
                return n[mid];
            }
            else if (n[mid] > n[midLeft]) // If array[mid] is > array[midLeft] we check the left side of the array
            {
                high = mid - 1;
            }
            else // If array[mid] > array[midRight], check the right side of the array
            {
                low = mid + 1;
            }
        }
        System.out.print("Local minimum not found: ");
        return -1;
    }
}



/*
First attempt, brute force. Runs in O(n) time.
 for (int i = 1; i < n.length - 1; i++)
 {
    if (n[i - 1] > n[i] && n[i + 1] > n[i])
    {
        System.out.println(n[i]);
        i++;
    }
 }
 */