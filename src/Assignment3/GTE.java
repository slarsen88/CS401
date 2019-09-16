/*
        Author: Stuart Larsen
        Date: 5/28/2019
        Course: Algorithms Winter 2019
        Assignment: 3
        Instructor: Fatma Serce
        Synopsis: This class is a logical operator that executes the query and returns a set
 */

package Assignment3;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public class GTE<T extends Comparable<T>> implements Query<T>
{
    private T field;
    private T property;
    public GTE(T field, T property)
    {
        this.field = field;
        this.property = property;
    }

    // Returns a hash set of IDs that are greater than or equal to the given parameter
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap)
    {
        RedBlackBST<T, HashSet<Integer>> fieldIndexBST = new RedBlackBST<>();
        HashSet<Integer> gte = new HashSet<Integer>();
        fieldIndexBST = indexTreeMap.get(field);

        for (T s : fieldIndexBST.keys())
        {
            if (greaterThanOrEqual(s))
            {
                for (int id : fieldIndexBST.get(s))
                {
                    gte.add(id);
                }
            }
        }

        return  gte;
    }

    // Returns the field of the Query
    @Override
    public T getField()
    {
        return field;
    }

    // Checks two objects for a greater than or equal to equivalence
    private boolean greaterThanOrEqual(Comparable s)
    {
        return s.compareTo(property) >= 0;
    }
}
