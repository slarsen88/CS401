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

public class GT<T extends Comparable<T>> implements Query<T>
{
    private T field;
    private T property;
    public GT(T field, T property)
    {
        this.field = field;
        this.property = property;
    }

    // Returns a hashset of all IDs that are greater than the given parameter
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap)
    {
        RedBlackBST<T, HashSet<Integer>> fieldIndexBST = new RedBlackBST<>();
        HashSet<Integer> gt = new HashSet<Integer>();
        fieldIndexBST = indexTreeMap.get(field);

        for (T s : fieldIndexBST.keys())
        {
            if (greaterThan(s))
            {
                for (int id : fieldIndexBST.get(s))
                {
                    gt.add(id);
                }
            }
        }

        return  gt;
    }

    // Returns the field of the Query
    @Override
    public T getField()
    {
        return field;
    }

    // Checks two objects for greater than values
    private boolean greaterThan(Comparable s)
    {
        return s.compareTo(property) > 0;
    }
}
