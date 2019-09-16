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

public class Equal<T extends Comparable<T>> implements Query<T>
{
    private T field;
    private T property;

    public Equal(T field, T property)
    {
        this.field = field;
        this.property = property;
    }

    // Returns the set of IDs with the given parameter as the key
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap)
    {
        RedBlackBST<T, HashSet<Integer>> fieldIndexBST = new RedBlackBST<>();
        fieldIndexBST = indexTreeMap.get(field);
        return fieldIndexBST.get(property);
    }

    // Returns the field of the Query
    @Override
    public T getField()
    {
        return field;
    }

}
