package Kruskal;

import EdgeWeighted.Edge;
import EdgeWeighted.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;

public class Client
{
    public static void main(String[] args)
    {
        In in = new In("data2.txt");
        int vertices = in.readInt(); // 4
        int edges = in.readInt(); // 5
        EdgeWeightedGraph graph = new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++)
        {
            int v = in.readInt(); // i = 0: 0
            int w = in.readInt(); // i = 0: 1
            double weight = in.readDouble(); // i = 0: 2.3
            Edge edge = new Edge(v, w, weight);
            graph.addEdge(edge);
        }

        KruskalMST mst = new KruskalMST(graph);
        System.out.println(mst.weight());
        System.out.println(mst.mst());
    }
}
