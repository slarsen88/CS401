package Graphs;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle
{
    private boolean[] visited;
    private boolean[] onCyclePath;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(DirectedGraph digraph)
    {
        visited = new boolean[digraph.v()];
        onCyclePath = new boolean[digraph.v()];
        edgeTo = new int[digraph.v()];
        cycle = null;

        for (int v = 0; v < digraph.v(); v++)
        {
            if (!visited[v] && cycle == null)
            {
                dfs(digraph,v);
            }
        }
    }

    public boolean hasCycle()
    {
        return cycle != null;
    }

    public Iterable<Integer> cycle()
    {
        return cycle;
    }

    private void dfs(DirectedGraph digraph, int v)
    {
        visited[v] = true;
        onCyclePath[v] = true;
        for (int w : digraph.adj(v))
        {
            if (cycle != null)
            {
                return;
            }
            if (!visited[w])
            {
                edgeTo[w] = v;
                dfs(digraph, w);
            }
            else if (onCyclePath[w]) // we found cycle
            {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x])
                {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }

        onCyclePath[v] = false;
    }
}
