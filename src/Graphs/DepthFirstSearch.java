package Graphs;

import java.util.Iterator;
import java.util.Stack;
/*
 * Date: Spring, 2019
 * Description: The DepthFirstSearch class represents a data type for
 *  determining the vertices connected to a given source vertex
 *  in an undirected graph.
 */
public class DepthFirstSearch
{

    private boolean[] marked;	// marked[v] = is there an s-v path?
    private int[] edgeTo;		// edgeTo[v] = last edge on s-v path
    private int s;				// source vertex

    //Computes the vertices in graph g that are
    //connected to the source vertex s.
    public DepthFirstSearch(Graph g, int s)
    {
        this.s = s;
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        dfs(g, s);
    }

    //Is there a path between the source vertex s and vertex v?
    public boolean hasPath(int v) {
        return marked[v];
    }

    //Returns a path between the source vertex s and vertex v,
    //or null if no such path.
    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPath(v)) return null;

        Stack<Integer> path = new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x])
        {
            path.push(x);
        }
        path.push(s);

        return path;
    }

    //recursive depth first search
    // depth first search from v
//	private void dfs(Graph g, int v)
//	{
//		for(int w: g.adj(v))
//		{
//			if(!marked[w])
//			{
//				marked[w] = true;
//				edgeTo[w] = v;
//				dfs(g, w);
//			}
//		}
//
//	}

    //	//iterative depth first search
    // depth first search from v
    private void dfs(Graph g, int s)
    {
        Stack<Integer> stack = new Stack<Integer>();
        Iterator<Integer>[] iterators = new Iterator[g.v()];
        for(int i=0; i<g.v();i++)
        {
            iterators[i] = g.adj(i).iterator();
        }

        marked[s] = true;
        edgeTo[s] = s;
        stack.push(s);
        while(!stack.isEmpty())
        {
            int v = stack.peek();
            if(iterators[v].hasNext())
            {
                int w = iterators[v].next();
                if(!marked[w])
                {
                    marked[w] = true;
                    edgeTo[w] = v;
                    stack.push(w);
                }
            }
            else
            {
                stack.pop();
            }
        }
    }
}
