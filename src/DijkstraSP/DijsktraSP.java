package DijkstraSP;

import EdgeWeighted.DirectedEdge;
import EdgeWeighted.EdgeWeightedDirectedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;

public class DijsktraSP
{
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DijsktraSP(EdgeWeightedDirectedGraph graph, int s)
    {
        distTo = new double[graph.v()];
        for (int i = 0; i < distTo.length; i++)
        {
            distTo[i] = Double.MAX_VALUE;
        }

        edgeTo = new DirectedEdge[graph.v()];
        pq = new IndexMinPQ<>(graph.v());
        distTo[s] = 0;
        pq.insert(s, distTo[s]);

        while (!pq.isEmpty())
        {
            int v = pq.delMin();
            relax(graph, v);
        }

    }

    private void relax(EdgeWeightedDirectedGraph graph, int v)
    {
        for (DirectedEdge edge : graph.adj(v))
        {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight())
            {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (pq.contains(w))
                {
                    pq.decreaseKey(w, distTo[w]);
                }
                else
                {
                    pq.insert(w, distTo[w]);
                }
            }
        }

    }
}
