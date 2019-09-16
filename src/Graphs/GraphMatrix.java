package Graphs;

import java.util.ArrayList;
import java.util.List;
/*
 * Date: Spring, 2019
 * Description: A graph, implemented using an adjacency matrix.
 * Parallel edges are disallowed; self-loops are allowed.
 */

public class GraphMatrix
{
    private int v;	//number of vertices
    private int e;
    private boolean[][] adj;

    //initializes an empty graph with V vertices
    public GraphMatrix(int v)
    {
        this.v = v;
        this.e = 0;
        adj = new boolean[v][v];
    }

    //add a undirected edge v-w
    public void addEdge(int v, int w)
    {
        if(v != w) {
            if(!adj[v][w])
                e++;
            adj[v][w] = true;
            adj[w][v] = true;
        }
    }
    // return list of neighbors(adjacent vertices) of v
    public Iterable<Integer> adj(int s){
        List<Integer> adjList = new ArrayList<Integer>();
        for(int i=0;i<v;i++)
        {
            if (adj[s][i])
            {
                adjList.add(i);
            }
        }

        return adjList;
    }

    //removes the edge between the vertices, v and w
    public void removeEdge(int v, int w)
    {
        if(adj[v][w])
        {
            e--;
        }
        adj[v][w] = false;
        adj[w][v] = false;
    }

    //does the graph contain the edge v-w?
    public boolean hasEdge(int v, int w)
    {
        return adj[v][w];
    }

    //returns the number of vertices in the graph
    public int v()
    {
        return v;
    }

    //returns the number of edges in the graph
    public int e()
    {
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

    //String representation of Graph - takes quadratic time
    @Override
    public String toString()
    {
        StringBuilder graphStr =new StringBuilder("");
        for (int i = 0; i < v; i++)
        {
            graphStr.append(i + ":");
            for (int j = 0; j < v; j++)
            {
                if(adj[i][j])
                {
                    graphStr.append(j + " ");
                }
            }
            graphStr.append("\n");
        }
        return graphStr.toString();
    }
}
