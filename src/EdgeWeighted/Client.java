package EdgeWeighted;

import edu.princeton.cs.algs4.In;

/*
4
5
0 1 2.3
1 2 1.8
0 3 2.7
2 3 1.5
1 3 0.7
 */



public class Client
{
    public static void main(String[] args)
    {
        In in = new In("data.txt");
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

        System.out.println(graph);
    }
}
