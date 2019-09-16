package EdgeWeighted;

import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedDirectedGraph
{
    private int v;
    private int e;
    private Bag<Edge>[] adj;

    public EdgeWeightedDirectedGraph(int v)
    {
        this.v = v;

        adj = new Bag[v];
        for (int i = 0; i < v; i++)
        {
            adj[i] = new Bag<Edge>();
        }
    }

    public void addEdge(Edge edge)
    {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        e++;
    }

    public Iterable<Edge> adj(int v)
    {
        return adj[v];
    }

    public int v()
    {
        return v;
    }

    public int e()
    {
        return e;
    }

    @Override
    public String toString()
    {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < v; i++)
        {
            strBuffer.append(i + ":");
            for (Edge e: adj(i))
            {
                strBuffer.append(e);
            }

            strBuffer.append("\n");

        }
        return strBuffer.toString();
    }
}
