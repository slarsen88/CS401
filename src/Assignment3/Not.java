/*
        Author: Stuart Larsen
        Date: 5/28/2019
        Course: Algorithms Winter 2019
        Assignment: 3
        Instructor: Fatma Serce
        Synopsis: This class is a logical operator that takes in a Query<T> type and runs execute on the given Query<T>
 */

package Assignment3;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public class Not<T extends Comparable<T>> implements Query<T>
{
    private Query<T> expression;
    public Not(Query<T> expression)
    {
        this.expression = expression;
    }

    // Returns a set of IDs that are NOT contained within the given query/parameter
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap)
    {
        T field = expression.getField();
        RedBlackBST<T, HashSet<Integer>> fieldIndexBST = new RedBlackBST<>();
        fieldIndexBST = indexTreeMap.get(field);
        HashSet<Integer> expressionSet = expression.execute(indexTreeMap);
        HashSet<Integer> allIDs = new HashSet<Integer>();
        HashSet<Integer> notSet = new HashSet<Integer>();

        for (T key : fieldIndexBST.keys())
        {
            for (int id : fieldIndexBST.get(key))
            {
                allIDs.add(id);
            }
        }

        for (int allID : allIDs)
        {
            if (!expressionSet.contains(allID))
            {
                notSet.add(allID);
            }
        }
        return notSet;
    }

    // Not implemented or necessary for Not
    @Override
    public T getField()
    {
        return null;
    }
}
