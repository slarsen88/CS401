/*
    Author: Stuart Larsen
    Date: 4/22/2019
    Course: Algorithms Winter 2019
    Assignment: 1 Part 2 question 1
    Instructor: Fatma Serce
    Synopsis: This small program returns an integer (the number of trailing zeros) for all binary numbers
              from 1 -> n
 */

package Assignment1TrailingZeros;

public class TrailingZeros
{
    public static void main(String[] args)
    {
        // test cases for function
        System.out.println(numOfTrailingZeros(5));
        System.out.println(numOfTrailingZeros(8));
        System.out.println(numOfTrailingZeros(101));

    }

    /*
        Function that, given an n value, returns the number of trailing zeroes for all binary numbers
        from 1 -> n. There is a pattern with the binary numbers where only even numbers have trailing zeros,
        and the number of trailing zeros from 1 to n can be found by dividing n by 2 and incrementing a counter by n
        Run time: log(n)
            Our n value is continually being reduced by half, hence the log(n) runtime
            example: n = 4.....4/2 gives us 2, or the number of zeros in the 1s column. 2/2 gives us 1, or the number
                     of zeros in the 2s column
                     0001    1
                     0010    2
                     0011    3
                     0100    4
    */
    public static int numOfTrailingZeros(int n)
    {

        int numOfZeros = 0;
        while (n > 1)
        {
            n = n / 2;
            numOfZeros += n;
        }

        return numOfZeros;
    }
}


    /*
        *****ORIGINAL SUBMISSION*****
        Function that, given an n value, returns the number of trailing zeroes for all binary numbers
        from 1 -> n
        Run time: o(n)
            The outer for loop will run n times (input of function). The inner for loop will run at constant time
            due to the fact that we will never have more than 32 digits to travers (size of int in bits)
    */
//    public static int numOfTrailingZeros(int n)
//    {
//        int numOfZeros = 0;
//        for (int i = 1; i <= n; i++)
//        {
//            String numToBinary = Integer.toBinaryString(i);
//            int binaryStringyLength = numToBinary.length(); // convert the values to their binary string representation
//            for (int j = binaryStringyLength - 1; j>=0; j--) // iterate over the string in reverse
//            {
//                if (numToBinary.charAt(j) == '0')
//                {
//                    numOfZeros++;
//                }
//                else
//                {
//                    break;
//                }
//            }
//        }
//
//        return numOfZeros;




