package EdgeWeighted;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class PrimLazy
{
    private Queue<Edge> mst;
    private boolean[] marked;
    private MinPQ<Edge> pq;
    private double weight;

    public PrimLazy(EdgeWeightedGraph graph)
    {
        marked = new boolean[graph.v()];
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();

        for (int v = 0; v < graph.v(); v++)
        {
            if (!marked[v])
            {
                prim(graph, v);
            }
        }

    }

    private void prim(EdgeWeightedGraph graph, int s)
    {
        scan(graph, s);
        while (!pq.isEmpty())
        {
            Edge minEdge = pq.delMin();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (marked[v] && marked[w])
            {
                continue;
            }

            mst.enqueue(minEdge);
            weight += minEdge.weight();

            if (!marked[v])
            {
                scan(graph, v);
            }
            if (!marked[w])
            {
                scan(graph, w);
            }
        }
    }

    private void scan(EdgeWeightedGraph graph, int v)
    {
        marked[v] = true;
        for (Edge edge : graph.adj(v))
        {
            int w = edge.other(v);
            if (!marked[w])
            {
                pq.insert(edge);
            }
        }
    }
}
