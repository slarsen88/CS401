package Graphs;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder
{
    private boolean[] marked;
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;

    public DepthFirstOrder(DirectedGraph graph)
    {
        marked = new boolean[graph.v()];
        preOrder = new Queue<Integer>();
        postOrder = new Queue<Integer>();

        for (int i = 0; i < graph.v(); i++)
        {
            if (!marked[i])
            {
                dfs(graph, i);
            }
        }
    }

    public Iterable<Integer> preOrder()
    {
        return preOrder;
    }

    public Iterable<Integer> postOrder()
    {
        return postOrder;
    }

    public Iterable<Integer> reversePostOrder()
    {
        Stack<Integer> reverse = new Stack<>();
        for (Integer item : postOrder)
        {
            reverse.push(item);
        }

        return reverse;
    }

    private void dfs(DirectedGraph graph, int v)
    {
        marked[v] = true;
        preOrder.enqueue(v);
        for (int w : graph.adj(v))
        {
            if (!marked[v])
            {
                dfs(graph, w);
            }
        }

        postOrder.enqueue(v);
    }


}
