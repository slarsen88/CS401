package Kruskal;

import EdgeWeighted.Edge;
import EdgeWeighted.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class KruskalMST
{
    private Queue<Edge> mst; //edges in MST
    private MinPQ<Edge> pq;
    private UF uf;
    private double weight;

    public KruskalMST(EdgeWeightedGraph graph)
    {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        uf = new UF(graph.v());

        // store all edges in minPQ

        for (int v = 0; v < graph.v(); v++)
        {
            for (Edge edge : graph.adj(v))
            {
                if (edge.other(v) > v)
                {
                    pq.insert(edge);
                }
            }
        }

        while (!pq.isEmpty() || mst.size() != graph.v() - 1)
        {
            Edge minEdge = pq.delMin();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (!uf.connected(v, w))
            {
                mst.enqueue(minEdge);
                uf.union(v, w);
                weight += minEdge.weight();
            }
        }
    }

    public double weight()
    {
        return weight;
    }

    public Iterable<Edge> mst()
    {
        return mst;
    }


}
