package Graphs;
import java.util.LinkedList;
import java.util.List;
/*
 * Date: Spring, 2019
 * Description: A graph, implemented using an array of linked lists (adjacency list).
 * Parallel edges and self-loops allowed.
 */

public class Graph
{
    private int v;	//number of vertices
    private int e;
    private LinkedList<Integer>[] adj;

    //initializes an empty graph with
    //vertices and 0 edges.
    public Graph(int v)
    {
        this.v = v;
        this.e = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }
    //adds the undirected edge v-w to this graph.
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }

    //returns the vertices adjacent to vertex {@code v}.
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    //returns the number of vertices in this graph.
    public int v() {
        return v;
    }

    //returns the number of edges in this graph.
    public int e() {
        return e;
    }

    //returns the degree of vertex v.
    public int degree(int s)
    {
        int degree = 0;
        for(int w: adj(s))
        {
            degree++;
        }

        return degree;
    }

    //returns a string representation of this graph.
    @Override
    public String toString()
    {
        StringBuilder graphStr =new StringBuilder("");
        for (int i = 0; i < v; i++)
        {
            graphStr.append(i + ":");
            for(int w:adj[i])
            {
                graphStr.append(w + ":");
            }
            graphStr.append("\n");
        }

        return graphStr.toString();
    }
}
