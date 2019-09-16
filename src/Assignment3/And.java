/*
        Author: Stuart Larsen
        Date: 5/28/2019
        Course: Algorithms Winter 2019
        Assignment: 3
        Instructor: Fatma Serce
        Synopsis: This class is a logical operator that takes in two Query<T> types and runs execute on all parameters
 */

package Assignment3;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public class And<T extends Comparable<T>> implements Query<T>
{
    private Query<T> expression1;
    private Query<T> expression2;

    public And(Query<T> expression1, Query<T> expression2)
    {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    // Retreives the trees for both queries passed into And, and then checks to see if the values in one also appear in the other
    // Returns new set where both IDs occur in both given sets.
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap)
    {
        HashSet<Integer> expression1Set = expression1.execute(indexTreeMap);
        HashSet<Integer> expression2Set = expression2.execute(indexTreeMap);
        HashSet<Integer> andSet = new HashSet<Integer>();

        for (int id : expression1Set)
        {
            if (expression2Set.contains(id))
            {
                andSet.add(id);
            }
        }

        return andSet;
    }

    // Not implemented or used within the And class
    @Override
    public T getField()
    {
        return null;
    }
}
