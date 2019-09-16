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

public class LTE<T extends Comparable<T>> implements Query<T>
{
    private T field;
    private T property;
    public LTE(T field, T property)
    {
        this.field = field;
        this.property = property;
    }

    // Returns a set of IDs that are less than or equal to the given parameter
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap)
    {
        RedBlackBST<T, HashSet<Integer>> fieldIndexBST = new RedBlackBST<>();
        HashSet<Integer> lte = new HashSet<Integer>();
        fieldIndexBST = indexTreeMap.get(field);

        for (T s : fieldIndexBST.keys())
        {
            if (lessThanOrEqual(s))
            {
                for (int id : fieldIndexBST.get(s))
                {
                    lte.add(id);
                }
            }
        }

        return  lte;
    }

    // Returns the field of the query
    @Override
    public T getField()
    {
        return field;
    }

    // Checks two objects if they are LTE
    private boolean lessThanOrEqual(Comparable s)
    {
        return s.compareTo(property) <= 0;
    }

}
