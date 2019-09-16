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

public class Or<T extends Comparable<T>> implements Query<T>
{
    private Query<T> expression1;
    private Query<T> expression2;
    public Or(Query<T> expression1, Query<T> expression2)
    {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    // Returns a set of IDs
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap)
    {
        HashSet<Integer> expression1Set = expression1.execute(indexTreeMap);
        HashSet<Integer> expression2Set = expression2.execute(indexTreeMap);
        HashSet<Integer> orSet = new HashSet<Integer>();

        for (int id : expression1Set)
        {
            if (!expression2Set.contains(id))
            {
                orSet.add(id);
            }
        }

        return orSet;
    }

    // Not implemented or necessary for the Or class
    @Override
    public T getField()
    {
        return null;
    }
}
