/*
    Author: Stuart Larsen
    Date: 4/22/2019
    Course: Algorithms Winter 2019
    Assignment: 1 Part 2 question 4
    Instructor: Fatma Serce
    Synopsis: This program performs substring pattern matching
 */

package Assignment1SubstringPatternMatching;

public class StringPatternMatcher
{
    public static void main(String[] args)
    {
        // Additional test cases
        String s1 = "abc";
        String p1 = "bc";
        System.out.println(patternMatch(s1, p1));

        String s2 = "mr sigma teaches math";
        String p2 = "each";
        System.out.println(patternMatch(s2, p2));

        String s3 = "";
        String p3 = "b";
        System.out.println(patternMatch(s3, p3));
    }

    /*
        This function takes in two parameters, a string, and a pattern
        It checks to see if and where the pattern appears within the string
        Runtime: o(n * m) because the function loops over the given input string and pattern once and has checks within that loop to
        increment and continue traversing the pattern. There is no need for a second loop to traverse the pattern.
     */
    public static int patternMatch(String s, String p)
    {

        // Simple checks to see if the string is shorter than the pattern's length. If it is, the pattern does not exist.
        if (s.length() < p.length())
        {
            System.out.print("String smaller than pattern ");
            return -1;
        }

        // If the pattern is empty, the string does not contain the pattern.
        if (p.length() == 0)
        {
            System.out.print("Pattern empty ");
            return -1;
        }

        int startIndex = -1;
        int pIndex = 0;
        for (int i = 0; i < s.length(); i++) // Loop over the string looking for any matches of the pattern
        {
            if (s.charAt(i) != p.charAt(pIndex)) // As long as the characters don't match, set the pattern's index to 0
            {
                pIndex = 0;
            }
            else
            {
                if (pIndex == 0)
                {
                    startIndex = i; // Variable to store where the pattern begins within the string
                }
                pIndex++;
                /*
                    Check to see if the end of the pattern has been reached. If so, return the index
                    at which the pattern started
                 */
                if (pIndex == p.length())
                {
                    return startIndex;
                }
            }
        }

        return -1;
    }
}

