package Graphs;
import java.util.Stack;

import edu.princeton.cs.algs4.Queue;
/*
 * Date: Spring, 2019
 * Description: Run breadth first search on an undirected graph.
 * Runs in O(E + V) time.
 */
public class BreadthFirstSearch
{

    private boolean[] marked;	// marked[v] = is there an s-v path
    private int[] edgeTo;		// edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;		// distTo[v] = number of edges shortest s-v path
    private int s;

    //Computes the shortest path between the source vertex s
    //and every other vertex in the graph g.
    BreadthFirstSearch(Graph graph, int s)
    {
        this.s = s;
        int v = graph.v();
        marked = new boolean[v];
        edgeTo = new int[v];
        distTo = new int[v];
        for (int i = 0; i < distTo.length; i++)
        {
            distTo[i] = Integer.MAX_VALUE;
        }
        bfs(graph, s);
    }

    // breadth-first search from a source vertex s
    private void bfs(Graph graph, int s)
    {
        Queue<Integer> queue = new Queue<Integer>();

        marked[s] = true;
        edgeTo[s] = s;
        distTo[s] = 0;
        queue.enqueue(s);
        while(!queue.isEmpty())
        {
            int v = queue.dequeue();
            for(int w: graph.adj(v))
            {
                if(!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.enqueue(w);
                }
            }
        }
    }

    //Is there a path between the source vertex s and vertex v?
    public boolean hasPath(int v) {
        return marked[v];
    }

    //Returns a shortest path between the source vertex s
    //and v, or null if no such path.
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

    //Returns the number of edges in a shortest path between the source vertex s
    //and vertex v?
    public int distanceTo(int v) {
        return distTo[v];
    }
}
